<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>ȸ�� ���� ����</h3>
	<form action="${pageContext.request.contextPath }/EditController"
	 method="post">
		id: <input type="text" name="id"><br />
		pwd:<input type="text" name="pwd"><br />
		name:<input type="text" name="name"><br />
		type : <input type = "radio" name = "type" value = "1"> �Ϲ�����
        <input type = "radio" name = "type" value = "2"> ���ٱ��� <br />
		<input type="submit" value="����"> <br />
	</form>
</body>
</html>