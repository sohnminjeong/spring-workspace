<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

</head>
<body>
	<h1>회원가입</h1>
	
	<form id="frm">
		아이디 : <input type="text" name="id" id="id"><br>
		비밀번호 : <input type="password" name="password" id="password"><br>
		이름 : <input type="text" name="name" id="name"><br>
		<input type="button" value="가입" id="btn">
		<!-- ajax 처리 시에는 input type은 button으로  -->
	</form>
	
	<div id="result">
		<!-- 회원정보 여기에 나오도록!->id, password, name -->
	</div>
	
	<!-- post 방식으로 /serial로 id, password, name 값 넘겨서 회원가입하고
		돌아와서 result에 정보 기재 
	 -->
	
	<!-- Ajax 방식 -->
	<script>
		$("#btn").click(()=>{
			$.ajax({
				type:"post",
				url:"/serial",
				data: $("#frm").serialize(),
				
				success: function(result){
					const id = result.id;
					const name = result.name;
					//$("#result").text(JSON.stringify(obj));
					let text = `<ul>
								<li>아이디 : ${"${id}"}</li>
								<li>이름 : ${"${name}"}</li>
								</ul>`;
					//$("#result").html("아이디 : " + result.id + "이름 : " + result.name);
					$("#result").html(text);
				},
				error: function(){
					console.log("에러 발생!");
				}
			})
		})
	</script>
</body>
</html>