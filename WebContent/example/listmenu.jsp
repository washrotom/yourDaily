<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="listmenu_style.css" type="text/css"> 
</head>
<body>
	<div class="action" onclick="actionToggle()" >
		<span>+</span>
		<ul>
			<li><img src="../img/apple4.jpg">apple !!!!</li>
			<li><img src="../img/apple4.jpg">apple !!!1!1!</li>
			<li><img src="../img/apple4.jpg">apple !!!!!!!!!!!!!!!</li>
			<li><img src="../img/apple4.jpg">apple !!!!111!</li>
		</ul>
	</div>
	<script type="text/javascript">
	function actionToggle() {
		var action = document.querySelector('.action');
		action.classList.toggle('active');
	}
	</script>
</body>
</html>