package com.ironman.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironman.spring.test.database.domain.Store;
import com.ironman.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	// store 리스트를 얻어 오는 기능
	public List<Store> getStoreList() {
		
		List<Store> storeList = storeRepository.selectStoreList();
		return storeList;
	}
}



//@Service
//public class StoreService {
//	
//	@Autowired
//	private StoreRepository storeRepository;
//	
//	public List<Store> getStoreList() {
//		List<Store> storeList = storeRepository.selectStoreList();
//	    return storeList;
//	}
//}
