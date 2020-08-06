<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.Member"%>
<%@ page import="model.Comment"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Insert title here</title>
<script>

</script>
<script>
function del(num){
location.href = 
	"${pageContext.request.contextPath }/DelBoardController?num="+num;
}



function delComment(comment_Num){
			location.href = 
				"${pageContext.request.contextPath }/CommentDelController?comment_Num="+comment_Num;
	}


</script>
</head>
<body>
	<c:set var="str">
		<c:if test="${sessionScope.id != b.writer }">
			readonly
		</c:if>
	</c:set>
	<h3>�� �б�</h3>
<form action="${pageContext.request.contextPath }/EditBoardController"
		method="post">
		<table border="1" >
			<tr>
				<th>�� ��ȣ</th>
		<td><input type="text" value="${b.num }" name="num" size="45"
					readonly></td>
			</tr>
			<tr>
				<th>�ۼ���</th>
		<td><input type="text" value="${b.writer }" name="writer"
					size="45" readonly></td>
			</tr>
			<tr>
				<th>�ۼ���¥</th>
	<td><input type="text" value="${b.w_date }" size="45" readonly></td>
			</tr>
			<tr>
				<th>�� ����</th>
				<td><input type="text" name="title" value="${b.title }"
					size="45" ${str }></td>
			</tr>
			<tr>
				<th>�� ����</th>
<td><textarea name="content" rows="15" cols="45" ${str }>${b.content }
</textarea></td>
			</tr>
			<c:if test="${sessionScope.id == b.writer }">
				<tr>
					<td colspan="2">
					<input type="submit" value="����">
			<input type="button" value="����" onclick="del(${b.num})">
					</td>
				</tr>
			</c:if>
		</table>
	</form>

	
	<!--  ��� �ۼ� -->
	
	<form action="${pageContext.request.contextPath }/CommentInsertController?num=${b.num}" method="post">
	<table border="1" >
	   <tr>
		<th>id</th>
		<td><input type="text" name="comment_ID" value="${sessionScope.id }" readonly><br />
			</tr>
			
	        <tr>
			<th>��� </th>
			<td><textarea name="comment_Content" rows="5" cols="45">
			</textarea><br></td>
			</tr>
			<tr>
			<input type="hidden" name="comment_Bnum" value="${b.num}">
			</tr>
			<tr>
			<td colspan="2">
	        <input type="submit" value="����ۼ�">
	       
	        </tr>
	        </table></form>
	        
	        
	        
<!-- ��� ���  -->
<link rel="stylesheet" href="css/bootstrap.css">
    <div class="container">
    <h3>���</h3>
    <br>
  
	<c:if test="${not empty list }">
		<table class="table table-hover" border="1" cellspacing="0">
		<thead>
			<tr>
				<th>�ۼ���</th>
				<th>���</th>
		</thead>
		
		<div class="search row">
		 

			</tr>
			<c:forEach var="c" items="${list }">
				<tr>
					<td>${c.comment_ID }</td>
						
					<td>${c.comment_Content }</td>
					
				<c:if test="${sessionScope.id == c.comment_ID }">
				<td>
                  <input type="button" value="��ۻ���" onclick="delComment(${c.comment_Num})">
					</td>
			
               </c:if>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${ empty list }">
		
	</c:if>
	</form>
	


	

	</div>
	</div>
	</div>
</body>
</html>