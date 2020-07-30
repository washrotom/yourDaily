<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript">
function a() {
	alert("홈으로 이동하시겠습니까?");
	location.href='${pageContext.request.contextPath }/in/in.jsp'
}

function live() {
	var flag = confirm("일기를 등록하시겠습니까?");
	if(flag) {		
		f.submit();	
	} else alert("등록이 취소되었습니다.");
}
</script>
</head>
<body>
<form name="f" action="${pageContext.request.contextPath }/LiveController" method="post">
	<div class="live-form">
		<h1 style="font: bold;">My diary..</h1>
		<div class="txtb">
			<label>name :</label>
			<input type="text" name="name" value="" placeholder="Enter your Name">
		</div>
		<div class="txtb">
			<label>title :</label>
			<input type="text" name="title" value="" placeholder="Enter your Title">
		</div>
		<div class="txtb">
			<label>content :</label>
			<textarea rows="10" cols="" name="content" placeholder="Enter your Content"></textarea>
		</div>
		<input type="button" onclick="live()" value="Writing a diary" class="btn" >
		<input type="reset" value="Clear" class="btn">
		<input type="button" value="공유하기" onclick="">
		<input type="button"  onclick="a()" value="홈으로">
		<input type="file" value="이미지업로드">
	</div>
</form>
	
</body>
</html>