package com.ironman.spring.test.ajax;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ironman.spring.test.ajax.domain.Booking;
import com.ironman.spring.test.ajax.service.BookingService;

@Controller 
@RequestMapping("/ajax/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/list")
	public String BookingList(Model model) {
		List<Booking> bookingList = bookingService.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "ajax/booking/list";
	}
	
	@GetMapping("/input")
	public String bookingInput() {
		return "ajax/booking/input";
	}
	
	@GetMapping("/main")
	public String bookingMain() {
		return "ajax/booking/main";
	}
	
	// 이름, 예약날짜, 숙박일수, 숙박ㄱ인원, 전화번호
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String>createBooking(
			@RequestParam("name") String name
			// 2023년 07월 28일 이라는 형식을 알려줘야 한다
			, @DateTimeFormat(pattern="yyyy년 MM월 dd일")
			@RequestParam("date") Date date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		int count = bookingService.addBooking(name, null, day, headcount, phoneNumber);
		
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
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		int count = bookingService.deleteBooking(id);
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
	
	// 이름과 전화번호를 전달받고, 일치하는 예약 정보를 json으로 response에 담는다
	@GetMapping("/serach")
	@ResponseBody
	public Map<String, Object> searchBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNubmer") String phoneNumber) {
		Booking booking = bookingService.getBooking(name, phoneNumber);
		// 성공, 실패 여부
		// {"result":"success", "info":{"name":"김인규", "headcount":1, "day":2 ... }}
		// {"result":"fail"}
		Map<String, Object> resultMap = new HashMap<>();
		if(booking == null) {
			// 조회 실패
			resultMap.put("result", "fail");
		} else {
			// 조회 성공
			resultMap.put("result", "success");
			resultMap.put("info", booking);
		}
		
		return resultMap;
		
	}

}
