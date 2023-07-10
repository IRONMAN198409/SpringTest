package com.ironman.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironman.spring.test.mybatis.domain.RealEstate;
import com.ironman.spring.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis/realestate")
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	// id를 전달받고, 해당 매물 정보를 json으로 response에 담는다.
	@RequestMapping("/test01/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		RealEstate realEstate = realEstateService.getRealEstate(id);
		return realEstate;
	}
	
	// 월세를 전달받고, 해당 월세보다 낮은 월세 매물 json으로 response에 담는다.
	@RequestMapping("/test01/2")
	@ResponseBody
	public List<RealEstate> realEstateByRentPrice(@RequestParam("rent") int rentPrice) {
		List<RealEstate> realEstateList = realEstateService.getRealEstateByRentPrice(rentPrice);
		return realEstateList;
	}
	
	// 면적과 가격을 전달 받고, 면적이 더 넓으면서 싼 매물 json response 에 담는다.
	@RequestMapping("/test01/3")
	@ResponseBody
	public List<RealEstate> realEstateByAreaPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		List<RealEstate> realEstateList = realEstateService.getRealEstateByAreaPrice(area, price);
		
		return realEstateList;
	}
	
	@RequestMapping("/test02/1")
	@ResponseBody
	public String createRealEstateByObject() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateService.addRealEstateByObject(realEstate);
		
		return "삽입 개수 : " + count;
		
	@RequestMapping("/test02/2")
	@ResponseBody
	public String createRealEstate() {
		int count = realEstateService.addRealEstate("썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "삽입 개수 : " + count;
	}
		
		
		
	}
	
	
	
	
//	@Autowired 
//	private RealEstateService realEstateService;
//	
//	@RequestMapping("/1")
//	@ResponseBody 
//	public RealEstate realEstate(@RequestParam("id") int id) {
//		RealEstate realEstate = realEstateService.getRealEstate(id);
//		return realEstate;
//	}
//	@RequestMapping("/2")
//	@ResponseBody
//	public List<RealEstate> rentPriceList(@RequestParam("rentPrice") int rentPrice) {
//		List<RealEstate> rentPriceList = realEstateService.getRentPriceList(rentPrice);
//		return rentPriceList;
//	}
//	@RequestMapping("/3")
//	@ResponseBody
//	public List<RealEstate> areaPriceList(@RequestParam("area") int area, @RequestParam("price") int price) {
//		List<RealEstate> areaPriceList = realEstateService.getAreaPriceList(area, price);
//		return areaPriceList;
//	}
}
