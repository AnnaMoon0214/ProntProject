<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int no = (int) request.getAttribute("no");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제여부 확인</title>
<script>
	function loadFnc() {
		var ok = confirm('진짜 삭제 하시겠습니까?');
		if (ok == true) {
			document.getElementById('delete').submit();
		} else {
			window.location.href = 'list';
		}
	}
	window.onload = loadFnc;
</script>

</head>
<body>
	<jsp:include page="Header.jsp" />
	<form id='delete' action='delete' method='post'>
		<input type='hidden' name='no' value='<%=request.getParameter("no")%>'>
	</form>
	<jsp:include page="Tail.jsp" />
</body>
</html>