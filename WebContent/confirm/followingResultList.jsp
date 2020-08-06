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
<jsp:include page="../example/mainmenu/mainmenu.jsp"/>
<c:if test="${not empty sessionScope.id }">
		<ul class="classul">			
			<div class="follow">
				<jsp:include page="/follow/followResult.jsp"/>		
			</div>
			<br>
			<li><a class="month" href="#red">1 Jan</a></li>
			<li><a class="month" href="#green">2 Feb</a></li>
			<li><a class="month" href="#blue">3 Mar</a></li>
			<li><a class="month" href="#yellow">4 Apr</a></li>
			<li><a class="month" href="#magenta">5 May</a></li>
			<li><a class="month" href="#red">6 Jun</a></li>
			<li><a class="month" href="#red">7 Jul</a></li>
			<li><a class="month" href="#green">8 Aug</a></li>
			<li><a class="month" href="#blue">9 Sep</a></li>
			<li><a class="month" href="#yellow">10 Oct</a></li>
			<li><a class="month" href="#magenta">11 Nov</a></li>
			<li><a class="month" href="#yellow">12 Dec</a></li>
			<li><a class="month" href="${pageContext.request.contextPath }/live/live.jsp">write</a></li>
		</ul>
</c:if>

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


<c:if test="${empty sessionScope.id }">
		<ul class="classul">
		<div class="follow">
			<jsp:include page="/follow/followResult.jsp"/>		
		</div>	
			<br>
<li><a class="month" href="#red">1 Jan</a></li>
			<li><a class="month" href="#green">2 Feb</a></li>
			<li><a class="month" href="#blue">3 Mar</a></li>
			<li><a class="month" href="#yellow">4 Apr</a></li>
			<li><a class="month" href="#magenta">5 May</a></li>
			<li><a class="month" href="#red">6 Jun</a></li>
			<li><a class="month" href="#red">7 Jul</a></li>
			<li><a class="month" href="#green">8 Aug</a></li>
			<li><a class="month" href="#blue">9 Sep</a></li>
			<li><a class="month" href="#yellow">10 Oct</a></li>
			<li><a class="month" href="#magenta">11 Nov</a></li>
			<li><a class="month" href="#yellow">12 Dec</a></li>
			<li><a class="month" href="${pageContext.request.contextPath }/live/live.jsp">write</a></li>
		</ul>
</c:if>

	<c:if test="${not empty list }" >
		<link rel="stylesheet" href="${pageContext.request.contextPath }/example/menu_style.css" type="text/css">
		<section>
			<c:forEach var="b" items="${list }">
				<div class="card">
					<div class="box">
						<div class="imgBx">
							<img src="${pageContext.request.contextPath }/img/sky.jpg"><br>
							<h1>${b.title }</h1>
						</div>
						<div class="contentBx">
							<div>
								<h2>${b.title }</h2>
									<p>${b.content }</p> 
							<a href="${pageContext.request.contextPath }/ReadController?num=${b.num}"></a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</section>
	</c:if>
								
							<c:if test="${ empty list }">
					<link rel="stylesheet" href="${pageContext.request.contextPath }/example/menu_style.css" type="text/css">
		<section>
				<div class="card">
					<div class="box">
						<div class="imgBx">
							<img src="${pageContext.request.contextPath }/img/sky.jpg"><br>
						</div>
						<div class="contentBx">
							<div>
								<h2>Empty.</h2>
									<p>empty empty empty empty empty empty</p> 
							</div>
						</div>
					</div>
				</div>
		</section>
							</c:if>
				<a href="${pageContext.request.contextPath}/
				ReadController?name=${b.name}">${b.title }</a>
</body>
</html>