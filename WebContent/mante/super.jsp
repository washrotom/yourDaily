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
�������������Դϴ�.
<a href ="${pageContext.request.contextPath }/mente/supermemberInfo.jsp">ȸ��������������</a>
<a href ="${pageContext.request.contextPath }/mente/loginForm.jsp">�� ����ε�</a>
<a href = "${pageContext.request.contextPath }/log/log.txt"> �α�Ȯ�� </a>
</c:when>
<c:otherwise><script type="text/javascript">
		location.href="${pageContext.request.contextPath }/index.jsp";
</script>
</c:otherwise>
</c:choose>
</body>
</html>