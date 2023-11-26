<%@page import="model.Order"%>
<%@page import="model.Invoice"%>
<%@page import="response.OrderOrderdetailResponse"%>
<%@page import="model.OrderDetail"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="helper.Contants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="response.InvoiceResponse"%>
<%@page import="response.OrderOrderdetailResponse"%>
<%@page import="java.util.List"%>
<%@ page import="service.OrderService" %>
<%@ page import="service.UserService" %>
<%@ page import="service.OrderDetailService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en" class="">

<head>
<title>Đơn may sẵn - Admin G15</title>

</head>

<body>

	<!-- header -->
	<%@ include file="/quan-tri-admin/header-admin.jsp"%>

	<section class="is-title-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<ul>
				<li>Admin</li>
				<li>Đơn đặt may</li>
			</ul>

		</div>
	</section>





	<!-- Noi dung -->
	<section class="is-hero-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<h1 class="title">Bảng đáp ứng</h1>
			<!-- Nut Them -->
			<!-- <a href="forms.jsp"  class="button blue">
          <span class="icon"><i class="mdi mdi-credit-card-plus"></i></span>
          <span>Thêm mới</span>
        </a> -->
			<!--  -->
			<!-- Nut Them -->

			<!--  -->
		</div>
	</section>




	<section class="section main-section">
		<div class="navbar-item">
			<div class="control">
				<input placeholder="Tìm kiếm..." class="input" />
			</div>
		</div>


		<!--  -->


		<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
			<li class="nav-item" role="presentation">
				<button class="nav-link active" id="pills-home-tab"
					data-bs-toggle="pill" data-bs-target="#pills-home" type="button"
					role="tab" aria-controls="pills-home" aria-selected="true">Tất
					cả</button>
			</li>

			<li class="nav-item" role="presentation">
				<button class="nav-link" id="pills-profile-tab"
					data-bs-toggle="pill" data-bs-target="#pills-profile" type="button"
					role="tab" aria-controls="pills-profile" aria-selected="false">Chờ
					xác nhận</button>
			</li>
			<li class="nav-item" role="presentation">
				<button class="nav-link" id="pills-profile1-tab"
					data-bs-toggle="pill" data-bs-target="#pills-profile" type="button"
					role="tab" aria-controls="pills-profile" aria-selected="false">Xác
					nhận</button>
			</li>
			<li class="nav-item" role="presentation">
				<button class="nav-link" id="pills-contact-tab"
					data-bs-toggle="pill" data-bs-target="#pills-contact" type="button"
					role="tab" aria-controls="pills-contact" aria-selected="false">Đang
					giao</button>
			</li>
			<li class="nav-item" role="presentation">
				<button class="nav-link" id="pills-contact1-tab"
					data-bs-toggle="pill" data-bs-target="#pills-contact" type="button"
					role="tab" aria-controls="pills-contact" aria-selected="false">Hoàn
					tất</button>
			</li>
			<li class="nav-item" role="presentation">
				<button class="nav-link" id="pills-disabled-tab"
					data-bs-toggle="pill" data-bs-target="#pills-disabled"
					type="button" role="tab" aria-controls="pills-disabled"
					aria-selected="false">Đơn hủy</button>
			</li>

		</ul>
		<div class="tab-content" id="pills-tabContent">
			<div class="tab-pane fade show active" id="pills-home"
				role="tabpanel" aria-labelledby="pills-home-tab" tabindex="0">

				<!-- bảng1 -->
				<div class="card has-table">
					<header class="card-header">
						<p class="card-header-title">
							<span class="icon"><i class="mdi mdi-table-plus"></i></span> Sản
							phẩm
						</p>
						<a href="#" class="card-header-icon"> <span class="icon"><i
								class="mdi mdi-reload"></i></span>
						</a>
					</header>

					<div class="card-content">
						<table>
							<thead>
								<tr>
									<th>Id</th>
									<th>idorder</th>
									<th>iduser</th>
									<th>idaddress</th>
									<th>subtotal</th>
									<th>itemdiscount</th>
									<th>shipping</th>
									<th>grandtotal</th>
									

								</tr>
							</thead>
							<%
							if (request.getAttribute("showOrderdetailTemp") != null) {
								int idOrder = (int)request.getAttribute("idOrder");
								List<Order> orderDetail = (ArrayList<Order>) request.getAttribute("showOrderdetailTemp");

								for (int i = 0; i < orderDetail.size(); i++) {
							%>
							
							<tbody>

								<tr>
								
									
								<td data-title="ID"><%=i + 1%></td>
								<td data-title="idorder"><%=idOrder%></td>
								<td data-title="iduser"><%=orderDetail.get(i).getIduser()%></td>
								<td data-title="idaddress"><%=orderDetail.get(i).getIdaddress()%></td>
								<td data-title="subtotal"><%=orderDetail.get(i).getSubtotal()%></td>
								<td data-title="itemdiscount"><%=orderDetail.get(i).getItemdiscount()%></td>
								<td data-title="shipping"><%=orderDetail.get(i).getShipping()%></td>
								<td data-title="grandtotal"><%=orderDetail.get(i).getGrandtotal()%></td>
								
						
								</tr>
							</tbody>
							<li class="nav-item" role="presentation">
								<a href="chi-tiet-don-hang/exportFilePDFOrder?id=<%=i+1%>">
									<button class="nav-link"
											data-bs-toggle="pill" data-bs-target="#pills-disabled"
											type="button" role="tab" aria-controls="pills-disabled"
											aria-selected="false">Xuất ra PDF</button>

								</a>
							</li>
							<%
							}
							}
							%>
						</table>






					</div>





				</div>

			</div>
			<div class="tab-pane fade" id="pills-profile" role="tabpanel"
				aria-labelledby="pills-profile-tab" tabindex="0"></div>
			<div class="tab-pane fade" id="pills-contact" role="tabpanel"
				aria-labelledby="pills-contact-tab" tabindex="0"></div>
			<div class="tab-pane fade" id="pills-disabled" role="tabpanel"
				aria-labelledby="pills-disabled-tab" tabindex="0"></div>
			<div class="tab-pane fade" id="pills-disabled" role="tabpanel"
				aria-labelledby="pills-disabled1-tab" tabindex="0"></div>
		</div>
		<!--  -->




		<div class="card empty">
			<div class="card-content">
				<div>
					<span class="icon large"><i
						class="mdi mdi-emoticon-sad mdi-48px"></i></span>
				</div>
				<p>Nothing's here…</p>
			</div>
		</div>
	</section>
</body>

</html>