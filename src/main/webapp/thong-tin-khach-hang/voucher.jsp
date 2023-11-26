<%@ page import="model.Voucher" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<html lang="en">
<head>
<title>G15 | Khách hàng</title>
<link rel="stylesheet" href="../themes/css1/thong-tin-khach-hang.css">
<link rel="stylesheet" href="../themes/css1/dia-chi.css">
<link rel="stylesheet" href="../themes/css1/them-dia-chi-moi.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/template/header.jsp"%>
	<main class="content" id="main">
		<section>
			<div class="container-lg">
				<div class="row justify-content-center">
					<%@ include file="header-left.jsp"%>
					<div class="col-md-8 right">
						<!-- Thông tin tài khoản -->
						<h1 class="text-center mb-3">My Voucher</h1>
						<div class="row">
							<%
								List<Voucher> list = (List<Voucher>) request.getAttribute("listMyVoucher");
								for (Voucher v : list) {
							%>
							<div class="col-md-6">
								<div class="card mb-3" style="max-width: 540px;">
									<div class="row g-0">
										<div class="col-md-12">
											<div class="card-body">
												<h3 class="card-text"><%=v.getNameVoucher()%></h3>
												<p class="card-text">Từ: <%=v.getStartAt()%> HSD: <%=v.getFinishAt()%></p>
												</small>
												</p>
											</div>
										</div>
									</div>
								</div>


							</div>
							<%
								}
							%>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
	<!-- footer -->
	<%@ include file="/template/footer.jsp"%>
	<!-- js -->
</body>
</html>