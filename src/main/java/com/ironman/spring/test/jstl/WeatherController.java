package com.ironman.spring.test.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ironman.spring.test.jstl.domain.Weather;
import com.ironman.spring.test.jstl.service.WeatherService;

@Controller
@RequestMapping("/jstl/weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	// 날씨조회 화면으로 이동
	@GetMapping("/list")
	public String weatherInfo(Model model) {
		
		List<Weather> weatherhistory = weatherService.getWetherhistory();
		model.addAttribute("weatherhistoryList", weatherhistory);
		return "jstl/weather/list";
	}
	
	// 날씨 입력 화면으로 이동
	@GetMapping("/input")
	public String weatherInput() {
		return "jstl/weather/input";
	}
	
	@GetMapping("/add")
	public String createWeather(
			// 파라미터로 받은 연월일시분초에 대한 정보가 필요한다
//			@RequestParam("date") @DateTimeFormat(pattern="yyyy년 MM월 dd일") Date date
//			, @RequestParam("weather") String weather
//			, @RequestParam("temperatures") double temperatures
//			, @RequestParam("precipitation") double precipitation
//			, @RequestParam("microDust") String microDust
//			, @RequestParam("windSpeed") double windSpeed) {
			@ModelAttribute Weather weather) {
		
//		int count = weatherService.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		int count = weatherService.addWeatherByObject(weather);
		
		return "redirect:/jstl/weather/list";
		
	}
}
