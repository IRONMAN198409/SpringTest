package com.ironman.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironman.spring.test.database.domain.Store;
import com.ironman.spring.test.database.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired 
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> storeList() {
		List<Store> storeList = storeService.getStoreList();
		return storeList;
		
	}
}


//@Controller
//public class StoreController {
//
//	@Autowired
//	private StoreService storeService;
//	
//	@RequestMapping("/db/store/list")
//	@ResponseBody
//	public List<Store> storeList() {
//		List<Store> storeList = storeService.getStoreList();
//		return storeList;
//	}
//}
