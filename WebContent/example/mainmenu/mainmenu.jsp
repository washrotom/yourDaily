<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/example/mainmenu/mainMenu_style.css" type="text/css">
</head>
<body>
<header class="sticky">
	<a href="#" class="logo">yourdiary.</a>
	<ul>
		<li><a href="${pageContext.request.contextPath }/mood/mood.jsp">Write</a></li>
		<li><a href="${pageContext.request.contextPath }/confirm/confirm.jsp">Search</a></li>
		<li><a href="${pageContext.request.contextPath }/ListController?id=${sessionScope.id}">내정보보기</a></li>
		<li><a href="${pageContext.request.contextPath }/SignOutController">SignOut</a></li>
	</ul> 
</header>
<script type="text/javascript">
	window.addEventListener("scroll", function() {
		var header = document.querySelector("header");
		header.classList.toggle("sticky", window.scrollY > 0);
	})
</script>
</body>
</html>