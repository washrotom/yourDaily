<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"type="text/css" href="style.css"> 
</head>
<body>
<div>
	<h1 class="text">yourdiary.</h1>
	<div class="btn">
		<a class="btnL" href="${pageContext.request.contextPath }/mood/mood.jsp">Write</a><br>
		<a class="btnC" href="${pageContext.request.contextPath }/confirm/confirm.jsp">Search</a>
		<a class="btnJ" href="${pageContext.request.contextPath }/sign_up/sign_up.jsp">SignUp</a><br>
		<a class="btnLG" href="${pageContext.request.contextPath }/sign_in/sign_in.jsp">SignIn</a>
	</div>
</div>
</body>
</html>