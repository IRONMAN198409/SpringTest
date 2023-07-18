<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 입력</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<form method="get" action="/jstl/weather/add">
		<h1>날씨 입력</h1>
		<label>날짜</label><input type="text" name="date">
		<label>날씨</label>
		<select name="weather">
			<option>맑음</option>
			<option>구름조금</option>
			<option>흐림</option>
			<option>비</option>
		</select>
		<label>미세먼지</label>
		<select name="microDust">
			<option>좋음</option>
			<option>보통</option>
			<option>나쁨</option>
			<option>최악</option>
		</select><br>
		<label>기온</label><input type="text" name="temperatures">
		<label>강수량</label><input type="text" name="precipitation">
		<label>풍속</label><input type="text" name="windSpeed">
		<br>
		<button type="submit" class="btn btn-success">저장</button>
	</form>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>