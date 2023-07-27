package com.ironman.spring.test.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ironman.spring.test.jpa.domain.Recruit;
import com.ironman.spring.test.jpa.repository.RecruitRepository;

@RestController   // @Controller + @ResponseBody
@RequestMapping("/jpa/recruit")
public class RecruitController {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public Recruit selectRecruit() {
		// 1. id가 8인 데이터 조회
		Recruit recurit = recruitRepository.findById(8).orElse(null);
		return recurit;
	}

	// 2. company id로 회사 공고 조회
	@GetMapping("/2")
	public List<Recruit> recruitByCompanyId(@RequestParam("companyId") int companyId) {
		
		List<Recruit> recruitList = recruitRepository.findByCompanyId(companyId);
		return recruitList;
	}
	
	// 3. 복합조건 조회
	// position : 웹 back-end 개발자이고, type : 정규직
	@GetMapping("/3")
	public List<Recruit> recruiutByPositionType() {
		List<Recruit> recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		return recruitList;
	}
	
	
	// 4. 복합조건 조회
	// 정규직이거나 연봉 9000이상인 공고 조회
	@GetMapping("/4")
	public List<Recruit> recruitByTypeSalary() {
		List<Recruit> recruitList = recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		return recruitList;
	}

	// 5. 정렬 제한 조건
	// 계약직 목록을 연봉 기준으로 내림차순 3개만 조회	
		

		
		
//		List<Recruit> recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
//		return recruitList;
		
		// 6. 범위 조회
		// 성남시 분당구가 지역, 연봉 7000이상 ~ 8500이하인 공고 조회
//		List<Recruit> recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
//		return recruitList;
	
	@GetMapping("/native")
	public List<Recruit> nativeRecruit() {
		// 7. Native query
		// 마감일이 2026-04-10 이후, 연봉이 8100이상인 정규직 공고, 연봉기준 내림차순 조회
		List<Recruit> recruitList = recruitRepository.findByNative("2026-04-10", 8100, "정규직");
		return recruitList;
	}
	
}
