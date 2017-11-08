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
</head>
<body>
	<c:import url="./header.jsp" />

	<!--
        ==================================================
        Slider Section Start
        ================================================== -->
	<section id="hero-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12 text-center">
				<div class="block wow fadeInUp" data-wow-delay=".9s">

					<!-- Slider -->
					<section class="cd-intro">
					<h1 class="wow fadeInUp animated cd-headline slide"
						data-wow-delay=".4s">
						<span>WELCOME TO WISHLIST, YOU CAN</span><br> <span
							class="cd-words-wrapper"> <b class="is-visible">SEARCH
								A MOVIE</b> <b>ADD MOVIE TO WISHLIST</b> <b>SHARE YOUR WISHLIST</b>
						</span>
					</h1>
					</section>
					<!-- cd-intro -->
					<!-- /.slider -->
					<h2 class="wow fadeInUp animated" data-wow-delay=".6s">
						Now Searching becomes too easy, all you need to do is just search
						any movie <br> by title or id and add it to your wishlist.
					</h2>
					<a
						class="btn-lines dark light wow fadeInUp animated smooth-scroll btn btn-default btn-green"
						data-wow-delay=".3s" href="search.jsp" data-section="#works">START
						EXPLORING</a>
						

				</div>
			</div>
		</div>
	</div>
	</section>
	<!--/#main-slider-->
	<!--
            ==================================================
            Slider Section Start
            ================================================== -->
	<section id="about">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-sm-6">
				<div class="block wow fadeInLeft" data-wow-delay=".3s"
					data-wow-duration="500ms">
					<h2>ABOUT ME</h2>
					<p>Hello, I'm a Java SEE back end developer from Ludhiana.I gonna hold a master de
					gree of Information Technology from the Panjab University.It was great experience 
					to working on OMDB API project that was intrinsic knowledge used in project.	
					</p>
					
				</div>

			</div>
			<div class="col-md-6 col-sm-6">
				<div class="block wow fadeInRight" data-wow-delay=".3s"
					data-wow-duration="500ms">
					<img
						src="${pageContext.request.contextPath}/resources/images/about/about.jpg"
						alt="">
				</div>
			</div>
		</div>
	</div>
	</section>
	<c:import url="./footer.jsp" />

</body>
</html>