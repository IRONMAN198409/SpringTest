<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 리스트</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
	<h1>즐겨찾기 목록</h1>
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="favorites" items="${favoritesList }" varStatus="status">
				<tr>
					<td>${favorites.id }</td>
					<td>${favorites.name }</td>
					<td>${favorites.url }</td>
					<td><button type="button" id="deleteBtn" class="btn btn-danger btn-sm delete-btn">삭제</button><td>
				</tr>
				</c:forEach>
			</tbody>		
		</table>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.0.slim.js" integrity="sha256-7GO+jepT9gJe9LB4XFf8snVOjX3iYNb0FHYr5LI1N5c=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			$(".delete-btn").on("click", function() {
				alert();
				
				// 삭제 대상이 되는 그 객체(버튼)의 id를 얻어와야 한다.
				let id = 24;

				$.ajax({
					type:"get"
					, url:"/ajax/favorites/delete"
					, data:{"id":id}
					, success:function(data) {
						if(data.result) {
							location.href = "/ajax/favorites/list";
						} else {
							alert("즐겨찾기 삭제 실패");
						}
					}
					, error:function() {
						alert("즐겨찾기 삭제 에러");
					}
				});
				
				
				
			});
		});
	</script>
	
</body>
</html>