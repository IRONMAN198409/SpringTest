package com.ironman.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironman.spring.test.ajax.domain.Favorites;
import com.ironman.spring.test.ajax.repository.FavoritesRepository;

@Service
public class FavoritesService {
	
	@Autowired
	private FavoritesRepository favoritesRepository;

	public List<Favorites> getFavorites() {
		List<Favorites> favoritesList = favoritesRepository.selectFavoritesList();
		return favoritesList;
	}
	
	public int addFavorites(
			String name
			, String url) {
		int count = favoritesRepository.insertFavorites(name, url);
		return count;
	}
	
	// 전달된 url이 있는지 중복 여부를 리턴하는 메소드
	public boolean isDuplicateUrl(String url) {
		int count = favoritesRepository.selectCountUrl(url);
		
//		if(count == 0) {
//			// 중복 안됨
//			return false;
//		} else {
//			// 중복
//			return true;
//		}
		
		return count != 0;
	}
	
	// 전달받은 id가 있는지 확인하는 메소드
	public int deleteFavorites(int id) {
		int count = favoritesRepository.deleteFavorites(id);
		return count;
	}
	
	
	
}
