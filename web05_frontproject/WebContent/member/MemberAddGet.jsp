<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>신규 회원 가입</title>
<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<link href="css/MemberList.css" rel="stylesheet">
</head>
<body>
	
	<!-- <form action='add' method='post'>
이름 : <input type="text" name="name"><br>
이메일 : <input type="text" name="email"><br>
비밀번호 : <input type="password" name="password"><br>
<input type="submit" value="가입"> -->
	<!-- </form> -->
	<div class="container">
		<div class="p-5">
			<div class="text-center">
				<h1 class="h4 text-gray-900 mb-4">신규 회원 가입</h1>
			</div>
			<form class="user" action="add.do" method="post">
				<div class="col-sm-8 form-group">
					<input type="text" class="form-control form-control-user"
						id="exampleFirstName" name='name' placeholder="Name">
				</div>

				<div class="col-sm-8 form-group">
					<input type="email" class="form-control form-control-user"
						id="exampleInputEmail" name='email' placeholder="Email Address">
				</div>
				<div class="col-sm-8 form-group">
					<input type="password" class="form-control form-control-user"
						id="exampleInputPassword" name='password' placeholder="Password">
				</div>
				<div class="col-sm-8 form-group">
					<input type='submit' value='Register Account'
						class="btn btn-primary btn-user btn-block">
				</div>
			</form>
		</div>
	</div>
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

</body>
</html>