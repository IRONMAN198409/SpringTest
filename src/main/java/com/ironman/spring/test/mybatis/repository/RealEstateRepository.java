package com.ironman.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ironman.spring.test.mybatis.domain.RealEstate;

@Repository
public interface RealEstateRepository {
	
	// 전달된 id와 일치하는 매물 행 정보 조회
	public RealEstate selectRealEstate(@Param("id") int id);
	
	// 전달된 rentPrice보다 낮은 매물 행 정보 조회
	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentPrice") int rentPrice);
	
	// 전달된 면적, 가격 정보를 기반으로 매물 행 정보 조회
	public List<RealEstate> selectRealEstateByAreaPrice(
			@Param("area") int area
			, @Param("price") int price);
	
	public int insertRealEstateByObject(RealEstate realEstate);
	
	public int insertRealEstate(
			@Param("address") String address
			,@Param("area") int area
			,@Param("type") String type
			,@Param("price") int price
			,@Param("rentPrice") int rentPrice
			);
	
}