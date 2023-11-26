<%@page import="model.User"%>
<%@ page import="model.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>

<title>G15 | Đặt may</title>

<link rel="stylesheet" href="../themes/css/style_section.css">

</head>

<body>
	<!-- header -->
	<%@ include file="header.jsp"%>


	<main id="main">
		<div class="container-lg">
			<div class="row  justify-content-center">
				<strong class="col col-lg-6 text-center mb-3"> <em>***Gửi
						đến các nàng thân yêu! Để nhận được sản phẩm vừa với cơ thể, shop
						mong bạn hãy dành chút thời gian để đo đạt cơ thể và <u>nhập
							chính xác các thông số cơ thể</u>. ***
				</em>
				</strong>
			</div>
			<section id="content_prod" class="d-flex">
				<%
				if (request.getAttribute("cartdatmay") != null) {
					ProductCartResponse item = (ProductCartResponse) request.getAttribute("cartdatmay");
				%>
				<article class="col col-lg-3 me-5">
					
					<img src='/images\products\<c:out value="<%=item.getProduct().getCodecate() %>"/>/<c:out value="<%=item.getProduct().getImage() %>"/>'
                           class="card-img" alt="<c:out value="<%=item.getProduct().getImage() %>"/>">
					<!-- ma san pham, trang thai va gia -->

					<div class="col-md-12 p-0">
						Mã sản phẩm: <strong id="get_ID_prod"><%=item.getProduct().getSku()%>
						</strong>

						<p class="priceP">
							Giá sản phẩm: <span class="me-3"><del>
							<fmt:formatNumber type="number" maxFractionDigits="3" value="<%=item.getProduct().getPrice()%>"/>
									</del>VND</span>
									 <strong class="pricesale">
									 <fmt:formatNumber type="number" maxFractionDigits="3" value="<%=item.getProduct().getDiscount()%>"/>
								VND</strong>
						</p>
					</div>

				</article>


				<article class="col col-lg-9">
					<form class="needs-validation" action="/cart/add-to-cart"
						method="POST">
						<input name="ismeasure" type="hidden" value="1"> <input
							name="id" type="hidden"
							value="<%=item.getProduct().getIdproduct()%>" />
						<div class="row">
							<!-- Thoong tin khachs hang -->

							<!-- Thông tin đặt may -->
							<div class="col col-lg-12">
								<h2 class="mb-3">Thông tin đặt may</h2>
								<div class="row g-3">


									<div class="col-12">
										<label for="height" class="form-label">Chiều cao</label> <input
											type="text" class="form-control" name="height"
											placeholder="160" required
											value="<%=item.getDetail().getHeight()%>">
										<div class="invalid-feedback">Vui lòng nhập số chiều cao
											đúng nhât.</div>
									</div>
									<div class="col-12">
										<label for="weight" class="form-label">Cân nặng</label> <input
											type="text" class="form-control" name="weight"
											placeholder="45" required
											value="<%=item.getDetail().getWeight()%>">
										<div class="invalid-feedback">Vui lòng nhập số cân nặng
											đúng nhât.</div>
									</div>

									<div class="col-4">
										<label for="round1" class="form-label">Số đo vòng 1</label> <input
											type="text" class="form-control" name="round1"
											placeholder="90" required
											value="<%=item.getDetail().getRound1()%>">
										<div class="invalid-feedback">Vui lòng nhập số vòng 1
											đúng nhât.</div>
									</div>
									<div class="col-4">
										<label for="round2" class="form-label">Số đo vòng 2</label> <input
											type="text" class="form-control" name="round2"
											placeholder="60" required
											value="<%=item.getDetail().getRound2()%>">
										<div class="invalid-feedback">Vui lòng nhập số vòng 2
											đúng nhât.</div>
									</div>
									<div class="col-4">
										<label for="round3" class="form-label">Số đo vòng 3</label> <input
											type="text" class="form-control" name="round3"
											placeholder="90" required
											value="<%=item.getDetail().getRound3()%>">
										<div class="invalid-feedback">Vui lòng nhập số vòng 3
											đúng nhât.</div>
									</div>

									<div class="col-4">
										<label for="get_quantity_order" class="form-label">SỐ
											LƯỢNG</label> <input type="number" name="get_quantity_order"
											id="get_quantity_order" class="form-control"
											value="<%=item.getQuantity()%>" min="1" />
									</div>

									<div class="col-12">
										<label for="validationNote" class="form-label">Ghi chú</label>
										<input type="text" class="form-control"
											class="form-control-note" name="validationNote"
											placeholder="Nhập nội dung bạn mong muốn ở sản phẩm"
											value="Giao giờ hành chính">
										<div class="invalid-feedback">Vui lòng nhập thông tin
											khách hàng muốn về sản phẩm.</div>
									</div>


								</div>
							</div>
							<div class="col col-lg-12">
								<hr class="my-4">
								<button class="w-100 btn btn-dark btn-lg" type="submit">Đặt
									may</button>
							</div>


						</div>
					</form>
				</article>
				<%
				}
				%>
			</section>
		</div>
	</main>
	<!-- footer -->
	<%@ include file="footer.jsp"%>

	<!-- js -->



</body>

</html>