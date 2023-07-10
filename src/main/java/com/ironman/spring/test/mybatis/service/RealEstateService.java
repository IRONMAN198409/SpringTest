package com.ironman.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironman.spring.test.mybatis.domain.RealEstate;
import com.ironman.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository; 
	
	// 전달된 id와 일치하는 매물 정보 얻기
	public RealEstate getRealEstate(int id) {
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		return realEstate;
	}
	
	// 전달된 rentPrice(월세) 보다 낮은 매물 정보 얻기
	public List<RealEstate> getRealEstateByRentPrice(int rentPrice) {
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateByRentPrice(rentPrice);
		return realEstateList;
	}
	
	// 면적과 가격 전달 받고, 해당하는 매물 정보 얻기
	public List<RealEstate> getRealEstateByAreaPrice(int area, int price) {
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateByAreaPrice(area, price);
		return realEstateList;
	}
	
	public int addRealEstateByObject(RealEstate realEstate) {
		int count = realEstateRepository.insertRealEstateByObject(realEstate);
		return count;
	}
	
	public int addRealEstate(
			String address
			, int area
			, String type
			, int price
			, int rentPrice) {
		int count = realEstateRepository.insertRealEstate(address, area, type, price, rentPrice); 
		return count;
	}
}
