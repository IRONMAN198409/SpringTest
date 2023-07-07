package com.ironman.spring.test.database.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ironman.spring.test.database.domain.Store;

@Repository
public interface StoreRepository {
	
	// store 모든 행 조회
	public List<Store> selectStoreList();
}
