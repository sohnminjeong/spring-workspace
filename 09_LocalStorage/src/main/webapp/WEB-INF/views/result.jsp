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
		const token = `${token}`;
		alert(token);
		localStorage.setItem("token", token);
		location.href="/";
	</script>
</body>
</html>