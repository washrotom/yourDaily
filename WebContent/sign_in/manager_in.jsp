<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<section>
	<div class="container">
		<div class="login-form">
				<h1>Manager in.</h1>
			<form action="${pageContext.request.contextPath }/SigninController" method="post">
					<input type="text" name="id" placeholder="ID">
					<input type="password" name="pwd" placeholder="Password">  
					<input type="submit" value="Login">
			</form>
			<a href="${pageContext.request.contextPath }/sign_up/sign_up.jsp">Creating a Manager.</a><br>
			<a href="${pageContext.request.contextPath }/sign_in/forgetPassword.jsp">Forget Password.</a><hr>
			<a href="${pageContext.request.contextPath }/in/in.jsp">home.</a>
		</div>
	</div>
</section>
</body>
</html>