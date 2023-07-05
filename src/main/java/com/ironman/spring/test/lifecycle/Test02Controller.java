package com.ironman.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {
	
	
	// 객체 리턴
	@RequestMapping("/1")
	@ResponseBody
	public List<Map<String, Object>> movieList() {
		
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		Map<String, Object> movie = new HashMap<>();
		movie.put("rate", 15);
		movie.put("director", "봉준호");
		movie.put("time", 131);
		movie.put("title", "기생충");
		movieList.add(movie);
		
		movie.put("rate", 0);
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("title", "인생은 아름다워");
		movieList.add(movie);
		
		movie.put("rate", 12);
		movie.put("director", "크리스토퍼 놀란");
		movie.put("time", 147);
		movie.put("title", "인셉션");
		movieList.add(movie);
		
		movie.put("rate", 19);
		movie.put("director", "윤종빈");
		movie.put("time", 133);
		movie.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movieList.add(movie);
		
		movie.put("rate", 15);
		movie.put("director", "프란시스 로렌스");
		movie.put("time", 137);
		movie.put("title", "헝거게임");
		movieList.add(movie);

		return movieList;
	}
	
	
//	public postList() {
//		
//		List<Post> postList = new ArrayList<>();
//		Post post = new Post("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
//		postList.add(post);
//		
//		post = new Post
//	}
	
//	@RequestMapping("/2")
//	public ResponseEntity<Board> entityResponse() {
//		
//		List<String> boardList = new ArrayList<>();
//		Board board1 = new Board();
//		board1.setTitle("안녕하세요 가입인사 드립니다.");
//		board1.setUser("hagulu");
//		board1.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
//		boardList.add(board1);
//		
//		Board board2 = new Board();
//		board2.setTitle("헐 대박");
//		board2.setUser("bada");
//		board2.setContent("오늘 목요일이 었어... 금요일인줄");
//		boardList.add(board2);
//		
//		Board board3 = new Board();
//		board3.setTitle("오는ㄹ 데이트 한 이야기 해드릴게요.");
//		board3.setUser("dulumary");
//		board3.setContent("...");
//		boardList.addAll((Collection<? extends String>) board3);
//		
//		return boardList;
//		
//		
//		
//	}
}
