package com.ironman.spring.test.mybatis.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ironman.spring.test.mybatis.domain.RealEstate;

@Repository
public interface RealEstateRepository {
	
	public RealEstate selectRealEstate(@Param("id") int id);
}
