<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function un() {
	var session = document.f.myid;
	var confirmFollow = confirm("${list[0].id}님을 언팔로우 하시겠습니까?");
	if(session.value=="") {
		alert("로그인 먼저 하세요.");
		session.value = "";
	 	return false;
	} else {		
		if(confirmFollow) {	
			f.submit();
		} else return false;
	}
}

function p() {
	var profile = confirm("프로필을 수정하시겠습니까?");
	if(profile) {
		location.href="${pageContext.request.contextPath }/in/in.jsp";		
	} else return false;
}
</script>
</head>
<body>
<div>
<form name="f" action="${pageContext.request.contextPath }/unFollowController">
	<div style="font-weight: bold; font-size: 35px; margin: 10px 10px;">
		${flist[0].id} 	<input type="button" name="following" onclick="un()" value="unfollow">
						<input type="button" onclick="p()" value="edit profile">
						<input type="hidden" name="id" value="${list[0].id }">
						<input type="hidden" name="myid" value="${sessionScope.id }">
	</div>
</form>
	<div style="font-weight:normal; font-size: 16px; margin: 5px 10px; text-overflow: clip; font-variant: small-caps; word-spacing: 25px;">
		<span>
			<c:if test="${not empty fsize }">
				<a href="" style="text-decoration: none; display: inline-block; margin: 0">	
					${fsize}
				</a>게시물
			</c:if>
		</span>
		<span><a href="${pageContext.request.contextPath }/FollowListController">
			${listsize}
			</a>팔로워</span>  
		<span><a href="">n</a>팔로잉</span>
	</div><hr>
</div>

</body>
</html>