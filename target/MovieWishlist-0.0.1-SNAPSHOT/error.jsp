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
<title>Wishlist - Error-Page</title>
 <c:import url="./includes.jsp" />
</head>
<body>
	 <c:import url="./header.jsp" />
	<section class="moduler wrapper_404">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="text-center">
					<h1 class="wow fadeInUp animated cd-headline slide"
						data-wow-delay=".4s">404</h1>
					<h2 class="wow fadeInUp animated" data-wow-delay=".6s">Opps!
						You have some problems</h2>
					<p class="wow fadeInUp animated" data-wow-delay=".9s">The page
						you are looking for was moved, removed, renamed or might never
						existed.</p>
					<a href="index.jsp"
						class="btn btn-dafault btn-home wow fadeInUp animated"
						data-wow-delay="1.1s">Go Home</a>

				</div>
			</div>
		</div>
	</div>
	</section>

	<!-- 
        ================================================== 
            Call To Action Section Start
        ================================================== -->
	<section id="call-to-action">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="block">
					<h2 class="title wow fadeInDown" data-wow-delay=".3s"
						data-wow-duration="300ms">
						SO WHAT YOU THINK ?
						</h1>
						<p class="wow fadeInDown" data-wow-delay=".5s"
							data-wow-duration="300ms">
							Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nobis,<br>possimus
							commodi, fugiat magnam temporibus vero magni recusandae? Dolore,
							maxime praesentium.
						</p>
						<a href="#" class="btn btn-default btn-contact wow fadeInDown"
							data-wow-delay=".7s" data-wow-duration="300ms">Contact With
							Me</a>
				</div>
			</div>

		</div>
	</div>
	</section>


	<!-- 
        ================================================== 
            Footer Section Start
        ================================================== -->
	<footer id="footer">
	<div class="container">
		<div class="col-md-8">
			<p class="copyright">
				Copyright: <span>2015</span> . Design and Developed by <a
					href="http://www.Themefisher.com">Themefisher</a>
			</p>
		</div>
		<div class="col-md-4">
			<!-- Social Media -->
			<ul class="social">
				<li><a href="#" class="Facebook"> <i
						class="ion-social-facebook"></i>
				</a></li>
				<li><a href="#" class="Twitter"> <i
						class="ion-social-twitter"></i>
				</a></li>
				<li><a href="#" class="Linkedin"> <i
						class="ion-social-linkedin"></i>
				</a></li>
				<li><a href="#" class="Google Plus"> <i
						class="ion-social-googleplus"></i>
				</a></li>

			</ul>
		</div>
	</div>
	</footer>
	<!-- /#footer -->

</body>
</html>