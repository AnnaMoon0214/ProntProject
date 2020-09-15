<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정결과</title>
<script> 
	window.onload = function(){setTimeout(function(){window.location.href='list';},3000);}
</script>
</head>
<body>
<jsp:include page="Header.jsp"/>
<p>수정 성공입니다!</p>
<jsp:include page="Tail.jsp"/>
</body>
</html>