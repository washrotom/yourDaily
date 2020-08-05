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
<c:if test="${not empty sessionScope.id }">
	<div>
	<h1 class="text">yourdiary.</h1>
	<div class="btn">
		<a class="btnL" href="${pageContext.request.contextPath }/mood/mood.jsp">Write</a><br>
		<a class="btnC" href="${pageContext.request.contextPath }/confirm/confirm.jsp">Search</a>
		<a class="btnJ" href="${pageContext.request.contextPath }/sign_up/sign_up.jsp">SignUp</a><br>
		<a class="btnLG" href="${pageContext.request.contextPath }/SignOutController">SignOut</a>
		<a class="btnMI" href="${pageContext.request.contextPath }/ListController?id=${sessionScope.id}">내정보보기</a>
	</div>
</div>
</c:if>	
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