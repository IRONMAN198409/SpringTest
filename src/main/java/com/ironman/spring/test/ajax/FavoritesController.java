package com.ironman.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironman.spring.test.ajax.domain.Favorites;
import com.ironman.spring.test.ajax.service.FavoritesService;

@Controller
@RequestMapping("/ajax/favorites")
public class FavoritesController {
	
	@Autowired
	private FavoritesService favoritesService;
	
	// list.jsp 화면으로 이동
	@GetMapping("/list")
	public String favoritesList(Model model) {
		
		List<Favorites> favoritesList = favoritesService.getFavorites();
		
		model.addAttribute("favoritesList", favoritesList);
		
		return "ajax/favorites/list";
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Map<String, String> createFavorites(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
		int count = favoritesService.addFavorites(name, url);
		
		// 실행결과 성공여부
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		return resultMap;
		
	}

	// input.jsp 화면으로 이동
	@GetMapping("/input")
	public String favoritesInput() {
		return "ajax/favorites/input";
	}
	
	// 주소(url)을 전달받고, 이미 저장된 주소인지를 알려주는 API
	@PostMapping("/url_confirm")
	@ResponseBody
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		
		Map<String, Boolean> resultMap = new HashMap<>();
//		if(favoritesService.isDuplicateUrl(url)) {
//			// 중복됨
//			resultMap.put("isDuplicate", true);
//		} else {
//			// 중복안됨
//			resultMap.put("isDuplicate", false);
//		}
		
		// 아래와 같이 줄여서 가능함
		resultMap.put("isDuplicate", favoritesService.isDuplicateUrl(url));
		
		return resultMap;
	}
	
	// id를 전달받고, 해당 데이타 삭제한 결과를 알려주는 API
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteFavorites(@RequestParam("id") int id) {
		int count = favoritesService.deleteFavorites(id);
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
}
