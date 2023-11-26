<%@ page import="model.AboutUs" %>
<%@ page import="service.AboutUsService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>G15 | Về chúng tôi</title>

	<link rel="stylesheet" href="/themes/css1/about.css">


</head>
<body>
	<!-- header -->


	<%@ include file="header.jsp"%>


	<main id="main">
		<div class="container-fluid">
			<div class="d-flex justify-content-center">
				<% List<AboutUs> a= AboutUsService.getData();
					for(AboutUs u:a){%>
				<div class="col col-md-8 text-center">


					<h1 class="text-center"><%= u.getTitle()%></h1>
					<img src='\images\img_about\<c:out value="<%=u.getImage1() %>"/>' width="300" alt="<c:out value="<%=u.getImage1() %>"/>"> <br>
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">

	                     <img src='\images\img_about\<c:out value="<%=u.getImage2() %>"/>'  alt="<c:out value="<%=u.getImage2() %>"/>">

							</div>

<%--							<div class="item">--%>


<%--	                       <img src='\images\img_about\<c:out value="<%=u.getImage3() %>"/>'  alt="<c:out value="<%=u.getImage3() %>"/>">--%>

<%--							</div>--%>
						</div>

						<!-- Left and right controls -->
<%--						<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">--%>
<%--							<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>--%>
<%--							<span class="sr-only">Previous</span>--%>
<%--						</a>--%>
<%--						<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">--%>
<%--							<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>--%>
<%--							<span class="sr-only">Next</span>--%>
<%--						</a>--%>
					</div>

					<div class="container text-center">
						<h3><%= u.getContent1()%></h3><br>
						<div class="row">
<%--							<div class="col-sm-4">--%>


<%--	                          <img src='\images\img_about\<c:out value="<%=u.getImage4() %>"/>' class="img-responsive"  alt="<c:out value="<%=u.getImage4() %>"/>">--%>
<%--							</div>--%>
<%--							<div class="col-sm-4">--%>

<%--	                <img src='\images\img_about\<c:out value="<%=u.getImage5() %>"/>' class="img-responsive"  alt="<c:out value="<%=u.getImage5() %>"/>">--%>
<%--							</div>--%>
<%--							<div class="col-sm-4">--%>
<%--&lt;%&ndash;								<img src="<%= u.getImage6()%>" class="img-responsive" style="width:100%" alt="Image">&ndash;%&gt;--%>
<%--&lt;%&ndash;								<img src='images\img_about\<c:out value="<%=u.getImage6() %>"/>out value="<%=u.getImage6() %>"/>' class="img-responsive" alt="<c:out value="<%=u.getImage6() %>"/>">&ndash;%&gt;--%>
<%--	                           <img src='\images\img_about\<c:out value="<%=u.getImage6() %>"/>' class="img-responsive"  alt="<c:out value="<%=u.getImage6()%>"/>">--%>
<%--							</div>--%>

							<div class="well">
								<p><%= u.getContent2()%>
								</p>
							</div>
						</div>
					</div>
				</div>
				<%}%>
			</div>
		</div>
	</main>
	<!-- footer -->
	<%@ include file="footer.jsp"%>

	<!-- js -->
</body>
</html>