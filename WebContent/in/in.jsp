<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/in/style.css"> 
</head>
<body>
<div>
	<h1 class="text">yourdiary.</h1>
	<div class="clouds">
		<img src="../img/cloud/cloud1.png" style="--i:1;">
		<img src="../img/cloud/cloud2.png" style="--i:2;">
		<img src="../img/cloud/cloud3.png" style="--i:3;">
		<img src="../img/cloud/cloud4.png" style="--i:4;">
		<img src="../img/cloud/cloud5.png" style="--i:5;">
		<img src="../img/cloud/cloud1.png" style="--i:10;">
		<img src="../img/cloud/cloud2.png" style="--i:9;">
		<img src="../img/cloud/cloud3.png" style="--i:8;">
		<img src="../img/cloud/cloud4.png" style="--i:7;">
		<img src="../img/cloud/cloud5.png" style="--i:6;">
	</div>
	<div class="btn">
		<a class="btnL" href="${pageContext.request.contextPath }/mood/mood.jsp">Write</a><br>
		<a class="btnC" href="${pageContext.request.contextPath }/confirm/confirm.jsp">Search</a>
		<a class="btnJ" href="${pageContext.request.contextPath }/sign_up/sign_up.jsp">SignUp</a><br>
		<a class="btnLG" href="${pageContext.request.contextPath }/sign_in/sign_in.jsp">SignIn</a>
	</div>
</div>
</body>
</html>