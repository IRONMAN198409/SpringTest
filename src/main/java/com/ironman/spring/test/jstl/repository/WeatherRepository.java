package com.ironman.spring.test.jstl.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ironman.spring.test.jstl.domain.Weather;

@Repository	
public interface WeatherRepository {
	
	// 날씨테이블 정보 모두 조회
	public List<Weather> selectWeatherHistory();
	
	public int insertWeather(Weather newWeatherInfo);
}
