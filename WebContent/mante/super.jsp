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
관리자페이지입니다.
<a href ="${pageContext.request.contextPath }/mente/supermemberInfo.jsp">회원정보강제수정</a>
<a href ="${pageContext.request.contextPath }/mente/loginForm.jsp">글 블라인드</a>
<a href = "${pageContext.request.contextPath }/log/log.txt"> 로그확인 </a>
</c:when>
<c:otherwise><script type="text/javascript">
		location.href="${pageContext.request.contextPath }/index.jsp";
</script>
</c:otherwise>
</c:choose>
</body>
</html>