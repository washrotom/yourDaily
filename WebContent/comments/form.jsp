<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>���ۼ�</h3>
	<form action="${pageContext.request.contextPath }/WriteController"
		method="post">
		<table border="1" cellspacing="0">
			<tr>
				<th>�ۼ���</th>
				<td><input type="text" value="${sessionScope.id }"
					name="writer" size="45" readonly>
				</td>
			</tr>
			<tr>
				<th>�� ����</th>
				<td><input type="text" name="title" size="45"></td>
			</tr>
			<tr>
				<th>�� ����</th>
				<td><textarea name="content" rows="15" cols="45">
				</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="reset" value="���">
				<input type="submit" value="�ۼ�">
				</td>
			</tr>
		</table>
	</form>
	
    


</body>
</html>