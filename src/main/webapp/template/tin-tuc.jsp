<%@ page import="model.News" %>
<%@ page import="service.NewsService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>G15 | Tin tức</title>

</head>
<body>
	<!-- header -->

	<%@ include file="header.jsp"%>

	<main id="discover_you_page">
		<div class="container">
			<section id="section_news">
				<div class="container-fluid">
					<% List<News> a= NewsService.getData();
						for(News u:a){%>
					<div class="hip-grid" id="blogs" style="display: flex;">
						<div class="card hip-item m-3">
							<a href="tin-tuc-chi-tiet.jsp">
<%--								<img--%>
<%--								src="/images/phoi-do-voi-chan-vay-but-chi-yodyvn.jpg"--%>
<%--								class="card-img-top" alt="...">--%>
	<img src='\images\<c:out value="<%=u.getImage1()%>"/>' class="card-img-top" alt="<c:out value="<%=u.getImage1() %>"/>">
								<div class="card-body">
									<h4 class="card-title"><%=u.getTitle1()%></h4>
									<p href="#" class="card-text">
										<%=u.getContent1()%> <i><%=u.getDocthem()%></i>
									</p>
								</div>
							</a>

						</div>
						<div class="card hip-item m-3">
							<a href="tin-tuc-chi-tiet.jsp">
<%--								<img src="/images/post-1.png"--%>
<%--								class="card-img-top" alt="...">--%>
	<img src='\images\<c:out value="<%=u.getImage2()%>"/>' class="card-img-top"  alt="<c:out value="<%=u.getImage2() %>"/>">
								<div class="card-body">
									<h4 class="card-title"><%=u.getTitle2()%></h4>
									<p href="#" class="card-text">
										<%=u.getContent2()%> <i><%=u.getDocthem()%></i>
									</p>
								</div>
							</a>

						</div>
						<div class="card hip-item m-3">
							<a href="tin-tuc-chi-tiet.jsp">
<%--								<img src="/images/post-2.jpg"--%>
<%--								class="card-img-top" alt="...">--%>
	<img src='\images\<c:out value="<%=u.getImage3()%>"/>' class="card-img-top" alt="<c:out value="<%=u.getImage3() %>"/>">
								<div class="card-body">
									<h4 class="card-title"><%=u.getTitle3()%></h4>
									<p href="#" class="card-text">
										<%=u.getContent1()%> <i><%=u.getDocthem()%></i>
									</p>
								</div>
							</a>

						</div>
						<div class="card hip-item m-3">
							<a href="tin-tuc-chi-tiet.jsp">
<%--								<img src="/images/post-3.png"--%>
<%--								class="card-img-top" alt="...">--%>
	<img src='\images\<c:out value="<%=u.getImage4()%>"/>' class="card-img-top" alt="<c:out value="<%=u.getImage4() %>"/>">
								<div class="card-body">
									<h4 class="card-title"><%=u.getTitle4()%></h4>
									<p href="#" class="card-text">
										<%=u.getContent2()%> <i><%=u.getDocthem()%></i>
									</p>
								</div>
							</a>

						</div>
					</div>
					<%}%>

				</div>
			</section>
		</div>
	</main>

	<!-- footer -->
	<%@ include file="footer.jsp"%>

	<!-- JS -->

	<script>
		$("#blogs").hip({
			itemsPerPage : 6,
			itemsPerRow : 3,
			itemGaps : '0',
			paginationPos : 'left'
		});
	</script>
</body>
</html>