<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function ing() {
	var session = document.f.myid;
	var confirmFollow = confirm("${list[0].id}���� �ȷο� �Ͻðڽ��ϱ�?");
	if(session.value=="") {
		alert("�α��� ���� �ϼ���.");
		session.value = "";
	 	return false;
	} else {		
		if(confirmFollow) {	
			f.submit();
		} else return false;
	}
}

function p() {
	var profile = confirm("�������� �����Ͻðڽ��ϱ�?");
	if(profile) {
		location.href="${pageContext.request.contextPath }/in/in.jsp";		
	} else return false;
}
</script>
</head>
<body>
<div>
<form name="f" action="${pageContext.request.contextPath }/FollowController">
	<div style="font-weight: bold; font-size: 35px; margin: 10px 10px;">
		${list[0].id} 	<input type="button" name="following" onclick="ing()" value="follow">
						<input type="button" onclick="p()" value="edit profile">
						<input type="hidden" name="id" value="${list[0].id }">
						<input type="hidden" name="myid" value="${sessionScope.id }">
	</div>
</form>
<form action="">
	<div style="font-weight:normal; font-size: 16px; margin: 5px 10px; text-overflow: clip; font-variant: small-caps; word-spacing: 25px;">
		<span>
			<c:if test="${not empty size }">
				<a href="" style="text-decoration: none; display: inline-block; margin: 0">	
					${size}
				</a>�Խù�
			</c:if>
		</span>
		<span><a href="${pageContext.request.contextPath }/FollowListController">n</a></span>�ȷο�  
		<span><a href="">n</a></span>�ȷ���
	</div><hr>
</form>
</div>
</body>
</html>