<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>공인중개사 정보 출력</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
		<div class="container">
			<h1>공인중개사 정보</h1>
			<table class="table">
				<tr>
					<td class="font-weight-bold">ID</td>
					<td class="font-weight-bold">${realtor.id }</td>
				</tr>
				<tr>
					<td class="font-weight-bold">상호명</td>
					<td>${realtor.office }</td>
				</tr>
				<tr>
					<td class="font-weight-bold">전화번호</td>
					<td>${realtor.phoneNumber }</td>
				</tr>
				<tr>
					<td class="font-weight-bold">주소</td>
					<td>${realtor.address }</td>
				</tr>
				<tr>
					<td class="font-weight-bold">등급</td>
					<td>${realtor.grade }</td>
				</tr>
			</table>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>