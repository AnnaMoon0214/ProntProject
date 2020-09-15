<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.hk.member.dto.Member"%>
<%
	//Member member = (Member) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>회원 정보수정</title>
<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="Header.jsp" />
	<h1>&nbsp;&nbsp;&nbsp;회원 정보수정</h1>
	<form action='update' method='post'>
		<%-- 번호: <input type='text' name='no' value='${member.no}' readonly><br>
		이름: <input type='text' name='name' value='${member.name }'><br>
		이메일: <input type='text' name='email' value='${member.email }'><br>
		암호: <input type='password' name='password' value='${member.password }'><br> 
		가입일: <input type='text' name='cre_date' value='${member.createdDate }' readonly><br>
		<input type='submit' value='수정'> 
		<input type='reset' value='초기화'>
		<input type="button" onclick='location.href="list"' value='취소'>
		<input type='button' onclick='location.href="delete?no=${member.no}"' value='회원탈퇴'> --%>
		<div class="col-sm-8 form-group">
			<input type="text" class="form-control form-control-user" name='no'
				value='${member.no}' readonly>
		</div>
		<div class="col-sm-8 form-group">
			<input type="text" class="form-control form-control-user"
				id="exampleFirstName" name='name' value='${member.name }'>
		</div>
		<div class="col-sm-8 form-group">
			<input type="email" class="form-control form-control-user"
				id="exampleInputEmail" name='email' value='${member.email }'>
		</div>
		<div class="col-sm-8 form-group">
			<input type="password" class="form-control form-control-user"
				id="exampleInputPassword" name='password' value='${member.password }'>
		</div>
		<div class="col-sm-8 form-group">
			<input type="text" class="form-control form-control-user" name='no'
				value='${member.createdDate }' readonly>
		</div>
		<div class="col-sm-8 form-group">
			<div class="row">
				<div class="col-sm-3">
					<input type='submit' value='수정'
						class="btn btn-primary btn-user btn-block">
				</div>
				<div class="col-sm-3">
					<input type='reset' value='초기화'
						class="btn btn-primary btn-user btn-block">
				</div>
				<div class="col-sm-3">
					<input type='button' value='취소' onclick='window.location.href="list"' class="btn btn-primary btn-user btn-block">
				</div>
			</div>
		</div>







	</form>


	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/chart-area-demo.js"></script>
	<script src="js/demo/chart-pie-demo.js"></script>
	<jsp:include page="Tail.jsp" />
</body>
</html>
