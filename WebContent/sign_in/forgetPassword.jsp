<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function getID() {
	
}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/ForgetPasswordController" method="get">
<input type="text" placeholder="����� ���̵� �Է��ϼ���" name="id">
<input type="button" onclick="getID()" value="���̵�Ȯ��">
<input type="text" name="pwd" placeholder="�����Է��� ��й�ȣ" value="">
<input type="text" name="pwd" placeholder="�����Է��� ��й�ȣ Ȯ��" value="">
<input type="submit" value="��й�ȣ ����">
</form>
</body>
</html>