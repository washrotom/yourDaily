<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<section>
	<div class="container">
		<div class="login-form">
				<h1>Sign_up.</h1>
			<form action="${pageContext.request.contextPath }/SignupController" method="post">
				<input type="text" placeholder="your id." name="id">
				<input type="text" placeholder="your password." name="pwd">
				<input type="text" placeholder="your nickname." name="name">
				<input type="hidden" name="type" value="3">
				<input type="submit" value="submit">
			</form>
			<hr><a href="${pageContext.request.contextPath }/in/in.jsp">home.</a>
		</div>
	</div>
</section>
</body>
</html>