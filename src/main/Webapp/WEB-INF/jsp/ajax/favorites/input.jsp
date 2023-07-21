<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		<label>제목</label><br>
		<input type="text" class="form-control" name="name" id="nameInput"><br>
		<label>주소</label><br>
		<div class="d-flex">
			<input type="text" class="form-control col-10" name="url" id="urlInput">
			<button type="button" id="duplicateBtn" class="btn btn-info ml-2">중복확인</button><br>
		</div>
		<div id="availableUrlText" class="text-success small d-none">저장 가능한 url 입니다.</div>
		<div id="duplicateUrlText" class="text-danger small d-none">중복된 url 입니다.</div>
		<br>
		
		<button type="button" id="addBtn" class="btn btn-success btn-block mt-3">추가</button>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			
			var checkedDuplicate = false;
			var isDuplicateUrl = true;
			
			$("#urlInput").on("input", function() {
				
				// 사용자가 input 창을 건드리면 중복확인과 관련된 모든 처리를 초기화하여 다시!!!!
				checkedDuplicate = false;
				isDuplicateUrl = true;
				
				$("#availableUrlText").addClass("d-none");
				$("#duplicateUrlText").addClass("d-none");
			});
			
			$("#duplicateBtn").on("click", function() {
				
				
				
				let url = $("#urlInput").val();
				if(url == "") {
					alert("주소를 입력하세요");
					return;
				}
				
				$.ajax({
					type:"post"
					, url:"/ajax/favorites/url_confirm"
					, data:{"url":url}
					, success:function(data) {
						checkedDuplicate = true;
						// 중복됨 : {"isDuplicate":true}
						// 중복되지 않음 : {"isDuplicate":false}
						if(data.isDuplicate) {
							isDuplicateUrl = true;
							$("#duplicateUrlText").removeClass("d-none");   // d-none 제거하여 보여주게끔 한다
							$("#availableUrlText").addClass("d-none");
						} else {
							isDuplicateUrl = false;
							$("#availableUrlText").removeClass("d-none");   // d-none 제거하여 보여주게끔 한다
							$("#duplicateUrlText").addClass("d-none");
						}
					}
					, error:function() {
						alert("url 중복확인 에러!!!!");
					}
				});
				
			});
			
			$("#addBtn").on("click", function() {
				// 입력한 내용을 기반으로 add API로 데이터 저장

				let name = $("#nameInput").val();
				let url = $("#urlInput").val();
				
				// 유효성 검사
				if(name == "") {
					alert("제목을 입력하세요");
					return;
				}
				
				if(url == "") {
					alert("주소를 입력하세요");
					return;
				}
				
				if(!(url.startsWith("https://")) && !(url.startsWith("http://"))) {
					alert("주소 형식을 확인해 주세요");
					return;
				}
				
				// 중복체크 안 한 경우
				if(checkedDuplicate == false) {
					alert("url 중복 확인을 하세요");
					return;
				}
				
				// url 중복검사 후, 중복된 경우
				if(isDuplicateUrl) {
					alert("url이 중복되었습니다.");
					return;
				}
				
				
				$.ajax({
					type:"post"
					, url:"/ajax/favorites/add"
					, data:{"name":name, "url":url}
					, success:function(data) {
						// 성공 : {"result":"success"}
						// 실패 : {"result":"fail"}
						if(data.result == "success") {
							// 리스트 페이지로 이동
							location.href = "/ajax/favorites/list";
						} else {
							alert("추가 실패");
						}
					}
					, error:function() {
						alert("추가 에러!!!");
					}
				});
			});
			
		});
	
	</script>
	
	
	
</body>
</html>