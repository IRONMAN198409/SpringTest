<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>이름</th>
				<th>예약날짜</th>
				<th>숙박일수</th>
				<th>숙박인원</th>
				<th>전화번호</th>
				<th>예약상태</th>
				<th></th>
			<tr>
		</thead>
		<tbody>
			<c:forEach var="booking" items="${bookingList}">
			<tr>
				<td>${booking.name}</td>
				<td><fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 d일" /></td>
				<td>${booking.day}</td>
				<td>${booking.headcount}</td>
				<td>${booking.phoneNumber}</td>
				<c:choose>
					<c:when test="${booking.state eq '확정'}">
						<td class="text-success">${booking.state}</td>
					</c:when>
					<c:when test="${booking.state eq '대기중'}">
						<td class="text-info">${booking.state}</td>
					</c:when>
					<c:when test="${booking.state eq '취소'}">
						<td class="text-danger">${booking.state}</td>
					</c:when>
					<c:otherwise>
						<td>${booking.state}</td>
					</c:otherwise>
				</c:choose>
				<td><button type="button" class="btn btn-danger btn-sm delete-btn" data-booking-id="${booking.id}">삭제</button></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.0.slim.js" integrity="sha256-7GO+jepT9gJe9LB4XFf8snVOjX3iYNb0FHYr5LI1N5c=" crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function() {
			$(".delete-btn").on("click", function() {
				let bookingId = $(this).data("booking-id");
				$.ajax({
					type:"get"
					, url:"/ajax/booking/delete"
					, data:{"id":bookingId}
					, success:function(data) {
						// 성공 : {"result":"success"}
						// 실패 : {"result":"fail"}
						if(data.result == "success") {
							location.reload();
						} else { 
							alert("삭제 실패");
						}
					}
					, error:function() {
						alert("삭제 에러");
					}
				
				});
			});
		});
	
	</script>
</body>
</html>