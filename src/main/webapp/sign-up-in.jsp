<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<!-- Basic Page Needs
        ================================================== -->
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
<title>Wishlist</title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<!-- Mobile Specific Metas
        ================================================== -->
<meta name="format-detection" content="telephone=no">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Template CSS Files
        ================================================== -->
<!-- Twitter Bootstrs CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<!-- Ionicons Fonts Css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/ionicons.min.css">
<!-- animate css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/animate.css">
<!-- Hero area slider css-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/slider.css">
<!-- owl craousel css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/owl.carousel.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/owl.theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jquery.fancybox.css">
<!-- template main css file -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<!-- responsive css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/responsive.css">





<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/reg-log.css">



<!-- Template Javascript Files
        ================================================== -->
<!-- modernizr js -->
<script
	src="${pageContext.request.contextPath}/resources/js/vendor/modernizr-2.6.2.min.js"></script>
<!-- jquery -->
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<!-- owl carouserl js -->
<script
	src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
<!-- bootstrap js -->

<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- wow js -->
<script src="${pageContext.request.contextPath}/resources/js/wow.min.js"></script>
<!-- slider js -->
<script src="${pageContext.request.contextPath}/resources/js/slider.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.fancybox.js"></script>
<!-- template main js -->
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/validator.min.js"></script>
<link rel="stylesheet" href="css/my-block-ui.css">
<script
	src="${pageContext.request.contextPath}/resources/js/my-block-ui.js"></script>





<script type="text/javascript">
	$(function() {

		$('#login-form-link').click(function(e) {
			$("#login-form").delay(100).fadeIn(100);
			$("#register-form").fadeOut(100);
			$('#register-form-link').removeClass('active');
			$(this).addClass('active');
			e.preventDefault();
		});
		$('#register-form-link').click(function(e) {
			$("#register-form").delay(100).fadeIn(100);
			$("#login-form").fadeOut(100);
			$('#login-form-link').removeClass('active');
			$(this).addClass('active');
			e.preventDefault();
		});

	});
</script>
<style type="text/css">
form-horizontal .control-label {
	margin-bottom: 5px;
}

.form-horizontal .form-group {
	margin-bottom: 5px;
	margin-left: 0px;
	margin-right: 0px;
}
</style>

</head>
<body>
	<!--
        ==================================================
        Header Section Start
        ================================================== -->
	<c:import url="./header.jsp" />

	<!-- 
        ================================================== 
            Global Page Section Start
        ================================================== -->
	<section class="global-page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="block">
					<h2>Authentication</h2>
					<ol class="breadcrumb">
						<li><a href="index.html"> <i class="ion-ios-home"></i>
								Home
						</a></li>
						<li class="active">Authentication</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!--/#Page header-->


	<!-- 
        ================================================== 
            Service Page Section  Start
        ================================================== -->
	<section id="service-page" class="pages service-page">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					
					
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
							
							
								<form id="login-form" action="./Login" method="post" role="form"
									style="display: block;">
									<div
										style="max-width: 400px; padding: 10px 20px; margin: auto; ">
										<div class="alert alert-danger" role="alert" id="errorField"
											style="display: none">
											<span class="glyphicon glyphicon-exclamation-sign"
												aria-hidden="true"></span> <span class="sr-only">Error:</span>
											<span class="message"></span>
										</div>
										<div class="alert alert-success" role="alert"
											id="successField" style="display: none">
											<span class="glyphicon glyphicon-exclamation-sign"
												aria-hidden="true"></span> <span class="sr-only">Success:</span>
											<span class="message"></span>
										</div>
										<div id="forLoginUser" style="display: none">
											Now you can access <br /> <a href="ChangePassword">Change
												Password</a> <br /> <a href="Logout">Logout</a> <br />
										</div>
										<form class="form-horizontal" id="formLogin"
											data-toggle="validator" role="form">
											<div class="form-group">
												<label for="inputEmail" class="control-label">Email</label>
												<input name="inputEmail" type="email" class="form-control"
													id="inputEmail" placeholder="Enter Email"
													data-error="Enter valid Email" required>
												<div class="help-block with-errors"></div>
											</div>
											<div class="form-group">
												<label for="inputPassword" class="control-label">Password</label>
												<input type="password" name="inputPassword"
													class="form-control" id="inputPassword"
													placeholder="Enter Password"
													data-error="Password should not be null" required>
												<div class="help-block with-errors"></div>
											</div>
											<div class="row" style="margin-bottom: 7px">
												<div class="col-sm-6" style="text-align: left">
													<a href="forgotPassword.jsp">Forgot password ?</a>
												</div>
												
											</div>
											<div class="form-group">
												<button style="width: 100%" type="submit"
													class="btn btn-default btn-primary">Login</button>
											</div>
											</form>
											</div>
										
								
									<div id="blockUiBackdrop"></div>
									
									</form>
									<script>
										$(function() {
											$('#formLogin')
													.validator()
													.on(
															'submit',
															function(e) {
																blockUi();
																if (e
																		.isDefaultPrevented()) {
																	// handle the invalid form...
																} else {
																	// everything looks good!
																	$
																			.post(
																					"Login",
																					$(
																							"#formLogin")
																							.serialize(),
																					function(
																							data) {
																						var jdata = JSON
																								.parse(data);
																						if (jdata.code == -1) {
																							$(
																									"#errorField .message")
																									.text(
																											jdata.message);
																							$(
																									"#errorField")
																									.show();
																							$(
																									"#successField")
																									.hide();
																							$(
																									"#forLoginUser")
																									.hide();
																						} else if (jdata.code == 0) {
																							$(
																									"#successField .message")
																									.text(
																											jdata.message);
																							$(
																									"#errorField")
																									.hide();
																							$(
																									"#successField")
																									.show();
																							$(
																									"#formLogin")
																									.hide();
																							$(
																									"#forLoginUser")
																									.show();
																						}
																					})
																			.always(
																					function() {
																						unBlockUi();
																					});
																}
																return false;
															});
										});
									</script>
									
								
								
								<form id="register-form" action="./RegisterEmail" method="post"
									role="form" style="display: none;">
									<div style="max-width: 390px; padding: 5px; margin: auto;">

		<div class="alert alert-danger" role="alert" id="errorField"
			style="display: none">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">Error:</span> <span class="message"></span>
		</div>
		<div class="alert alert-success" role="alert" id="successField"
			style="display: none">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">Success:</span> <span class="message"></span>
		</div>
		<form class="form-horizontal" id="formRegister"
			data-toggle="validator" role="form">
			<div class="form-group">
				<label for="inputEmail" class="control-label">Email</label> <input
					name="inputEmail"
					pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"
					class="form-control" id="inputEmail" placeholder="Enter Email"
					data-error="Enter valid Email" required>
				<div class="help-block with-errors"></div>
			</div>
<!-- 			<div class="form-group"> -->
<!-- 				<label for="inputFirstName" class="control-label">First Name</label> -->
<!-- 				<input pattern="[A-Za-z0-9]{1,20}" name="inputFirstName" -->
<!-- 					class="form-control" id="inputFirstName" -->
<!-- 					placeholder="Enter First Name" -->
<!-- 					data-error="First name should not be null. It should be less than 20 characters. Use only A-Z, a-z, 0-9 charecters" -->
<!-- 					required> -->
<!-- 				<div class="help-block with-errors"></div> -->
<!-- 			</div> -->
			<div class="form-group">
				<label for="inputLastName" class="control-label">Name</label> <input
					pattern="[A-Za-z0-9]{1,20}" name="inputLastName"
					class="form-control" id="inputLastName"
					placeholder="Enter Name"
					data-error="last name should not be null. It should be less than 20 characters. Use only A-Z, a-z, 0-9 charecters"
					data-toggle="tooltip" data-placement="right" required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="control-label">Password</label> <input
					type="password" pattern="[A-Za-z0-9@#$%!^&*]{6,30}"
					name="inputPassword" class="form-control" id="inputPassword"
					placeholder="Enter Password"
					data-error="Password should not be null. It should be greater than 6 and less than 30 characters . Use only A-Z, a-z, 0-9, @ # $ % ! ^ & * charecters"
					required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<label for="inputPassword1" class="control-label">Confirm
					Password</label> <input type="password" name="inputPassword1"
					class="form-control" id="inputPassword1"
					data-match="#inputPassword" placeholder="Enter Password Again"
					data-error="It should not be null and should match with above password"
					required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<button style="width: 100%" type="submit"
					class="btn btn-default btn-primary">Register</button>
			</div>
		</form>
<!-- 		<div id="blockUiDiv"> -->
<!-- 			<img src="wave.svg" /> -->
<!-- 		</div> -->
		<div id="blockUiBackdrop"></div>
	</div>
	<script>
		$(function() {
			$('#formRegister').validator().on(
					'submit',
					function(e) {
						if (e.isDefaultPrevented()) {
							// handle the invalid form...
						} else {
							blockUi();
							// everything looks good!
							$.post(
									"RegisterEmail",
									$("#formRegister").serialize(),
									function(data) {
										var jdata = JSON.parse(data);
										if (jdata.code == -1) {
											$("#errorField .message").text(
													jdata.message);
											$("#errorField").show();
											$("#successField").hide();
										} else {
											$("#successField .message").text(
													jdata.message);
											$("#errorField").hide();
											$("#successField").show();
											$("#formRegister").hide();
										}
									}).always(function() {
								unBlockUi();
							});
						}
						return false;
					});

		});
	</script>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	
	<c:import url="./footer.jsp" />
</body>
</html>