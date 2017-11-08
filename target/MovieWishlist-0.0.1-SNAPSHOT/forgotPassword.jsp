
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/resources/images/favicon.ico">
<title>Wishlist</title>

  <c:import url="./includes.jsp" />
  
   <style> 
 .form-horizontal .control-label { 
 	margin-bottom: 5px; 
 } 

 .form-horizontal .form-group { 
 	margin-bottom: 5px; 
 	margin-left: 0px; 
	margin-right: 0px; 
 } 

 body { 
	background-color: #f4f4f4; 
} 
 </style> 
  
  
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/validator.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/my-block-ui.css">
<script src="${pageContext.request.contextPath}/resources/js/my-block-ui.js"></script>
  
  
</head>
<body>
	<c:import url="./header.jsp" />

		
	<!--
            ==================================================
            Slider Section Start
            ================================================== -->
	<section id="about">
	<div class="container">
		<div class="row">
			<div 
		style="max-width: 400px; padding: 10px 20px; margin: auto; margin-top: calc(50vh - 220px);">
		<h3 style="text-align: center">Forgot Password</h3>
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
		<form class="form-horizontal" id="formForgotPassword"
			data-toggle="validator" role="form">
			<div class="form-group">
				<label for="inputEmail" class="control-label">Email</label> <input
					name="inputEmail" type="email" class="form-control" id="inputEmail"
					placeholder="Enter Email" data-error="Enter valid Email" required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<button style="width: 100%" type="submit"
					class="btn btn-default btn-primary">Send Verification Link</button>
			</div>
		</form>
		
		<div id="blockUiBackdrop"></div>
	</div>
	<script>
		$(function() {
			$('#formForgotPassword').validator().on(
					'submit',
					function(e) {
						if (e.isDefaultPrevented()) {
							// handle the invalid form...
						} else {
							blockUi();
							// everything looks good!
							$.post(
									"ForgotPassword",
									$("#formForgotPassword").serialize(),
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
											$("#formForgotPassword").hide();
										}
									}).always(function() {
								unBlockUi();
							});
						}
						return false;
					});
		});
	</script>
		</div>
	</div>
	</section>
	<c:import url="./footer.jsp" />

</body>
</html>


