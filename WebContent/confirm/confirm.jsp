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
				<h1>��Ȯ��</h3>
			<form action="${pageContext.request.contextPath }/ListController">
				<input type="text" name="id" placeholder="�̸�" value="${sessionScope.id }">
				<input type="submit" value="ã��">
			</form>
			<hr><a href="${pageContext.request.contextPath }/in/in.jsp">home.</a>
		</div>
	</div>
</section>
</body>
</html>