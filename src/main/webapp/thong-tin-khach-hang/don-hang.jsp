<%@page import="helper.Contants"%>
<%@page import="response.InvoiceResponse"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="model.User"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>

<title>G15 | Khách hàng</title>
<link rel="stylesheet" href="../themes/css1/thong-tin-khach-hang.css">
<link rel="stylesheet" href="../themes/css1/dia-chi.css">




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

						<!-- đơn hàng -->
						<div class="content">
							<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
								<li class="nav-item" role="presentation">
									<button class="nav-link active " id="pills-profile-tab"
										data-bs-toggle="pill" data-bs-target="#pills-profile"
										type="button" role="tab" aria-controls="pills-profile"
										aria-selected="true">Tất cả</button>
								</li>


								<li class="nav-item" role="presentation">
									<button class="nav-link " id="pills-home-tab"
										data-bs-toggle="pill" data-bs-target="#pills-home"
										type="button" role="tab" aria-controls="pills-home"
										aria-selected="false">Chờ xác nhận</button>
								</li>


								<li class="nav-item" role="presentation">
									<button class="nav-link" id="pills-contact-tab"
										data-bs-toggle="pill" data-bs-target="#pills-contact"
										type="button" role="tab" aria-controls="pills-contact"
										aria-selected="false">Xác nhận</button>
								</li>
								<li class="nav-item" role="presentation">
									<button class="nav-link" id="pills-disabled-tab"
										data-bs-toggle="pill" data-bs-target="#pills-disabled"
										type="button" role="tab" aria-controls="pills-disabled"
										aria-selected="false">Đang giao</button>
								</li>
								<li class="nav-item" role="presentation">
									<button class="nav-link" id="pills-disabled2-tab"
										data-bs-toggle="pill" data-bs-target="#pills-disabled"
										type="button" role="tab" aria-controls="pills-disabled"
										aria-selected="false">Hoàn tất</button>
								</li>

								<li class="nav-item" role="presentation">
									<button class="nav-link" id="pills-favourite-tab"
										data-bs-toggle="pill" data-bs-target="#pills-favourite"
										type="button" role="tab" aria-controls="pills-favourite"
										aria-selected="false">Đã hủy</button>
								</li>


							</ul>
							<hr>
							<div class="tab-content" id="pills-tabContent">
								<!-- Tất cả -->
								<div class="tab-pane fade show active" id="pills-profile"
									role="tabpanel" aria-labelledby="pills-profile-tab"
									tabindex="0">

									<!-- -->
									<table id="table" class="table table-hover table-mc-light-blue">
										<thead>
											<tr>
												<th>Id</th>
												<th>Mã đơn</th>
												<th>Tổng giá</th>
												<th>Phương thức thanh toán</th>
												<th>Ngày đặt hàng</th>
												<th>Trạng thái</th>
											</tr>
										</thead>
										<tbody>
											<%
											if (request.getAttribute("invoiceList") != null) {
												List<InvoiceResponse> result = (ArrayList<InvoiceResponse>) request.getAttribute("invoiceList");
												for (int i = 0; i < result.size(); i++) {
											%>
											<tr>
												<td data-title="ID"><%=i + 1%></td>
												<td data-title="MADONHANG"><%=result.get(i).getInvoice().getIdinvoice()%></td>
												<td data-title="TONGGIA">
												<fmt:formatNumber type="number" maxFractionDigits="3" value="<%=result.get(i).getOrder().getGrandtotal()%>"/>
													VND</td>
												<td data-title="THANHTOAN"><%=result.get(i).getInvoice().getMode() == Contants.INVOICE_MODE_TRUCTIEP ? "Thanh toán trực tiếp"
		: "Thanh toán qua thẻ"%></td>
												<td data-title="NGAYDAT"><%=result.get(i).getInvoice().getCreateAt()%></td>
												<td data-title="TRANGTHAI">
													<button class="btn btn-dark" disabled=""><%=result.get(i).getStatusValue()%></button>
												</td>
											</tr>
											<%
											}
											}
											%>
										</tbody>
									</table>

									<!--  -->
								</div>
								<!-- Chờ xác nhận-->

								<!-- Xác nhận -->

								<!-- Đang giao -->

								<!-- Hoàn tất -->

								<!-- Đã hủy-->

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