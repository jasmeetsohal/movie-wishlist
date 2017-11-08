<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header id="top-bar" class="navbar-fixed-top animated-header">
	<div class="container">
		<div class="navbar-header">
			<!-- responsive nav button -->
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- /responsive nav button -->

			<!-- logo -->
			<div class="navbar-brand">
				<a href="index.jsp"> <img
					src="${pageContext.request.contextPath}/resources/images/logo.jpg"
					alt="logo">
				</a>
			</div>
			<!-- /logo -->
		</div>
		<!-- main menu -->
		<nav class="collapse navbar-collapse navbar-right" role="navigation">
			<div class="main-menu">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="search.jsp">Search</a></li>

					<!-- 				<li class="dropdown"><a href="#" class="dropdown-toggle" -->
					<!-- 					data-toggle="dropdown">Blog <span class="caret"></span></a> -->
					<!-- 					<div class="dropdown-menu"> -->
					<!-- 						<ul> -->
					<!-- 							<li><a href="blog-fullwidth.html">Blog Full</a></li> -->
					<!-- 							<li><a href="blog-left-sidebar.html">Blog Left sidebar</a></li> -->
					<!-- 							<li><a href="blog-right-sidebar.html">Blog Right sidebar</a></li> -->
					<!-- 						</ul> -->
					<!-- 					</div></li> -->
					<li><a href="contact.jsp">Contact</a></li>
					
						


        
					<c:choose>
						<c:when test="${!empty user}">
						
						 <li class="dropdown"><a href="#"
						class="glyphicon glyphicon-flash" 
						class="dropdown-toggle" data-toggle="dropdown"><span
							class="caret"></span></a>
						<div class="dropdown-menu">
						
							<ul>
							<c:forEach var="notify" items="${notify}">
								<li><a href="./friendProfile?uid=${notify.getuId()}" style=
								"font-size:10px;border-color:white;">${notify.getuName()} now follow you </a>
								
                            </c:forEach>
							</ul>
						</div></li>
						
						
						
						
						
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> ${user.getuName() } <span
									class="caret"></span></a>
								<div class="dropdown-menu">
									<ul>
										<li><a href="./myProfile?uid=${user.getuId()}" >Profile</a>
										<li><form action="./MyMovie" method= "post"><input
								type="submit" value="Wishlist" class="btn btn-primary btn-sm" /></form> </li>
										<li><a href="./Logout" class="glyphicon glyphicon-off"></a></li>

									</ul>
								</div></li>
						</c:when>

						<c:otherwise>

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> user <span class="caret"></span></a>
								<div class="dropdown-menu">
									<ul>

										<li><a href="sign-up-in.jsp">Sign up </a></li>

									</ul>
								</div></li>

						</c:otherwise>
					</c:choose>


				</ul>

			</div>
		</nav>
		<!-- /main nav -->
	</div>
</header>