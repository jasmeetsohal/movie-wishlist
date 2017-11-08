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
    
    
    <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
    
    #contain{
      display:block;
    }
  </style>
    
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
 
 
 
 <section id="feature" class="pages service-page">
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <div class="container">
		<div class="row">
			<div class="col-md-2">

				<div class="thumbnail">
					<a href="./myProfile?uid=${user.getuId() }"> <img
						src="${pageContext.request.contextPath}/resources/images/default-img.png"
						alt="Nature" style="width: 100%" class="img-circle">
						<div class="caption">
							<p>${user.getuName()}</p>
						</div>
					</a>
				</div>
			</div>
		</div> 
		 </div>

    </div>

    <div class="col-sm-9">
     <div class="container">
  <h2>Profile</h2>

  <ul class="nav nav-tabs">

    <li class="active"><a data-toggle="tab" href="#home">WISHLIST (${myMovieList.size()})</a></li>
    <li><a data-toggle="tab" href="#menu2">FOLLOWING (${friendList.size() })</a></li>
    <li><a data-toggle="tab" href="#menu3">FOLLOWER (${followersList.size() })</a></li>
  </ul>

  <div class="tab-content">

    
    <div id="home" class="tab-pane fade in active">
      <h3></h3>
      
      
      
      
      
      <p>
      
      
       <div class="row">
			
			<c:forEach var="movie" items="${myMovieList}">
      
      
      	<div class="col-sm-2"> 
						<a href="./details?movieId=${movie.getImdbID()}">
						<div class="thumbnail" style="width: 100px; height: 120px">
							<img src="${movie.getPoster()}" alt="Lights"
								style="width: 100px; height: 120px">
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
						</a>
					</div>
					
			</c:forEach>
			<form action="./MyMovie" method="post"><input type="submit" class="btn btn-primary btn-sm" value="more.."/> </form>
			


		</div>
	
		
	
</p>
    </div>
    <div id="menu2" class="tab-pane fade">
      
      
      
      <c:forEach var="follower" items="${friendList}"> 
      <p> <div class="container">
		<div class="row">
			<div class="col-sm-2">

				<div class="thumbnail">
					<a href="./friendProfile?uid=${follower.getuId()}"> <img
						src="${pageContext.request.contextPath}/resources/images/default-img.png"
						alt="Nature" style="width: 100%" class="img-circle">
						<div class="caption">
							<p>${follower.getuName()}</p>
						</div>
					</a>
				</div>
			</div>
		</div>
		
		 
		 
		 
		 
		 
		 </div>
		 </c:forEach>
		 </p>
    </div>
    <div id="menu3" class="tab-pane fade">
     
      <p>

     <c:forEach var="follower" items="${followersList}"> 
      <p> <div class="container">
		<div class="col">
			<div class="col-md-2">

				<div class="thumbnail">
					<a href="./friendProfile?uid=${follower.getuId()}"> <img
						src="${pageContext.request.contextPath}/resources/images/default-img.png"
						alt="Nature" style="width: 100%" class="img-circle">
						<div class="caption">
							<p>${follower.getuName()}</p>
						</div>
					</a>
				</div>
			</div>
		</div>
		
		 
		 
		 </div>
		 </c:forEach>


</p>
    </div>
  </div>
</div>
    </div>
  </div>
</div>
<c:import url="./footer.jsp" />

</body>







</html>