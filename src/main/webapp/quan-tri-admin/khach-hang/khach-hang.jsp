<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en" class="">

<head>
<title>Khách hàng - Admin G15</title>

</head>

<body>

	<!-- header -->
	<%@ include file="/quan-tri-admin/header-admin.jsp"%>

	<section class="is-title-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<ul>
				<li>Admin</li>
				<li>Khách hàng</li>
			</ul>

		</div>
	</section>
	<!-- Noi dung -->
	<section class="is-hero-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<h1 class="title">Bảng khách hàng</h1>
			<!-- Nut Them -->
			<a href="/quan-tri-admin/khach-hang/add-customer.jsp"
				class="button blue"> <span class="icon"><i
					class="mdi mdi-account-multiple-plus-outline"></i></span> <span>Thêm
					mới admin</span>
			</a>
			<!--  -->
		</div>
	</section>

	<section class="section main-section">
		<div class="navbar-item">
			<div class="control">
				<input placeholder="Tìm kiếm..." class="input" />
			</div>
		</div>
		<div class="notification blue">
			<div
				class="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0">
				<div>
					<span class="icon"><i class="mdi mdi-buffer"></i></span> <b>Bảng
						khách hàng</b>
				</div>
				<button type="button"
					class="button small textual --jb-notification-dismiss">Bỏ
					qua</button>
			</div>
		</div>
		<div class="card has-table">

			<%
			if (request.getAttribute("message") != null) {
			%>
			<label style="color: red"><%=request.getAttribute("message")%></label>
			<%
			}
			%>
			<%
			if (request.getAttribute("error") != null) {
			%>
			<label style="color: red"><%=request.getAttribute("error")%></label>
			<%
			}
			%>
			<header class="card-header">
				<p class="card-header-title">
					<span class="icon"><i class="mdi mdi-account-multiple"></i></span>
					Khách hàng
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
							<th>Tên đăng nhập</th>
							<th>Họ</th>
							<th>Tên</th>
							<th>Email</th>
							<th>Số điện thoại</th>
							<!-- <th>Địa chỉ giao hàng</th> -->
							<!-- <th>Ẩn/hiện</th> -->
							<th>Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<%
						if (request.getAttribute("userAdminList") != null) {
							List<User> result = (ArrayList<User>) request.getAttribute("userAdminList");
							for (int i = 0; i < result.size(); i++) {
						%>
						<tr>
							<td data-title="ID"><%=i + 1%></td>
							<td data-title="TENDANGNHAP"><%=result.get(i).getUsername()%></td>
							<td data-title="HO"><%=result.get(i).getLastname()%></td>
							<td data-title="TEN"><%=result.get(i).getFirstname()%></td>
							<td data-title="EMAIL"><%=result.get(i).getEmail()%></td>
							<td data-title="PHONE"><%=result.get(i).getPhone()%></td>
							<td class="actions-cell">
								<div class="buttons right nowrap">

									<a
										href="/admin/chi-tiet-tai-khoan?iduser=<%=result.get(i).getIduser()%>">
										<button class="button small green --jb-modal" type="button">
											<span class="icon"><i class="mdi mdi-eye"> </i></span>
										</button>
									</a>




									<form id="select_info_prod" action="/admin/remove-khach-hang"
										method="POST">
										<input name="id" type="hidden"
											value="<%=result.get(i).getIduser()%>" />

										<button class="button small red --jb-modal"
											data-target="sample-modal" type="submit">
											<span class="icon"><i class="mdi mdi-trash-can"
												title="Xóa"></i></span>
										</button>

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


		<div class="notification red">
			<div
				class="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0">
				<div>
					<span class="icon"><i class="mdi mdi-buffer"></i></span> <b>Bảng
						trống.</b>
				</div>
				<button type="button"
					class="button small textual --jb-notification-dismiss">Bỏ
					qua</button>
			</div>
		</div>

		<div class="card empty">
			<div class="card-content">
				<div>
					<span class="icon large"><i
						class="mdi mdi-emoticon-sad mdi-48px"></i></span>
				</div>
				<p>Không có gì ở đây.....</p>
			</div>
		</div>
	</section>

</body>

</html>