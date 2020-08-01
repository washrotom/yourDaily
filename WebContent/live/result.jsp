<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty sessionScope.id != null}">
	${sessionScope.id }님의 일기가 등록되었습니다.<br>
</c:if>
	<c:if test="${empty sessionScope.id == null }">
		일기가 작성되지 않았습니다. <br>
	</c:if>

<a href="${pageContext.request.contextPath }/confirm/confirm.jsp">Confirm to my diary</a><hr>
<a href="${pageContext.request.contextPath }/live/live.jsp">새로운 일기 등록</a> 
</body>
</html>