<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>글 목록</h3>
	<a href="${pageContext.request.contextPath }/board/form.jsp">글작성</a>
	<br>
	<c:if test="${not empty list }">
		<table border="1" cellspacing="0">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
			<c:forEach var="b" items="${list }">
				<tr>
					<td>${b.num }</td>
						<td>
						<a href="${pageContext.request.contextPath }/
						ReadController?num=${b.num}">${b.title }</a>
					</td>
					<td>${b.writer }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${ empty list }">
		
	</c:if>
</body>
</html>