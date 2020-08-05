<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/follow/follow_style.css" type="text/css">
<script type="text/javascript">
function ing() {
	var session = document.f.myid;
	var confirmFollow = confirm("${list[0].id}님을 팔로우 하시겠습니까?");
	
	if(session.value=="") {
		alert("로그인 먼저 하세요.");
		session.value = "";
	 	return false;
	} else {		
		if(confirmFollow) {
			f.submit();
		} else return false;
	}
	
	return f.reset();
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
<form name="f" action="${pageContext.request.contextPath }/FollowController">
	<div style="font-weight: bold; font-size: 35px; margin: 10px 10px;">
		
		${list[0].id} 					
						<input type="button" name="following" onclick="ing()" value="follow">					
						<input type="button" onclick="p()" value="edit profile">
						<input type="hidden" name="id" value="${list[0].id }">
						<input type="hidden" name="myid" value="${sessionScope.id }">
	</div>
	
</form>
	<div style="font-weight:normal; font-size: 16px; margin: 5px 10px; text-overflow: clip; font-variant: small-caps; word-spacing: 25px;">
		<span>
			<c:if test="${not empty size }">
				게시물 <a href="" style="text-decoration: none; display: inline-block; margin: 0">	
					${size}
				</a>
			</c:if>
		</span>
			
			
			<span class=action onclick="actionToggle()">
			<span>팔로워 ${listsize}</span>
				<ul><li style="text-align: center; justify-content: center;">Followers</li>
					<c:forEach var="ing" items="${followinglist }">
						<li><img src="${pageContext.request.contextPath }/img/apple4.jpg">
						<a class="follow_a" href="${pageContext.request.contextPath}/ListController?id=${ing.myid}">${ing.myid}</a>
						</li>
					</c:forEach>
				</ul>
			</span>
					  			
		<span class=weraction onclick="weractionToggle()">
			<span>팔로잉 ${followerlistsize + mylistsize}</span>
				<ul><li style="text-align: center; justify-content: center;">Follows</li>
					<c:forEach var="wer" items="${followerlist }">
						<li><img src="${pageContext.request.contextPath }/img/apple4.jpg">
						<a class="follow_a" href="${pageContext.request.contextPath}/ListController?id=${wer.myid}">${wer.myid}</a>
						</li>						
					</c:forEach>
					<c:forEach var="my" items="${myfollowinglist }">
						<li><img src="${pageContext.request.contextPath }/img/apple4.jpg">
						<a class="follow_a" href="${pageContext.request.contextPath}/ListController?id=${my.id}">${my.id}</a>
						</li>						
					</c:forEach>
				</ul>
			</span>
	</div><hr>
</div>
	
	<!-- 팔로워 리스트 클릭했을때 리스트 보여주는 스크립트 -->
	<script type="text/javascript">
	var flag = false;
	var werflag = false;
	function actionToggle() {
			flag=true;
			if(flag==true) {
				var action = document.querySelector('.action');
				action.classList.toggle('active');
				werfalg = false;
			}
			return werflag;
	}
	
	function weractionToggle() {
		werflag = true;
		if(werflag==true) {
			var weraction = document.querySelector('.weraction');
			weraction.classList.toggle('weractive');
			flag=false;			
		}
		return flag;
	}
	
	</script>
</body>
</html>