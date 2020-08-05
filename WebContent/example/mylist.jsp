<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<ul>
		<li><a href="#red">red</a></li>
		<li><a href="#green">green</a></li>
		<li><a href="#blue">blue</a></li>
		<li><a href="#yellow">yellow</a></li>
		<li><a href="#magenta">magenta</a></li>
		<li><a href="${pageContext.request.contextPath }/live/live.jsp">write</a></li>
	</ul>
	
	<div id="container">
		<div id="red"> <h1>구름낀 배경	</h1></div>
		<div id="green"> <h1>green</h1></div>
		<div id="blue"> <h1>blue</h1></div>
		<div id="yellow"> <h1>yellow</h1></div>
		<div id="magenta"> <h1>magenta</h1></div>
	</div>

</body>
</html>