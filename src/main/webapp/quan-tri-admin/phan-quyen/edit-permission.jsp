<%@page import="model.RolePermission"%>
<%@page import="model.Permission"%>
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
				<li>Edit permission</li>
			</ul>

		</div>
	</section>
	<!-- Noi dung -->
	<section class="is-hero-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<h1 class="title">Bảng Edit permission</h1>
			<!-- Nut Them -->
			<a href="/quan-tri-admin/khach-hang/add-customer.jsp"
				class="button blue"> <span class="icon"><i
					class="mdi mdi-account-multiple-plus-outline"></i></span> <span>Edit
					permission</span>
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

		<!-- View -->

		<!-- Edit -->
		<div class="notification blue">
			<div
				class="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0">
				<div>
					<span class="icon"><i class="mdi mdi-buffer"></i></span> <b>
						Edit permission </b>
				</div>
				<button type="button"
					class="button small textual --jb-notification-dismiss">Bỏ
					qua</button>
			</div>
		</div>



		<div class="card-content">
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Quyền</th>
						<th>Action</th>
						<th>Ẩn hiện</th>
					</tr>
				</thead>
				<%
				if (request.getAttribute("showAllPemision") != null) {
					
					int idRole = (int)request.getAttribute("idRoleOfPermision");
					List<Permission> pemisions = (ArrayList<Permission>) request.getAttribute("showAllPemision");
									
					for (int i = 0; i < pemisions.size(); i++) {
										
				%>
				<form class="needs-validation" action="/admin/permision/upsert-permission"
					method="POST">
				<tbody>

					<tr>

						<td data-title="ID"><%=pemisions.get(i).getIdpermission()%>
						<td data-title="QUYEN"><%=pemisions.get(i).getPermissionname()%>

						</td>

						<td data-title="ACTION"><%=pemisions.get(i).getAction()%></td>

						<td data-label="Hidden">
							<input class="input" type="hidden" name="idRole"
							value="<%= idRole%>">
							
							<input class="input" type="hidden" name="idPermission"
							value="<%=pemisions.get(i).getIdpermission()%>">
							
							<button class="button " data-target="sample-modal-2"
								type="button">								
								<input type="checkbox" name="isCheckPermission" value="1"
									<%=pemisions.get(i).getStatus() == 1 ? "checked" : ""%>>
									
							</button>
						</td>
						<td data-title="BTN">
							<button type="submit" class="button green">Cập nhật</button>
						</td>
					</tr>
				</tbody>
				</form>
				<%
				}
				}
				%>
			</table>






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