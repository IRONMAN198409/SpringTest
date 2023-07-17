package com.ironman.spring.test.jstl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl/weatherhistory/")
public class WeatherhistoryController {

	@Autowired
	private WeatherhistoryService weatherhistoryService;
	
	@GetMapping("/select")
	public String weatherhistory() {
		
	}
	
	
	// jsp 조회 화면으로 이동
	@GetMapping("/Info")
	public String weatherhistory() {
		return "jstl/weatherhistoryInfo";
	}
}
