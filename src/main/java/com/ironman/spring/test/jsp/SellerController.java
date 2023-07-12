package com.ironman.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironman.spring.test.jsp.domain.Seller;
import com.ironman.spring.test.jsp.service.SellerService;

@Controller
@RequestMapping("/jsp/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	
	@PostMapping("/add")
	@ResponseBody
	public String createSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileUrl") String profileUrl
			, @RequestParam("temperatrue") double temperatrue)	{
	
		int count = sellerService.addSeller(nickname, profileUrl, temperatrue);
		return "삽입 성공 : " + count;
	}
	
	// sellerInsert 화면으로 이동하기
	@GetMapping("/input")
	public String sellerInput() {
		return "jsp/sellerInput";
	}
	
	
	// 가장 최근 seller 출력
	@GetMapping("/lastseller")
	public String lastSeller(Model model) {
		Seller seller = sellerService.getLastSeller();
		model.addAttribute("seller", seller);
		
		return "jsp/sellerInfo";
	}
	
	@GetMapping("/info")  // 에러남, 확인필요
	public String seller(@RequestParam(value="id", required=false) Integer id, Model model) {
		
		Seller seller = null;
		if(id == null) {  // 파라미터가 없는 경우
			seller = sellerService.getLastSeller();
			
		} else {  // id 파라미터가 전달된 경우
			seller = sellerService.getSeller(id);
			
		}
		model.addAttribute("seller", seller);
		return "jsp/sellerInfo";
	}
	
	// seller id로 검색 출력
//	@GetMapping("/sellerInfo_id")
//	public String sellerInfoById(@RequestParam(value="id", required=false, defaultValue="1") int id, Model model) {
//		Seller seller = sellerService.getSeller(id);
//		model.addAttribute("seller", seller);
//		return "jsp/sellerInfo";
//	}
}
