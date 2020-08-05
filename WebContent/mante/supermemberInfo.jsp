<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<c:choose>
		<c:when test="${sessionScop.type eq 3}"><img src="${pageContext.request.contextPath }">
		<h3>회원 정보 수정</h3>
		<form action="${pageContext.request.contextPath }/EditController"method="post">
		id: <input type="text" name="id"><br />
		pwd:<input type="text" name="pwd"><br />
		name:<input type="text" name="name"><br />
		type : <input type = "radio" name = "type" value = "1"> 일반유저
        <input type = "radio" name = "type" value = "2"> 접근금지 <br />
		<input type="submit" value="수정"> <br />
		</form>
		</c:when>
		<c:otherwise>
		<script type="text/javascript">
		location.href="${pageContext.request.contextPath }/index.jsp";
</script>
</c:otherwise>
</c:choose>

</body>
</html>