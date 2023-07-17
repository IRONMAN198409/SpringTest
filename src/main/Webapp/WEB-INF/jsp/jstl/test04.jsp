<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 함수 라이브러리</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>회원정보 리스트</h1>
		<table class="table">
			<thead class="text-center">
				<tr>
					<th>No</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>국적</th>
					<th>이메일</th>
					<th>자기소개</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="member" items="${memberList }" varStatus="status">
				<tr>
					<td class="text-center">${status.count }</td>
					<td class="text-center">${member.name }</td>
	
					<%-- phoneNumber가 010으로 시작하면 번호 그대로, 그게 아니면 유효하지 않은 전화번호 --%>
					<c:choose>
						<c:when test="${fn:startsWith(member.phoneNumber, '010') }">
							<td class="text-center">${member.phoneNumber }</td>
						</c:when>
						<c:otherwise>
							<td class="text-center">유효하지 않은 전화번호</td>
						</c:otherwise>
					</c:choose>
					
					<%--  아래와 같이 심플하게 수정 가능함
					<c:set var="nationality" value="${member.nationality}" />
					<td class="text-center">${fn:replace(nationality, "삼국시대", "삼국 - " ) }</td> 
					--%>
					<td>${fn:replace(member.nationality, "삼국시대", "삼국 - ") }</td>
					
					<%--  아래와 같이 수정 가능함
					<c:set var="email" value="${member.email }" />
					<c:set var="length" value="${fn:length(email) }" />
				 	<c:set var="index" value="${fn:indexOf(email, '@')}" />
					<td><span class="font-weight-bold">${fn:substring(email, 0, index)}</span>${fn:substring(email, index, length)}</td>
					--%>
					<td><b>${fn:split(member.email, "@")[0] }</b>@${fn:split(member.email, "@")[1] }</td>
					
			
					<%--  아래와 같이 수정 가능함
					<c:set var="length" value="${fn:length(member.introduce) }" />
					<c:choose>
						<c:when test="${length >= 15 }">
							<td>${fn:substring(introduce, 0, 15) } ...</td>
						</c:when>
						<c:otherwise>
							<td>${member.introduce }</td>
						</c:otherwise>
					</c:choose>
					--%>
					<td>${fn:substring(member.introduce, 0, 15) }
						<c:if test="${fn:length(member.introduce) > 15 }">
							...
						</c:if>
					</td>
					
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>