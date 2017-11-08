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
<link rel="icon" type="image/png" href="images/favicon.png">
<title>Timer Agency Template</title>
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
			
			<c:if test="${users.size()<1}">
			<h2 >No result found ..</h2>
			</c:if>
			<h3 align="center">Wishlist users</h3>
			<c:forEach var="user" items="${users}">
               
				<div class="row">
					<div class="col-sm-3">
						<a href="./friendProfile?uid=${user.getuId()}"><div class="well">
							<p>${user.getuName()}</p>
							
							<img src="${pageContext.request.contextPath}/resources/images/default-img.png" class="img-circle" height="55" width="55"
								alt="Avatar" >
								<p>${user.getuEmail()}</p>
						</div>
					  </a>
						</div>
					</div>
					
				</div>
                     
				
			</c:forEach>


		</div>
		</div>
	</section>
	
	<c:import url="./footer.jsp" />


</body>
</html>