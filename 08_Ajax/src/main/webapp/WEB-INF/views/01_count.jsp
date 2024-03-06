<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Ajax(Asynchronous JavaScript and XML) : 비동기적 정보 교환 기법 -->
	<!-- 동기적 : 강도나 소요시간 상관없이 먼저 시작된 것이 끝나야만 뒤에 것이 시작됨 -->
	<!-- 비동기적 : 시간이 적게 걸리는 것이 순서에 상관없이 먼저 결과 나옴(동시다발실행) (정적인 것 먼저 처리)-->
	<h1>Show Count</h1>
	<input type="button" id="btn" value="count 증가" onclick="startRequest()">
	<p id="result"></p>
	
	<!-- 자바스크립트 방식 -->
	<script>
		let xhr;  // 기본방식으로 xhr 선언 
		function startRequest(){  // 요청에 해당하는 로직을 담는 메서드 
			xhr = new XMLHttpRequest();
			//alert(xhr.readyState);   //0
			xhr.onreadystatechange = callback;
			//get방식으로 서버count한테 요청 : 어디 서버에 무슨 타입으로 할 건지 
			xhr.open("get", "/count");
			xhr.send(null); //이 때 서버로 날라간다. 실직적인 요청이 들어가는 시점!(get방식의 경우 null로 보냄)
			//alert(xhr.readyState);   //0 -> 1
		}
		
		function callback(){   // 응답에 해당하는 로직을 담는 메서드 
			//alert(xhr.readyState);
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const result = xhr.responseText;
					// xhr.responseText = controller에서의 return ++count;
					document.querySelector("#result").innerHTML = result;
				}
			}
		}
	</script>
</body>
</html>