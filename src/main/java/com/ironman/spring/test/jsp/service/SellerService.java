package com.ironman.spring.test.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironman.spring.test.jsp.domain.Seller;
import com.ironman.spring.test.jsp.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public int addSeller(String nickname, String profileUrl, double temperature) {
		int count = sellerRepository.insertSeller(nickname, profileUrl, temperature);
		return count;
	}
	
	public Seller getLastSeller() {
		Seller seller = sellerRepository.selectLastSeller();
		return seller;
	}
	
	public Seller getSeller(int id){
		Seller seller = sellerRepository.selectSeller(id);
		return seller;
	}

}
