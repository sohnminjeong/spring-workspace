<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원정보</h2>
<ul>
	<li> 회원 번호 : ${user.userNo}</li>
	<li> 회원 아이디 : ${user.userId}</li>
	<li> 회원 이름 : ${user.userName}</li>
	<li> 회원 나이 : ${user.userAge}</li>
</ul>
<a href="index.jsp">메인페이지로 돌아가기</a>
</body>
</html>