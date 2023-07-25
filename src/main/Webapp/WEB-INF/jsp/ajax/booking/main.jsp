<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		$(document).ready(function() {
			$("#findBtn").on("click", function() {
				let name = $("#nameInput").val();
				let phoneNumber = $("#phoneNumber").val();
				
				if(name == "") {
					alert("이름을 입력하세요");
					return;
				}
				if(phoneNumber == "") {
					alert("전화번호를 입력하세요");
					return;
				}
				
				$.ajax({
					type:"get"
					, url:"/ajax/booking/search"
					, data:{"name":name, "phoneNumber":phoneNumber}
					, success:function(data) {
						if(data.result == "fail") {
							 alert("조회된 데이터가 없습니다!!!");
						} else {
							let message = "이름 : " + data.info.name
							+ "\n날짜 : " + data.info.date.substring(0, 10)
							+ "\n일수 : " + data.info.day
							+ "\n인원 : " + data.info.headcount
							+ "\n상태 : " + data.info.state;
							
							alert(message);
						}
					} 
					, error:function() {
						alert("조회 에러");
					}
				});
					
					
				
			});
			
		});
	
	</script>
</body>
</html>