<%@ page import="model.NewsDetail" %>
<%@ page import="service.NewsDetailService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>

<title>G15 | Tin tức</title>

</head>
<body>
	<!-- header -->


	<%@ include file="header.jsp"%>

	<main id="main">
		<% List<NewsDetail> a= NewsDetailService.getData();
			for(NewsDetail u:a){%>
		<div class="container">
			<div class="main__header">

				<div class="breadcrumbs">
					<a href="index.jsp"><%= u.getTitle1()%></a> <span class="div">/</span> <a
						href="tin-tuc.jsp"><%= u.getTitle2()%></a> <span class="div">/</span> <strong>
					<%= u.getContent()%></strong>
				</div>
				<h1 class="title"><%= u.getContent()%></h1>
			</div>
			<div class="row justify-content-center">
				<div class="col col-lg-8">
					<p class="text-center">
<%--						<img src="images/phoi-do-voi-chan-vay-but-chi-yodyvn.jpg" alt="" width="100%">--%>
	              <img src='\images\<c:out value="<%=u.getImage()%>"/>' width="710" alt="<c:out value="<%=u.getImage() %>"/>">

					</p>
					<p><%= u.getNd1()%>
						 <br>
						<%= u.getNd2()%> <br>
						<%= u.getNd3()%> <br>
						<%= u.getNd4()%> <br>
						<%= u.getNd5()%>
					</p>
				</div>
			</div>
		</div>
		<%}%>
	</main>

	<!-- footer -->
	<%@ include file="footer.jsp"%>

	<!-- js -->
</body>
</html>