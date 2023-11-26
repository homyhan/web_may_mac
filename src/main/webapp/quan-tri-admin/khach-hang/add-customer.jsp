<%@page import="model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en" class="">
<head>

<title>Add-Customer - Admin G15</title>

</head>
<body>
	<!-- header -->
	<%@ include file="/quan-tri-admin/header-admin.jsp"%>

	<section class="is-title-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<ul>
				<li>Admin</li>
				<li>Thêm khách hàng mới</li>
			</ul>
		
		</div>
	</section>



	<section class="section main-section">
		<div class="card">
			<header class="card-header">
				<p class="card-header-title">
					<span class="icon"><i class="mdi mdi-account-circle"></i></span>
					Thông tin tài khoản
				</p>
			</header>
			<div class="card-content">

				<form action="/register" method="POST" class="frm_register">
							<div class="row">


								<div class="col-sm-6">
									<label for="lastName" class="form-label">Họ</label> <input
										type="text" class="form-control" name="lastName"
										placeholder="" value="" required>
									<div class="invalid-feedback">Họ hợp lệ là bắt buộc.</div>
								</div>

								<div class="col-sm-6">
									<label for="firstName" class="form-label">Tên</label> <input
										type="text" class="form-control" name="firstName"
										placeholder="" value="" required>
									<div class="invalid-feedback">Tên hợp lệ là bắt buộc.</div>
								</div>

								<div class="col-sm-12">
									<label for="username" class="form-label">Tên đăng nhập</label>
									<input type="text" class="form-control" name="userName"
										placeholder="" value="" required>
									<div class="invalid-feedback">Tên hợp lệ là bắt buộc.</div>
								</div>


								<div class="col-12">
									<label for="email" class="form-label">Email <span
										class="text-muted">(Tùy chọn)</span></label> <input type="email"
										class="form-control" name="email"
										placeholder="you@example.com" required>
									<div class="invalid-feedback">Vui lòng nhập một địa chỉ
										email hợp lệ để cập nhật thông tin vận chuyển.</div>
								</div>

								<div class="col-sm-11">
									<label for="ip_password" class="form-label">Mật khẩu</label> <input
										type="password" class="form-control" name="password"
										placeholder="" value="" id="ip_password" required>
									<div class="invalid-feedback">Mật khẩu hợp lệ là bắt
										buộc.</div>
								</div>




								<div class="col-sm-1" style="    margin-top: 30px;">

									<button class="btn btn-outline-secondary" type="button"
										id="btnPassword">
										<span class="fas fa-eye"></span>
									</button>

								</div>



								<div class="col-sm-11">
									<label for="ip_repassword" class="form-label">Nhập lại
										mật khẩu</label> <input type="password" class="form-control"
										name="repassword" placeholder="" value="" id="ip_repassword1" required>
									<div class="invalid-feedback">Nhập lại mật khẩu hợp lệ là
										bắt buộc.</div>
								</div>

								
								<div class="col-sm-1" style="    margin-top: 30px;">

									<button class="btn btn-outline-secondary" type="button"
										id="btnrePassword1">
										<span class="fas fa-eye"></span>
									</button>

								</div>



								<div class="col-12">
									<label for="phone" class="form-label">Số điện thoại </label> <input
										type="tel" class="form-control" name="phone"
										placeholder="0123456789" required>
									<div class="invalid-feedback">Vui lòng nhập số điện thoại
										hợp lệ để cập nhật thông tin vận chuyển.</div>
								</div>
								
								
								<div class="field">
									<label class="label">Vai trò</label>
									<div class="field-body">
										<div class="field grouped multiline">

											<div class="col-lg-12 col-md-12 col-sm-12">
												<label class="checkbox-inline"> <input
													type="checkbox" name="isdefault" value="2" checked>
													Admin
												</label>
											</div>

										</div>
									</div>
								</div>

								<%
								if (request.getAttribute("error") != null) {
								%>
								<label style="color: red"><%=request.getAttribute("error")%></label>
								<%
								}
								%>

							</div>

							<hr>

							<button id="regis_btn" class="btn btn-dark" type="submit">
								Thêm khách hàng</button>
						</form>
					


			</div>
		</div>

	</section>

	<script src="/themes/js/show-password.js"></script>
</body>
</html>
