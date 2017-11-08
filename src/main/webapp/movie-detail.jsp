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
					<h2>detail</h2>
					<ol class="breadcrumb">
						<li><a href="index.jsp"> <i class="ion-ios-home"></i>
								Home
						</a></li>
						<li class="active">Detail</li>
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
			<div class="col-md-2"></div>
			<div id="d2" class="col-md-8">
				<div id="mdetail">
					<h3 align="center">MOVIE SEARCH RESULT</h3>
					<hr>
					<c:set var="movie" value="${movieDetail}" />
					<div id="md1">
						<table>
							<tr>
								<td valign="top"><span class="tt1"><b>Title : </b></span><span
									class="tt2">${movie.getTitle()}</span></td>
								<td valign="top"><span class="tt2">&nbsp;&nbsp;<b>${movie.getYear()}</b>&nbsp;&nbsp;
								</span></td>
								<td valign="top"><span class="tt2"><b>${movie.getType()}</b></span></td>
							</tr>
						</table>
					</div>
					<div id="imgD">
						<table>
							<tr>
								<td><img src="${movie.getPoster()}"
									alt="No-Image Available" /></td>
							</tr>
							<tr>
								<td align="center"><form method="post" action="./wishlist?movieId=${movie.getImdbID()}"><input
								type="submit" value="Add to wishlist" class="btn btn-primary btn-sm"/></form></td>
							</tr>
						</table>
					</div>
					<div id="md2">
						<table>
							<tr>
								<td class="td1" valign="top"><span><b>Language :
									</b></span></td>
								<td class="td2" valign="top"><span>${movie.getLanguage()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>Genre : </b></span></td>
								<td class="td2" valign="top"><span>${movie.getGenre()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>Rated : </b></span></td>
								<td class="td2" valign="top"><span>${movie.getRated()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>imdbRating : </b></span></td>
								<td class="td2" valign="top"><span>${movie.getImdbRating()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>imdbVotes : </b></span></td>
								<td class="td2" valign="top"><span>${movie.getImdbVotes()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>Runtime :
									</b></span></td>
								<td class="td2" valign="top"><span>${movie.getRuntime()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>Released :
									</b></span></td>
								<td class="td2" valign="top"><span>${movie.getReleased()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>Actors : </b></span></td>
								<td class="td2" valign="top"><span>${movie.getActors()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>Director :
									</b></span></td>
								<td class="td2" valign="top"><span>${movie.getDirector()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>Writer : </b></span></td>
								<td class="td2" valign="top"><span>${movie.getWriter()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>Country :
									</b></span></td>
								<td class="td2" valign="top"><span>${movie.getCountry()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>Plot : </b></span></td>
								<td class="td2" valign="top"><span>${movie.getPlot()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>imdbID : </b></span></td>
								<td class="td2" valign="top"><span>${movie.getImdbID()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>Awards : </b></span></td>
								<td class="td2" valign="top"><span>${movie.getAwards()}</span></td>
							</tr>
							<tr>
								<td class="td1" valign="top"><span><b>Metascore : </b></span></td>
								<td class="td2" valign="top"><span>${movie.getMetascore()}</span></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>

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

    $(function () {

        var obj = $('#pagination').twbsPagination({

            totalPages:${total},
            visiblePages: 5,
            onPageClick: function (event, page) {
                console.info(page);
        // $('.col-sm-4').text('Page ' + page);
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