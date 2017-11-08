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
<title>Movie Wishlist</title>
 <c:import url="./includes.jsp" />
</head>
<body>
	<c:import url="./header.jsp" />
	<form method="get" action="./searchFrieds">
	<section class="global-page-header">
	<div class="container">
	<div class="input-group">
    <input type="text" class="form-control" placeholder="Search" name="user-search">
    <div class="input-group-btn">
      <button class="btn btn-default" type="submit">
        <i class="glyphicon glyphicon-search"></i>
      </button>
    </div>
  </div>
  </div>
	</section>
	</form>
	
	<section id="service-page" class="pages service-page">
	
	
	
   
    
    
	<div class="container">
		<div class="row">
			<div class="col-md-2">

				<div class="thumbnail">
					<a href="./friendProfile?uid=${user.getuId()}"> <img
						src="${pageContext.request.contextPath}/resources/images/default-img.png"
						alt="Nature" style="width: 100%"class="img-circle">
						<div class="caption">
							<p>${ownUser.getuName()}</p>
							
						</div>
					</a>
					<c:choose>
					<c:when test="${isFollow == false}">
					<div class="container">
					<a href="./follow?uid=${ownUser.getuId()} "><button type="button" class="btn btn-primary active" >Follow</button></a>
					
					</div>
					</c:when>
					<c:otherwise>
					<div class="container">
					
					<a href="./unFollow?uid=${ownUser.getuId()} "><button type="button" class="btn btn-primary active">UnFollow</button></a>
					</div>
					</c:otherwise>
					</c:choose>
				</div>
			</div>
		
		
		<div class="row" >
			<h2 align="center">${ownUser.getuName()}'s Wishlist</h2>
			<c:forEach var="movie" items="${myMovieList}">

   
			
			
					<div class="col-sm-2">
					
						<div class="thumbnail" style="width: 150px; height: 170px">
						<a href="./details?movieId=${movie.getImdbID() }">
							<img src="${movie.getPoster()}" alt="Lights"
								style="width: 150px; height: 170px">
								</a>
							<div class="caption">
							<c:choose>
							<c:when test="${movie.getTitle().length() > 12}" >
								
								<a data-toggle="tooltip" data-placement="top"
									title="${movie.getTitle()}"><p>${movie.getTitle().substring(0, 11)}...</p>
								
                              </a>
								<script>
									$(document).ready(function() {
										$('[data-toggle="tooltip"]').tooltip();
									});
								</script>
								</c:when>
								<c:otherwise>
								    <p>${movie.getTitle()}</p>
								</c:otherwise>
								</c:choose>
								<p>(${movie.getYear() })</p>
							</div>
							
						</div>
					</div>
					
			</c:forEach>


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