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
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/resources/images/favicon.ico">
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



	<!-- 
        ================================================== 
            Works Section Start
        ================================================== -->
	<section class="works service-page">
	<div class="container">
		<div class="row">
			<c:forEach var="movie" items="${movieList}">

				<div class="col-sm-4">
					<div class="thumbnail" style="width: 270px; height: 400px">
						<img src="${movie.getPoster()}" alt="Lights"
							style="width: 270px; height: 300px">
						<div class="caption">
							<c:if test="${movie.getTitle().length() > 12}">
								<a data-toggle="tooltip" data-placement="top"
									title="${movie.getTitle()}"><p>${movie.getTitle().substring(0, 11)}...</p>
								</a>

								<script>
									$(document).ready(function() {
										$('[data-toggle="tooltip"]').tooltip();
									});
								</script>
							</c:if>
							<c:if test="${movie.getTitle().length() <= 12}">
								<p>${movie.getTitle()}</p>
							</c:if>
						</div>
						<center>
							<div>
<%-- 							<c:forEach var="imdbid" items="${imdbid}"> --%>
<%-- 							<p>${imdbid }<p> --%>
<%-- 							</c:forEach> --%>
								<form method="POST"
									action="./wishlist?movieId=${movie.getImdbID()}" style="display:inline;">
									<input type="submit" class="btn btn-primary btn-sm" value="Add" />
								</form>
								
								<a href="./details?movieId=${movie.getImdbID()}" class="btn btn-primary btn-sm" role="submit">Detail</a>
							</div>
						</center>
					</div>
				</div>


			</c:forEach>


		</div>
	</div>
	</section>

	<div class="container" style="clear: both">
		<nav aria-label="Page navigation">
		<ul class="pagination" id="pagination"></ul>
		</nav>
	</div>


	<script type="text/javascript">
		pageSize = 9;
		//var pageCount = Math.ceil($(".content").size() / pageSize);

		$(function() {

			var obj = $('#pagination').twbsPagination({

				totalPages : ${total},
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



		<c:import url="./footer.jsp" />
</body>
</html>