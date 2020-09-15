<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//String name=(String)request.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제결과</title>
<script>
	window.onload = function() {
		setTimeout(function() {
			window.location.href = 'list';
		}, 3000);
	}
</script>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<p>${name}님 삭제 성공입니다!</p>
	<jsp:include page="Tail.jsp" />
</body>
</html>