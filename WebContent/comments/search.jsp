<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="VO.SignVO"%>
<%@ page import="VO.CommentVO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
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
		<c:if test="${sessionScope.id != livenum.id }">
			readonly
		</c:if>
	</c:set>
	<h3>글 읽기</h3>
<form action="${pageContext.request.contextPath }/EditBoardController"
		method="post">
		<table border="1" >
			<tr>
				<th>글 번호</th>
		<td><input type="text" value="${livenum.num }" name="num" size="45"
					readonly></td>
			</tr>
			<tr>
				<th>작성자</th>
		<td><input type="text" value="${livenum.id }" name="writer"
					size="45" readonly></td>
			</tr>
			<tr>
				<th>작성날짜</th>
	<td><input type="text" value="${livenum.w_date }" size="45" readonly></td>
			</tr>
			<tr>
				<th>글 제목</th>
				<td><input type="text" name="title" value="${livenum.title }"
					size="45" ${str }></td>
			</tr>
			<tr>
				<th>글 내용</th>
<td><textarea name="content" rows="15" cols="45" ${str }>${livenum.content }
</textarea></td>
			</tr>
			<c:if test="${sessionScope.id == livenum.id }">
				<tr>
					<td colspan="2">
					<input type="submit" value="수정">
			<input type="button" value="삭제" onclick="del(${livenum.num})">
					</td>
				</tr>
			</c:if>
		</table>
	</form>

	
	<!--  댓글 작성 -->
	
	<form action="${pageContext.request.contextPath }/CommentInsertController?num${livenum.num}" method="post">
	<table border="1" >
	   <tr>
		<th>id</th>
		<td><input type="text" name="comment_ID" value="${sessionScope.id }" readonly><br />
			</tr>
			
	        <tr>
			<th>댓글 </th>
			<td><textarea name="comment_Content" rows="5" cols="45">
			</textarea><br></td>
			</tr>
			<tr>
			<input type="hidden" name="comment_Bnum" value="${livenum.num}">
			</tr>
			<tr>
			<td colspan="2">
	        <input type="submit" value="댓글작성">
	       
	        </tr>
	        </table></form>
	        
	        
	        
<!-- 댓글 출력  -->
    
    <h3>댓글</h3>
    <br>
  
	<c:if test="${not empty commentlist }">
		<table border="1" cellspacing="0">
			<tr>
				<th>작성자</th>
				<th>댓글</th>

			</tr>
			<c:forEach var="c" items="${commentlist }">
				<tr>
					<td>${c.comment_ID }</td>
						
					<td>${c.comment_Content }</td>
					
				<c:if test="${sessionScope.id == c.comment_ID }">
				<td>
                  <input type="button" value="댓글삭제" onclick="delComment(${c.comment_Num})">
					</td>
			
               </c:if>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${ empty commentlist }">
		
	</c:if>
	</form>
</body>
</html>