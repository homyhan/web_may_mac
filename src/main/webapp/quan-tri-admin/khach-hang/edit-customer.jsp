<%@page import="helper.Contants"%>
<%@page import="model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en" class="">
<head>

<title>Edit - Admin G15</title>

</head>
<body>
	<!-- header -->
	<%@ include file="/quan-tri-admin/header-admin.jsp"%>



	<section class="is-title-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<ul>
				<li>Admin</li>
				<li>Thông tin khách hàng</li>
			</ul>

		</div>
	</section>

	<section class="is-hero-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<h1 class="title">Thông tin khách hàng</h1>

		</div>
	</section>

	<section class="section main-section">
		<div class="card mb-6">
			<header class="card-header">
				<p class="card-header-title">
					<span class="icon"><i class="mdi mdi-ballot"></i></span> Thêm khách
					hàng mới
				</p>
			</header>
			<div class="card-content">

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

				<%
				if (request.getAttribute("accounttdetail") != null) {
					User item = (User) request.getAttribute("accounttdetail");
				%>
				<form action="/admin/cap-nhat-tai-khoan" method="POST">
					<div class="field">
						<label class="label">Từ</label>
						<div class="field-body">

							<div class="field">
								<div class="control icons-left">
									<input class="input" type="text" placeholder="Họ"
										name="lastname" value="<%=item.getLastname()%>">
									<!-- <span class="icon left"><i class="mdi mdi-table"></i></span> -->
								</div>
							</div>
							<div class="field">
								<div class="control icons-left icons-right">
									<input class="input" type="text" placeholder="tên"
										name="firstname" value="<%=item.getFirstname()%>">

								</div>
							</div>

							<div class="field">
								<div class="control icons-left icons-right">
									<input class="input" type="text" placeholder="Tên đăng nhập"
										name="username" value="<%=item.getUsername()%>">

								</div>
							</div>

							<div class="field">
								<div class="control icons-left">
									<input class="input" type="text" placeholder="Email"
										name="email" value="<%=item.getEmail()%>">
								</div>
							</div>
							<div class="field">
								<div class="control icons-left icons-right">
									<input class="input" type="text" placeholder="Số điện thoại"
										name="phone" value="<%=item.getPhone()%>">

								</div>
							</div>

						</div>
					</div>

					<div class="field">
						<div class="card">
							<header class="card-header">
								<p class="card-header-title">
									<span class="icon"><i class="mdi mdi-ballot-outline"></i></span>
									Yếu tố tuỳ chỉnh
								</p>
							</header>
							<div class="card-content">


								<div class="field">
									<label class="label">Vai trò</label>
									<div class="field-body">
										<div class="field grouped multiline">

											<div class="col-lg-12 col-md-12 col-sm-12">
												<label class="checkbox-inline">
													 <input
													type="checkbox" name="isdefault" value="2"
													<%=item.getRole() == Contants.ROLE_ADMIN ? "checked" : ""%>>
													Admin
												</label>
											</div>

										</div>
									</div>
								</div>

								<hr>

							</div>
						</div>

						<input type="hidden" name="iduser" value="<%=item.getIduser()%>"></input>
					</div>

					<hr>
					<div class="field grouped">
						<div class="control">
							<button type="submit" class="button green">Cập nhật</button>
						</div>
					</div>

				</form>
				<%
				}
				%>
			</div>
		</div>


	</section>




</body>
</html>
