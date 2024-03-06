<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h2>Encoding 처리하기..</h2>
	닉네임 : <input type="text" name="nick" id="nick">
	<input type="button" value="닉네임 보내기" id="btn" onclick="startRequest()">
	<!-- <input type="button" value="닉네임 보내기" id="btn">  -->
	<div id="result"></div>
	
	<!-- 자바스크립트 방식 -->
	<!-- get 방식으로 /encoding <--- 닉네임 보내서 : 요청
		해당 닉네임 받아서 result에 보여주기 
	 -->
	<script>
		let xhr;
		// 요청 로직 메서드
		function startRequest(){
			const nick = document.querySelector("#nick");
			// XMLHttpRequest() java script에서 제공하는 것
			xhr = new XMLHttpRequest();
			// onready에 callback 연결
			xhr.onreadystatechange = callback;
			// open에 메서드 방식과 어디로 보낼건지 작성 
			// get방식의 경우 ?뒤에 작성하면 됨 
			//alert(nick.value); : 내가 입력한 닉네임이 alert로 보임
			//xhr.open("get", "/encoding?nick="+nick.value); -> 한글처리 안되
			// encodeURI(encodeURIComponent(nick.value))로 한글 처리 인코딩 처리
			xhr.open("get", "/encoding?nick="+encodeURI(encodeURIComponent(nick.value)));
			// 진짜 전송은 send 일 때이고 get방식은 null 처리
			xhr.send(null);
			//alert(xhr.readyState);
		}
		
		// 응답 로직 메서드 
		function callback(){
			//alert(xhr.readyState);
			//alert(xhr.status);
			// readystate가 4일때 요청 끝남
			if(xhr.readyState === 4){
				// status가 200인 상황이 성공 
				if(xhr.status === 200){
					const result = document.querySelector("#result");
					//result.innerHTML = xhr.responseText;
					result.innerHTML = decodeURI(decodeURIComponent(xhr.responseText));
				}
			}
		}
	</script> 
	
	<!-- jQuery -->
	<!-- 
	<script>
		// click 시 btn 비동기처리
		$('#btn').click(()=>{
		const nick = $("#nick").val();
			// 비동기 시작
			$.ajax({
				// 요청
				type: "get",
				url: "/encoding",
				data: "nick=" + encodeURI(encodeURIComponent(nick)),
				
				// 응답
				success: function(result){
					$('#result').text(decodeURI(decodeURIComponent(result)));
				}
			});
		});
	</script>
	 -->
</body>
</html>