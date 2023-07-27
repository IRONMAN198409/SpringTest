package com.ironman.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironman.spring.test.jpa.domain.Company;
import com.ironman.spring.test.jpa.service.CompanyService;

@Controller
@RequestMapping("/jpa/compnay")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/add")
	@ResponseBody
	public List<Company> createCompany() {
		
		List<Company> companyList = new ArrayList<>();
		Company company = companyService.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
		companyList.add(company);
		company = companyService.addCompany("버블팡", "여신 금융업", "대기업", 6843);
		companyList.add(company);
		
		return companyList;
	}
	
	
//	public List<Company> createCompany() {
//		List<Company> companyList = new ArrayList<>();
//		
//		String name = "넥손";
//		String business ="컨텐츠 게임";
//		String scale ="대기업";
//		int headcount = 3585;
//		
//		Company company1 = companyService.addCompany(name, business, scale, headcount);
//		companyList.add(company1);
//		
//		name = "버블팡";
//		business ="여신 금융업";
//		scale ="대기업";
//		headcount = 6934;
//		
//		Company company2 = companyService.addCompany(name, business, scale, headcount);
//		companyList.add(company2);
//		
//		return companyList;
//	}
	
	
	@GetMapping("/update")
	@ResponseBody
	public Company updateCompany() {
		// 버블팡 회사의 id가 8인 회사의 규모를 중소기업, 인원을 34으로 수정
		Company company = companyService.updateCompany(12, "중소기업", 34);
		return company;
	}
	
	

	
//	@GetMapping("/update")
//	@ResponseBody
//	public Company updateCompany() {
//		Company company = companyService.updateCompany(12, "중소기업", 34);
//		return company;
//	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteCompany() {
		// id가 12번인 회사정보 삭제
		companyService.deleteCompany(12);
		return "삭제 성공";
	}

	
//	@GetMapping("/delete")
//	@ResponseBody
//	public String deleteCompany() {
//		companyService.deleteCompany(12);
//		return "삭제 성공";
//		
//	}
}
