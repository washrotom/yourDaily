<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
<link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/in/style.css">
</head>
<body>
<div>
<c:if test="${not empty sessionScope.id }">
<h1 class="text">yourdiary.</h1>
	<div class="clouds">
		<img src="${pageContext.request.contextPath }/img/cloud/cloud1.png" style="--i:1;">
		<img src="${pageContext.request.contextPath }/img/cloud/cloud2.png" style="--i:2;">
		<img src="${pageContext.request.contextPath }/img/cloud/cloud3.png" style="--i:3;">
		<img src="${pageContext.request.contextPath }/img/cloud/cloud4.png" style="--i:4;">
		<img src="${pageContext.request.contextPath }/img/cloud/cloud5.png" style="--i:5;">
		<img src="${pageContext.request.contextPath }/img/cloud/cloud1.png" style="--i:10;">
		<img src="${pageContext.request.contextPath }/img/cloud/cloud2.png" style="--i:9;">
		<img src="${pageContext.request.contextPath }/img/cloud/cloud3.png" style="--i:8;">
		<img src="${pageContext.request.contextPath }/img/cloud/cloud4.png" style="--i:7;">
		<img src="${pageContext.request.contextPath }/img/cloud/cloud5.png" style="--i:6;">
	</div>
<header class="sticky">
	<a href="#" class="logo">yourdiary.</a>
	<ul>
		<li><a href="${pageContext.request.contextPath }/mood/mood.jsp">Write</a></li>
		<li><a href="${pageContext.request.contextPath }/confirm/confirm.jsp">Search</a></li>
		<li><a href="${pageContext.request.contextPath }/ListController?id=${sessionScope.id}">내정보보기</a></li>
		<li><a href="${pageContext.request.contextPath }/SignOutController">SignOut</a></li>
	</ul> 
</header>
</c:if>	
</div>
<script type="text/javascript">
	window.addEventListener("scroll", function() {
		var header = document.querySelector("header");
		header.classList.toggle("sticky", window.scrollY > 0);
	})
</script>



<c:if test="${empty sessionScope.id }">
<link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/sign_in/style.css">
	<section>
	<div class="container">
		<div class="login-form">
				<h1>Login Failed.</h1>
			<form action="${pageContext.request.contextPath }/SigninController" method="post">
					<p>please check the id/pwd.</p>
					<input type="text" name="id" placeholder="ID">
					<input type="password" name="pwd" placeholder="Pssword">  
					<input type="submit" value="Login">
			</form>
			<a href="${pageContext.request.contextPath }/sign_in/manager_in.jsp">관리자로 로그인</a><hr>
			<a href="${pageContext.request.contextPath }/sign_up/sign_up.jsp">Creating an account.</a><br>
			<a href="${pageContext.request.contextPath }/sign_in/forgetPassword.jsp">Forget Password.</a><hr>
			<a href="${pageContext.request.contextPath }/in/in.jsp">home.</a>
		</div>
	</div>
</section>
</c:if>
</body>
</html>