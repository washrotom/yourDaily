<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<h3>yourdiary..</h3>
	<a href="${pageContext.request.contextPath }/live/live.jsp">write</a>
	<br>
	<div>
	<c:if test="${not empty list }" >
		<ul>
			<li><c:forEach var="b" items="${list }">
				<li><a href="${pageContext.request.contextPath}/
				ReadController?name=${b.name}">${b.title }</a></li>
			</c:forEach></li>
		</ul>
	</c:if>
	</div>
	<c:if test="${ empty list }">
		작성된 글이 없습니다.
	</c:if>
</body>
</html>