<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#header{
	background-color: yellow;
}
</style>
<body>
	<h1>회원 검색 결과</h1>
	<table border=1>
		<tr id=header>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.id}</td>
				<td>${list.password}</td>
				<td>${list.name}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/">첫 페이지로 이동</a><br>
	<a href="/search">검색 페이지로 이동</a>
</body>
</html>