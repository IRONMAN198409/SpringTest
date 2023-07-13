package com.ironman.spring.test.jsp.repository;

import org.springframework.stereotype.Repository;

import com.ironman.spring.test.jsp.domain.Realtor;

@Repository 
public interface RealtorRepository {

	public int insertRealtor(Realtor realtor);
}
