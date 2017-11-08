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
  
    <script src="${pageContext.request.contextPath}/resources/j-plugin/jquery.js" type="text/javascript"></script>
    
    
   



</head>
<body>
<link href="${pageContext.request.contextPath}/resources/j-plugin/rating_simple.css" rel="stylesheet" type="text/css" />

<script src="${pageContext.request.contextPath}/resources/j-plugin/rating_simple.js" type="text/javascript"></script>

	<!--
        ==================================================
        Header Section Start
        ================================================== -->
	<c:import url="./header.jsp" />
	
<%-- 	<script src="${pageContext.request.contextPath}/resources/j-plugin/rating_simple.js" type="text/javascript"></script> --%>

	<!-- 
        ================================================== 
            Global Page Section Start
        ================================================== -->
	<section class="global-page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="block">
					<h2>Review</h2>
					<ol class="breadcrumb">
						<li><a href="index.jsp"> <i class="ion-ios-home"></i>
								Home
						</a></li>
						<li class="active">Review</li>
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
		   <div style="padding:20px;">
	<div  style="width:100%;">

	<img  src="${aMovie.getPoster()}" style=" margin: auto;padding:40px;height:300px;" >
	
	</div>
	
	<h1>Comments</h1>
	<div style="width:100%" >
		<c:forEach var="reviewlist" items="${myReviewList}">
   
   
   <div class="container" >
		<div class="row" >
			<div class="col-md-1" >

				<div class="thumbnail">
					<a href="./friendProfile?uid=${reviewlist.getuId() }"> <img
						src="${pageContext.request.contextPath}/resources/images/default-img.png"
						alt="Nature" style="width: 100%" class="img-circle">
<!-- 						<div class="caption"> -->
<%-- 							<p>${reviewlist.getuName()}</p> --%>
<!-- 						</div> -->
					</a>
				</div>
				
				
				
				
			</div>
			<div class="caption"> 
							<p style="font-weight:bold;">${reviewlist.getuName()}</p>
						</div>
			<div>${reviewlist.getDateTime()}</div>			
		</div> 
		 </div>
   
   
   

				
				<c:forEach var="star"  begin="1" end="${reviewlist.getScore() }">
				 <span class="glyphicon glyphicon-star" style="color:#e67e22" ></span>
				 
				</c:forEach>
				
				
				<span><b>${reviewlist.getScore()}/10</b></span>
				<div style="background-color:white;width:100%;margin:20px;">${reviewlist.getComment()}</div>
 				
				
				
 		
				

				
			</div>
			
			
		</c:forEach>
		
		
		

	</div>
	 
		 
	
	
	<form action="./rateMovie" method ="get">

<div >

<input name="my_input" value="" id="rating_simple2" type="text" style="width:15px;border:0px;"/><br>
<textarea rows="4" cols="50" name = "comment" placeholder="Leave your comment here..."></textarea>
<br></br>
<input type="hidden" value="${aMovie.getMovieId()}" name="movieId" />

<a href="./review?movieId=${aMovie.getMovieId()}">
<input type = "submit" value="Rate" class="btn btn-primary btn-sm"/>
</a>


</div>


</form>

<script language="javascript" type="text/javascript">
            function test(value){
                alert("This rating's value is "+value);
            }
            $(function() {
            	$("#rating_simple2").webwidget_rating_simple({
                    rating_star_length: '10',
                    rating_initial_value: 5,
                    rating_function_name: '',//this is function name for click
                    directory: '${pageContext.request.contextPath}/resources/j-plugin/'
                });

            });
            </script>
            </div>
            </section>
	
	
	
	
	
	<c:import url="./footer.jsp" />
</body>
</html>