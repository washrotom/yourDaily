<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h3>login</h3>
	<form action="${pageContext.request.contextPath }/LoginController" 
	method="post">

		id:<input type="text" name="id"><br> 
		pwd:<input type="text" name="pwd"><br> 
		<input type="submit" value="로그인"><br>
	
	</form>
<a href="${pageContext.request.contextPath }/member/form.jsp">회원가입</a>
</div>
</body>
</html>