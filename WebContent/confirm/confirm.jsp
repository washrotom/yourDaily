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
<jsp:include page="../example/mainmenu/mainmenu.jsp"/>
<section>
	<div class="container">
		<div class="login-form">
				<h1>글확인</h3>
			<form action="${pageContext.request.contextPath }/ListController">
				<input type="text" name="id" placeholder="이름" value="${sessionScope.id }">
				<input type="hidden" name="myid" value="${sessionScope.id }">
				<input type="submit" value="찾기">
			</form>
			<hr><a href="${pageContext.request.contextPath }/in/in.jsp">home.</a>
		</div>
	</div>
</section>
</body>
</html>