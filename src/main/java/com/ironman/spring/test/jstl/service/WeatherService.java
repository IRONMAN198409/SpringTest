package com.ironman.spring.test.jstl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironman.spring.test.jstl.domain.Weather;
import com.ironman.spring.test.jstl.repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	// 모든 날씨 정보를 조회한다.
	public List<Weather> getWetherhistory() {
		List<Weather> weatherhistory = weatherRepository.selectWeatherHistory();
		return weatherhistory;
	}
	
	public int addWether(Weather newWeatherInfo) {
		int count = weatherRepository.insertWeather(newWeatherInfo);
		return count;
	}
}
