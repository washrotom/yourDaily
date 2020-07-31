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
<link rel="stylesheet" href="${pageContext.request.contextPath }/confirm/style.css" type="text/css">
</head>
<body>
	<h3>yourdiary..</h3>
	<a href="${pageContext.request.contextPath }/live/live.jsp">write</a>
	<br>
		<ul>
			<li><a href="#red">1 Jan</a></li>
			<li><a href="#green">2 Feb</a></li>
			<li><a href="#blue">3 Mar</a></li>
			<li><a href="#yellow">4 Apr</a></li>
			<li><a href="#magenta">5 May</a></li>
			<li><a href="#red">6 Jun</a></li>
			<li><a href="#red">7 Jul</a></li>
			<li><a href="#green">8 Aug</a></li>
			<li><a href="#blue">9 Sep</a></li>
			<li><a href="#yellow">10 Oct</a></li>
			<li><a href="#magenta">11 Nov</a></li>
			<li><a href="#yellow">12 Dec</a></li>
			<li><a href="${pageContext.request.contextPath }/live/live.jsp">write</a></li>
		</ul>


	<c:if test="${not empty list }" >
		<link rel="stylesheet" href="${pageContext.request.contextPath }/example/menu_style.css" type="text/css">
			<c:forEach var="b" items="${list }">
				<section>
					<div class="card">
						<div class="box">
							<div class="imgBx">
								<img src="../img/sky.jpg"><br>
								<h1>${b.title }</h1>
							</div>
							<div class="contentBx">
								<div>
									<h2>Post Title</h2>
									<p>content content content contentcontent content content content contentcontentcontentcontentcontent</p> 
								</div>
							</div>
						</div>
					</div>
				</section>
			</c:forEach>
	</c:if>
	<c:if test="${ empty list }">
		<li>작성된 글이 없습니다.</li>
	</c:if>
				<a href="${pageContext.request.contextPath}/
				ReadController?name=${b.name}">${b.title }</a>
</body>
</html>