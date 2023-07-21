package com.ironman.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ironman.spring.test.ajax.domain.Favorites;

@Repository
public interface FavoritesRepository {

	public List<Favorites> selectFavoritesList();
	
	public int insertFavorites(
			@Param("name") String name
			, @Param("url") String url);
	
	public int selectCountUrl(@Param("url") String url);
	
	public int deleteFavorites(@Param("id") int id);
	
}