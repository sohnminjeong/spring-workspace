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
	<h1>회원가입</h1>
	
	<form>
		아이디 : <input type="text" name="id" id="id">
		<input type="button" value="중복체크" id="idCheck" >
		<span id="idCheckView"></span>
	</form>


	<script>
		$('#idCheck').click(()=>{
			//const id = $("#id").val();
			$.ajax({
				// 요청
				type: "post",
				url: "/check",
				//data: "id=" + encodeURI(encodeURIComponent(id))-get방식일 경우 encoding, decoding,
				data: "id=" + $("#id").val(),
				
				// 응답
				success: function(result){
					if(result){  // true인 경우
						$('#idCheckView').text("ID 사용 불가").css("color", "red");
					} else { // false인 경우
						$('#idCheckView').text("ID 사용 가능").css("color", "blue");
					}
					
				}
			});
			
		});
	</script>

	
	<!-- 중복체크 버튼을 눌렀을 때 post 방식으로 /check로 id 값 넘겨서 
		결과값(boolean)을 받아서 아이디가 있으면 ID 사용 불가, 없으면 ID 사용 가능 
		DB는 kh.member
	 -->
</body>
</html>