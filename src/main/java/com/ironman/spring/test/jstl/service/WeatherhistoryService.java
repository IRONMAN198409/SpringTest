package com.ironman.spring.test.jstl.service;

import org.springframework.stereotype.Service;

@Service
public class WeatherhistoryService {
	@Autowired
	private WeatherhistoryRepository weatherhistoryRepository;
	
	public Weatherhistory addWetherhistory(Weatherhistory weatherhistory) {
		Weatherhistory weatherhistory = weatherhistoryRepository.
	}
}
