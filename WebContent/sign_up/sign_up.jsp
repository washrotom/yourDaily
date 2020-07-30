<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../sign_in/style.css">
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
				<input type="text" placeholder="your type." name="type">
				<input type="submit" value="submit">
			</form>
		</div>
	</div>
</section>
</body>
</html>