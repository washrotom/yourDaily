<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>ȸ������</h3>
	<form action="${pageContext.request.contextPath }/JoinController"
	 method="post">
		id: <input type="text" name="id"><br />
		pwd:<input type="password" name="pwd"><br /> 
		name:<input	type="text" name="name"><br /> 
		email:<input type="text"name="email"><br /> 
		<input type="reset" value="���">
		<input type="submit" value="����"> <br />
	</form>
</body>
</html>



