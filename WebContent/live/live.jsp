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
	alert("Ȩ���� �̵��Ͻðڽ��ϱ�?");
	location.href='${pageContext.request.contextPath }/in/in.jsp'
}

function live() {
	var flag = confirm("�ϱ⸦ ����Ͻðڽ��ϱ�?");
	if(flag) {		
		f.submit();	
	} else alert("����� ��ҵǾ����ϴ�.");
}
</script>
</head>
<body>
<form name="f" action="${pageContext.request.contextPath }/LiveController" method="post">
	<div class="live-form">
		<h1 style="font: bold;">My diary..</h1>
		<div class="txtb">
			<label>id :</label>
			<input type="text" name="id" value="${sessionScope.id }" placeholder="${sessionScope.id }" readonly="readonly">
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
		<input type="button" value="�����ϱ�" onclick="">
		<input type="button"  onclick="a()" value="Ȩ����">
		<input type="file" value="�̹������ε�">
	</div>
</form>
	
</body>
</html>