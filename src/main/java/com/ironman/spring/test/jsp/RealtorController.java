package com.ironman.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ironman.spring.test.jsp.domain.Realtor;
import com.ironman.spring.test.jsp.service.RealtorService;

@Controller
@RequestMapping("/jsp/realtor")
public class RealtorController {
	
	@Autowired 
	private RealtorService realtorService;
	
	@GetMapping("/add")
	public String createRealtor(
			@RequestParam("office") String office
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("address") String address
			, @RequestParam("grade") String grade
			, Model model) {
		
		Realtor realtor = new Realtor();
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		int count = realtorService.addRealtor(realtor);
		
		model.addAttribute("realtor", realtor);
		return "jsp/realtorInfo";
		
	}
	
	
//	@GettMapping("/add") 
//	public String createRealtor(
//			@RequestParam("office") String office
//			, @RequestParam("phoneNumber") String phoneNumber
//			, @RequestParam("address") String address
//			, @RequestParam("grade") String grade
//			, Model model) {
//		Realtor realtor = new Realtor();
//		realtor.setOffice(office);
//		realtor.setPhoneNumber(phoneNumber);
//		realtor.setAddress(address);
//		realtor.setGrade(grade);
//		int count = realtorService.addRealtor(realtor);
//		model.addAttribute("realtor", realtor);  // jsp view와 연동하는 매개체 생성
//		return "jsp/realtorInfo";
//	}
	

	// 등록화면으로 이동
	@GetMapping("/input")
	public String realtorInput() {
		return "jsp/realtorInput";
	}
}
