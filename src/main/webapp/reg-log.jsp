<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>

<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/reg-log.css">
	<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
		
	<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css">
	<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js"></script>

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
<style>

#success_message{ display: none;}

</style>




</head>
<body>
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
								<form id="login-form" action="http://phpoll.com/login/process" method="post" role="form" style="display: block;">
									<div
		style="max-width: 400px; padding: 10px 20px; margin: auto; margin-top: calc(50vh - 220px);">
		<h3 style="text-align: center">Welcome to SodhanaLibrary</h3>
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
		<div id="forLoginUser" style="display: none">
			Now you can access <br /> <a href="ChangePassword">Change
				Password</a> <br /> <a href="Logout">Logout</a> <br />
		</div>
		<form class="form-horizontal" id="formLogin" data-toggle="validator"
			role="form">
			<div class="form-group">
				<label for="inputEmail" class="control-label">Email</label> <input
					name="inputEmail" type="email" class="form-control" id="inputEmail"
					placeholder="Enter Email" data-error="Enter valid Email" required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="control-label">Password</label> <input
					type="password" name="inputPassword" class="form-control"
					id="inputPassword" placeholder="Enter Password"
					data-error="Password should not be null" required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="row" style="margin-bottom: 7px">
				<div class="col-sm-6" style="text-align: left">
					<a href="forgotPassword.html">Forgot password ?</a>
				</div>
				<div class="col-sm-6" style="text-align: right">
					<a href="emaiRegistration.html">Register</a>
				</div>
			</div>
			<div class="form-group">
				<button style="width: 100%" type="submit"
					class="btn btn-default btn-primary">Login</button>
			</div>
		</form>
	</div>
	<div id="blockUiDiv">
		<img src="wave.svg" />
	</div>
	<div id="blockUiBackdrop"></div>
	<script>
		$(function() {
			$('#formLogin').validator().on(
					'submit',
					function(e) {
						blockUi();
						if (e.isDefaultPrevented()) {
							// handle the invalid form...
						} else {
							// everything looks good!
							$.post(
									"Login",
									$("#formLogin").serialize(),
									function(data) {
										var jdata = JSON.parse(data);
										if (jdata.code == -1) {
											$("#errorField .message").text(
													jdata.message);
											$("#errorField").show();
											$("#successField").hide();
											$("#forLoginUser").hide();
										} else if (jdata.code == 0) {
											$("#successField .message").text(
													jdata.message);
											$("#errorField").hide();
											$("#successField").show();
											$("#formLogin").hide();
											$("#forLoginUser").show();
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
								<form id="register-form" action="http://phpoll.com/register/process" method="post" role="form" style="display: none;">
									<div class="form-group">
										<input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
									</div>
									<div class="form-group">
										<input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
									</div>
									<div class="form-group">
										<input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>