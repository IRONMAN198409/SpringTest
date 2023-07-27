package com.ironman.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironman.spring.test.jpa.domain.Company;
import com.ironman.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;

	public Company addCompany(String name, String business, String scale, int headcount) {
		Company company = Company.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build();
		
		company = companyRepository.save(company);
		return company;
	}
	
	
	public Company updateCompany(int id, String scale, int headcount) {
		
		// 1. id를 기준으로 데이터 조회
		// 2. 조회된 객체에 수정사항 적용
		// 3. 저장
		Company company = companyRepository.findById(id).orElse(null);
		if(company != null) {
			company = company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build();
			
			company = companyRepository.save(company);
		}
		return company;
	}
	
	

	
//	public Company updateCompany(int id, String scale, int headcount) {
//		Optional<Company> optionalCompany = companyRepository.findById(id);
//		Company company = optionalCompany.orElse(null);
//		
//		if(company != null) {
//			company = company.toBuilder()
//			.scale(scale)
//			.headcount(headcount)
//			.build();
//			
//			company = companyRepository.save(company);
//		}
//		return company;
//	}
	
	// 람다식으로 해결
	public void deleteCompany(int id) {
		companyRepository.findById(id).ifPresent(company -> companyRepository.delete(company));
	}
	
//	public void deleteCompany(int id) {
//		Optional<Company> optionalCompany = companyRepository.findById(id);
//		optionalCompany.ifPresent(Company -> companyRepository.delete(Company));
//	}
}
