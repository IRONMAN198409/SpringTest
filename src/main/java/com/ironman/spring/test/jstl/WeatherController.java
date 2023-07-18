package com.ironman.spring.test.jstl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ironman.spring.test.jstl.domain.Weather;
import com.ironman.spring.test.jstl.service.WeatherService;

@Controller
@RequestMapping("/jstl/weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	// 날씨조회 화면으로 이동
	@GetMapping("/info")
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
			@RequestParam("date") String date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed) {
		
		Weather newWeatherInfo = new Weather();
		newWeatherInfo.setDate(date);
		newWeatherInfo.setWeather(weather);
		newWeatherInfo.setTemperatures(temperatures);
		newWeatherInfo.setPrecipitation(precipitation);
		newWeatherInfo.setMicroDust(microDust);
		newWeatherInfo.setWindSpeed(windSpeed);
		
		int count = weatherService.addWether(newWeatherInfo);
		
		return "redirect:info";
		
	}
}
