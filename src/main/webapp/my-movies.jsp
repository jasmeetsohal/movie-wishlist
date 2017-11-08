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

<title>Movie</title>
<!-- Basic Page Needs
        ================================================== -->
<c:import url="./includes.jsp" />
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css" -->
<!-- 	integrity="sha384-2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj" -->
<!-- 	crossorigin="anonymous"> -->




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
					<h2>Wishlist</h2>
					<ol class="breadcrumb">
						<li><a href="index.jsp"> <i class="ion-ios-home"></i>
								Home
						</a></li>
						<li class="active">Wishlist</li>
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



	<!-- 
        ================================================== 
            Works Section Start
        ================================================== -->
	<section class="works service-page">
	<div class="container">
		


		<div class="row">
		
			<c:forEach var="movie" items="${myMovieList}">
				<div class="col-sm-4">
					<div class="thumbnail" style="width: 270px; height: 500px">
						<img src="${movie.getPoster()}" alt="Lights"
							style="width: 270px; height: 300px">
						<div class="caption">
							<c:choose>
								<c:when test="${movie.getTitle().length() >= 12}">
								
								<a data-toggle="tooltip" data-placement="top"
									title="${movie.getTitle()}"><p>${movie.getTitle().substring(0, 11)}...</p>
								</a>
								<p>Year : ${movie.getYear() }</p>

								<script>
									$(document).ready(function() {
										$('[data-toggle="tooltip"]').tooltip();
									});
								</script>
						
							
								</c:when>
								<c:otherwise>
									<p>${movie.getTitle()}</p>
									<p>Year : ${movie.getYear() }</p>
								</c:otherwise>
							</c:choose>
						</div>
						<center>
							<a href="./review?movieId=${movie.getMovieId()}"><input
								type="button" value="Rate Now" class="btn btn-primary btn-sm"/></a> <a
								href="./details?movieId=${movie.getImdbID()}"> <input
								type="button" value="Details" class="btn btn-primary btn-sm" /></a>
						</center>
					</div>
				</div>
			</c:forEach>


		</div>
	</div>
	</section>

	<div class="container" style="clear: both">

		<nav aria-label="Page navigation"> <a href="./MyMovie?num=8">
			<ul class="pagination" id="pagination"></ul>
		</a> </nav>

	</div>


	<script type="text/javascript">
	pageSize = 9;
	//var pageCount = Math.ceil($(".content").size() / pageSize);

	$(function() {

		var obj = $('#pagination').twbsPagination({

			totalPages : 1,
			visiblePages : 5,
			onPageClick : function(event, page) {
				console.info(page);
				$('.col-sm-4').hide();
				$(".col-sm-4").each(function(n) {
					if (n >= pageSize * (page - 1) && n < pageSize * page)
						$(this).show();

				});

			}
		});
		console.info(obj.data());

	});
	</script>



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
					data-wow-duration="500ms" data-wow-delay=".5s">Lorem ipsum
					dolor sit amet, consectetur adipisicing elit. Labore, error.</p>
				<div id="clients-logo" class="owl-carousel">
					<div>
						<img
							src="${pageContext.request.contextPath}/resources/images/clients/logo-1.jpg"
							alt="">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath}/resources/images/clients/logo-2.jpg"
							alt="">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath}/resources/images/clients/logo-3.jpg"
							alt="">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath}/resources/images/clients/logo-4.jpg"
							alt="">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath}/resources/images/clients/logo-5.jpg"
							alt="">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath}/resources/images/clients/logo-1.jpg"
							alt="">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath}/resources/images/clients/logo-2.jpg"
							alt="">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath}/resources/images/clients/logo-3.jpg"
							alt="">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath}/resources/images/clients/logo-4.jpg"
							alt="">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath}/resources/images/clients/logo-5.jpg"
							alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>

	
<c:import url="./footer.jsp" />

	
</body>
</html>