<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("l_name");

String title = request.getParameter("title");
String title1 = request.getParameter("title1");
%>

<h1><%=name %></h1>
<h2><%=title %></h2>
<h2><%=title1 %></h2>
</body>
</html>