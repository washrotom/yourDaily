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
				<h1>글확인</h3>
			<form action="${pageContext.request.contextPath }/ListController">
				<input type="text" name="name" placeholder="이름" value="${sessionScope.name }">
				<input type="submit" value="찾기">
			</form>
		</div>
	</div>
</section>
</body>
</html>