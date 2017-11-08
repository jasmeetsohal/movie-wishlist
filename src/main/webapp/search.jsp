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
  <c:import url="./includes.jsp" />
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
					<h2>Search</h2>
					<ol class="breadcrumb">
						<li><a href="index.jsp"> <i class="ion-ios-home"></i>
								Home
						</a></li>
						<li class="active">Search</li>
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
		<div id="searchDiv">
		   <fieldset>
					<legend><b>By title</b></legend>
				</fieldset>
			<form method="get" action="./search">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search" name="mtitle">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
		<div id="searchDiv2">
			<form method="get" action="./search">
				<fieldset>
					<legend><b>By imdbId</b></legend>
				</fieldset>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search" name="mid">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
			</div>
		</div>
	</div>
	</section>
	
	
	
	
	
	
	
	


	
	<!-- 
        ================================================== 
            Clients Section Start
        ================================================== -->
	<section id="clients">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 class="subtitle text-center wow fadeInUp animated"
					data-wow-duration="500ms" data-wow-delay=".3s">Our Happy
					Clinets</h2>
				<p class="subtitle-des text-center wow fadeInUp animated"
					data-wow-duration="500ms" data-wow-delay=".5s"></p>
				<div id="clients-logo" class="owl-carousel">
					<div>
						<img src="${pageContext.request.contextPath}/resources/images/clients/logo-1.jpg" alt="">
					</div>
					<div>
						<img src="${pageContext.request.contextPath}/resources/images/clients/logo-2.jpg" alt="">
					</div>
					<div>
						<img src="${pageContext.request.contextPath}/resources/images/clients/logo-3.jpg" alt="">
					</div>
					<div>
						<img src="${pageContext.request.contextPath}/resources/images/clients/logo-4.jpg" alt="">
					</div>
					<div>
						<img src="${pageContext.request.contextPath}/resources/images/clients/logo-5.jpg" alt="">
					</div>
					<div>
						<img src="${pageContext.request.contextPath}/resources/images/clients/logo-1.jpg" alt="">
					</div>
					<div>
						<img src="${pageContext.request.contextPath}/resources/images/clients/logo-2.jpg" alt="">
					</div>
					<div>
						<img src="${pageContext.request.contextPath}/resources/images/clients/logo-3.jpg" alt="">
					</div>
					<div>
						<img src="${pageContext.request.contextPath}/resources/images/clients/logo-4.jpg" alt="">
					</div>
					<div>
						<img src="${pageContext.request.contextPath}/resources/images/clients/logo-5.jpg" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>

	

	<c:import url="./footer.jsp" />
</body>
</html>