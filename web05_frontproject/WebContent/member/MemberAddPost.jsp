<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록결과</title>
<script>
	window.onload = function() {
		setTimeout(function() {
			window.location.href = 'list.do';
		}, 3000);
	};
</script>
</head>
<body>
<jsp:include page="Header.jsp"/>
	<p><%=name%>님 등록 성공입니다!</p>
	<a href='list.do'>리스트로 가기</a>
<jsp:include page="Tail.jsp"/>
</body>
</html>