<%@page import="response.UserRole"%>
<%@page import="model.Role"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="helper.Contants"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en" class="">

<head>
<title>Phân quyền - Admin G15</title>

</head>

<body>

	<!-- header -->
	<%@ include file="/quan-tri-admin/header-admin.jsp"%>

	<section class="is-title-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<ul>
				<li>Admin</li>
				<li>Phân quyền</li>
			</ul>

		</div>
	</section>
	<!-- Noi dung -->
	<section class="is-hero-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<h1 class="title">Bảng Phân quyền</h1>
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
						Phân quyền</b>
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
					Phân quyền
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
							<th>Role</th>
							<th>Thao tác</th>

							<th>Role Id</th>
							<th>Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<%
						if (request.getAttribute("userAdminPessionList") != null) {
							List<User> result = (ArrayList<User>) request.getAttribute("userAdminPessionList");
							for (int i = 0; i < result.size(); i++) {
						%>
						<tr>
							<td data-title="ID"><%=i + 1%></td>
							<td data-title="TENDANGNHAP"><%=result.get(i).getUsername()%></td>


							<td data-title="PHANQUYEN"><%=result.get(i).getIdrole()%></td>

							</td>

							<td class="actions-cell">
								<div class="buttons right nowrap">


									<form action="/admin/permision/phan-quyen-user/updade-idrole"
										method="POST">
										<div class="actions-status">

											<input name="iduser" type="hidden"
												value="<%=result.get(i).getIduser()%>" />

											<%
											if (result.get(i).getRole() == Contants.ROLE_ADMIN && request.getAttribute("roleList") != null) {
												List<Role> roles = (ArrayList<Role>) request.getAttribute("roleList");

												HashMap<Integer, String> roleArray = new HashMap<Integer, String>();

												for (int j = 0; j < roles.size(); j++) {
													roleArray.put(roles.get(j).getIdrole(), roles.get(j).getRolename());
												}
											%>
											<select class="form-select" name="idrole"
												aria-label="Default select example">
												<%
												for (Map.Entry<Integer, String> entry : roleArray.entrySet()) {
												%>
												<option value="<%=entry.getKey()%>"
													<%=(entry.getKey().equals(result.get(i).getIdrole())) ? "selected" : ""%>>
													<%=entry.getValue()%>
												</option>
												<%
												}
												%>
											</select>
											<%
											}
											%>

											<button class="button small green --jb-modal"
												data-target="sample-modal" type="submit">Cập nhật</button>
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