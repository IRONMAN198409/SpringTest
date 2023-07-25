<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 예약 입력</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<label>이름</label><br>
		<input type="text" class="form-control" name="name" id="nameInput"><br>
		<label>예약날짜</label><br>
		<input type="text" class="form-control" name="date" id="dateInput"><br>
		<label>숙박일수</label><br>
		<input type="text" class="form-control" name="day" id="dayInput"><br>
		<label>숙박인원</label><br>
		<input type="text" class="form-control" name="headcount" id="headcountInput"><br>
		<label>전화번호</label><br>
		<input type="text" class="form-control" name="phoneNumber" id="phoneNumberInput"><br>
		<button type="button" class="btn btn-warning btn-block">예약하기</button>
	
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.0.slim.js" integrity="sha256-7GO+jepT9gJe9LB4XFf8snVOjX3iYNb0FHYr5LI1N5c=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			
			$("#bookinBtn").on("click", function() {
				let name = $("#nameInput").val();
				let date = $("#dateInput").val();
				let day = $("#dayInput").val();
				let headcount = $("#headcountInput").val();
				let phoneNumber = $("#phoneNumberInput").val();
				
				// 유효성 검사
				if(name == "") {
					alert("이름을 입력하세요");
					return;
				}
				
				if(date == "") {
					alert("날짜를 입력하세요");
					return;
				}
				
				if(day == "") {
					alert("숙박일수를 입력하세요");
					return;
				}
				
				// 숙박일수가 숫자가 아닌 경우
				// NaN: Not a Number
				if(isNaN(day)) {
					alert("숙박일수는 숫자만 입력 가능합니다");
					return;
				}
				
				if(headcount =="") {
					alert("숙박인원을 입력하세요");
					return;
				}
				
				if(isNaN(headcount)) {
					alert("숫박인원은 숫자만 입력 가능합니다");
					return;
				}
				
				if(phoneNumber == "") {
					alert("전화번호를 입력하세요");
					return;
				}
				
				$.ajax({
					type:"get"
					, url:"/ajax/booking/add"
					, data:{"name":name, "date":date, "day": day, "headcount":headcount, "phoneNumber":phoneNumber}
					, success:function(data) {
						// 성공 : {"result":"success"}
						// 실패 : {"result":"fail"}
						if(data.result == "success") {
							location.href = "/ajax/booking/list";
						} else {
							alert("예약 실패;")
						}
					}
					, error:function() {
						alert("예약 에러");
					}
					
				});
				
			});
			
			$("#dateInput").datepicker({
				dateFormat:"yyyy년 mm월 dd일"
			});
		});
	
	</script>
</body>
</html>