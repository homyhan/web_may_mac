<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="helper.Contants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="response.InvoiceResponse"%>
<%@page import="java.util.List"%>
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
									<th class="checkbox-cell"><label class="checkbox">
											<input type="checkbox"> <span class="check"></span>
									</label></th>

									<th>Id</th>
									<th>Mã đơn hàng</th>
									<th>Mã order</th>
									<th>Tổng tiền</th>
									<th>Phương thức thanh toán</th>
									<th>Ngày đặt</th>
									<th>Trạng thái</th>



									<th>Thao tác</th>
									<th></th>
								</tr>
							</thead>
							<tbody>

								<%
								if (request.getAttribute("invoiceAdminList") != null) {
									List<InvoiceResponse> result = (ArrayList<InvoiceResponse>) request.getAttribute("invoiceAdminList");
									for (int i = 0; i < result.size(); i++) {
								%>
								<tr>
									<td class="checkbox-cell"><label class="checkbox">
											<input type="checkbox"> <span class="check"></span>
									</label></td>
									<td data-title="ID"><%=i + 1%></td>
									<td data-title="MADONHANG"><%=result.get(i).getInvoice().getIdinvoice()%></td>
									<td data-title="MAORDER"><%=result.get(i).getInvoice().getIdorder()%></td>
									<td data-title="TONGGIA"><fmt:formatNumber type="number" maxFractionDigits="3"	value="<%=result.get(i).getOrder().getGrandtotal()%>" /> VND</td>
									<td data-title="THANHTOAN"><%=result.get(i).getInvoice().getMode() == Contants.INVOICE_MODE_TRUCTIEP ? "Thanh toán trực tiếp"
		: "Thanh toán qua thẻ"%></td>
									<td data-title="NGAYDAT"><%=result.get(i).getInvoice().getCreateAt()%></td>
									<td data-title="TRANGTHAI">
										<button class="btn btn-dark" disabled=""><%=result.get(i).getStatusValue()%></button>
									</td>
									<td class="actions-cell">
										<div class="buttons right nowrap">

											<a
												href="/admin/chi-tiet-don-hang?idOrder=<%=result.get(i).getInvoice().getIdorder()%>">
												<button class="button small green --jb-modal" type="button">
													<span class="icon"><i class="mdi mdi-eye"> </i></span>
												</button>
											</a>


											<form id="select_info_prod" action="/admin/remove-don-hang"
												method="POST">

												<input name="id" type="hidden"
													value="<%=result.get(i).getInvoice().getIdinvoice()%>" />

												<button class="button small red --jb-modal"
													data-target="sample-modal" type="submit">
													<span class="icon"><i class="mdi mdi-trash-can"
														title="Xóa"></i></span>
												</button>
											</form>

											<a
													href="/admin/edit-don-hang?idOrder=<%=result.get(i).getInvoice().getIdorder()%>">
												<button class="button small green --jb-modal" type="button">
													<span class="icon"><span class="mdi mdi-pencil"></span></span>
												</button>
											</a>


											<form action="/admin/don-hang/updade-status" method="POST">
												<div class="actions-status">

													<input name="idinvoice" type="hidden"
														value="<%=result.get(i).getInvoice().getIdinvoice()%>" />

													<input name="idOrder" type="hidden"
														value="<%=result.get(i).getOrder().getIdorder()%>" /> <select
														class="form-select" name="invoice_status"
														aria-label="Default select example">
														<%
														HashMap<Integer, String> eqArray = new HashMap<Integer, String>();
														eqArray.put(Contants.INVOIE_STATUS_APPROVE, "Đã xác nhận");
														eqArray.put(Contants.INVOIE_STATUS_CANCEL, "Đã Hủy");
														eqArray.put(Contants.INVOIE_STATUS_DELIVERY, "Đang giao");
														eqArray.put(Contants.INVOIE_STATUS_SUCCESS, "Hoàn thành");
														eqArray.put(Contants.INVOIE_STATUS_WAITING_APPROVE, "Chờ xác nhận");
														for (Map.Entry<Integer, String> entry : eqArray.entrySet()) {
														%>
														<option value="<%=entry.getKey()%>"
															<%=(entry.getKey().equals(result.get(i).getInvoice().getStatus())) ? "selected" : ""%>>
															<%=entry.getValue()%>
														</option>
														<%
														}
														%>
													</select>
													<button class="button small green --jb-modal"
														data-target="sample-modal" type="submit">Cập nhật
													</button>
												</div>
											</form>
										</div>
									</td>
								</tr>
								<%
								}
								}
								%>
							</tbody>
						</table>
						<div class="table-pagination">
							<div class="flex items-center justify-between">
								<div class="buttons">
									<button type="button" class="button active">1</button>
									<button type="button" class="button">2</button>
									<button type="button" class="button">3</button>
								</div>
								<small>Page 1 of 3</small>
							</div>
						</div>
					</div>
				</div>

			</div>
			<div class="tab-pane fade" id="pills-profile" role="tabpanel"
				aria-labelledby="pills-profile-tab" tabindex="0"></div>
			<div class="tab-pane fade" id="pills-contact" role="tabpanel"
				aria-labelledby="pills-contact-tab" tabindex="0"></div>
			<div class="tab-pane fade" id="pills-disabled" role="tabpanel"
				aria-labelledby="pills-disabled-tab" tabindex="0"></div>
			<div class="tab-pane fade" id="pills-disabled1" role="tabpanel"
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