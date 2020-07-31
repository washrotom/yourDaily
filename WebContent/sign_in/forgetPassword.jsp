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
<input type="text" placeholder="당신의 아이디를 입력하세요" name="id">
<input type="button" onclick="getID()" value="아이디확인">
<input type="text" name="pwd" placeholder="새로입력할 비밀번호" value="">
<input type="text" name="pwd" placeholder="새로입력할 비밀번호 확인" value="">
<input type="submit" value="비밀번호 변경">
</form>
</body>
</html>