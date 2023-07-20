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
	
}
