<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>접근제한</h1>
	<p><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}"/></p>
	<a href="/">첫 페이지로 이동</a>
</body>
</html>