<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form action="updateMember" method="post">
		기존 아이디 : <input type = "text" name="id" readonly value="${login.id}"><br>
		  *아이디는 수정 불가입니다.<br>
	 	수정 할 비밀번호 : <input type = "password" name="password" value="${login.password}"><br>
	 	수정 할 이름 : <input type = "text" name="name" value="${login.name}"><br>
	 	<input type = "submit" value="정보 수정">
	</form>
	

	
	
	
	
</body>
</html>