<%@page import="model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en" class="">
<head>

<title>Profile - Admin G15</title>

</head>
<body>
	<!-- header -->
	<%@ include file="/quan-tri-admin/header-admin.jsp"%>

	<section class="is-title-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<ul>
				<li>Admin</li>
				<li>Profile</li>
			</ul>
			<a href="https://justboil.me/"
				onclick="alert('Coming soon'); return false" target="_blank"
				class="button blue"> <span class="icon"><i
					class="mdi mdi-credit-card-outline"></i></span> <span>Premium Demo</span>
			</a>
		</div>
	</section>

	<section class="is-hero-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<h1 class="title">Profile</h1>
			<button class="button light">Button</button>
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

				<form class="needs-validation"
					action="/admin/profile/cap-nhat-tai-khoan" method="POST">
					<div class="image w-48 h-48 mx-auto">
						<img src="https://avatars.dicebear.com/v2/initials/john-doe.svg"
							alt="John Doe" class="rounded-full">
					</div>
					<div class="field">
						<label class="label">Avatar</label>
						<div class="field-body">
							<div class="field file">
								<label class="upload control"> <a class="button blue">
										Upload </a> <input type="file">
								</label>
							</div>
						</div>
					</div>
					<hr>

					<!-- Thông tin tài khoản -->
					<%
					if (session.getAttribute("userLogin") != null) {
						User infoUser = (User) session.getAttribute("userLogin");
					%>

					<div class="row ">

						<div class="field">
							<label class="label">Họ</label>
							<div class="field-body">
								<div class="field">
									<div class="control">
										<input type="text" class="form-control" name="lastname"
											value="<%=infoUser.getLastname()%>" placeholder="Nguyễn"
											required>

									</div>
									<div class="invalid-feedback">Họ hợp lệ là bắt buộc.</div>
								</div>
							</div>
						</div>
						<div class="field">
							<label class="label">Tên</label>
							<div class="field-body">
								<div class="field">
									<div class="control">
										<input type="text" class="form-control" name="firstname"
											value="<%=infoUser.getFirstname()%>" placeholder="Nguyễn"
											required>

									</div>
									<div class="invalid-feedback">Tên hợp lệ là bắt buộc.</div>
								</div>
							</div>
						</div>

						<div class="field">
							<label class="label">Tên đăng nhập</label>
							<div class="field-body">
								<div class="field">
									<div class="control">
										<input type="text" class="form-control" name="username"
											value="<%=infoUser.getUsername()%>" placeholder="Nguyễn"
											required>

									</div>
									<div class="invalid-feedback">Tên đăng nhập hợp lệ là
										bắt.</div>
								</div>
							</div>
						</div>

						<div class="field">
							<label for="email" class="form-label">Email<span
								class="text-muted">(Tùy chọn)</span></label>
							<div class="field-body">
								<div class="field">
									<div class="control">
										<input type="email" class="form-control" name="email"
											value="<%=infoUser.getEmail()%>"
											placeholder="mainguyen@gmail.com">
									</div>
									<div class="invalid-feedback">Vui lòng nhập một địa chỉ
										email hợp lệ để cập nhật thông tin vận chuyển.</div>
								</div>
							</div>
						</div>


						<div class="field">
							<label class="label">Số điện thoại</label>
							<div class="field-body">
								<div class="field">
									<div class="control">
										<input type="text" class="form-control" name="phone"
											value="<%=infoUser.getPhone()%>" placeholder="Nguyễn"
											required>

									</div>
									<div class="invalid-feedback">Vui lòng nhập số điện thoại
										hợp lệ để cập nhật thông tin vận chuyển.</div>
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
					<div class="field">
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
		<div class="card">
			<header class="card-header">
				<p class="card-header-title">
					<span class="icon"><i class="mdi mdi-lock"></i></span> Thay đổi mật khẩu
				</p>
			</header>
			<div class="card-content">
				<!-- Thay đổi mật khẩu -->

				<%
				if (session.getAttribute("userLogin") != null) {
					User infoUser = (User) session.getAttribute("userLogin");
				%>
				<form class="frm_login" action="/admin/profile/thay-doi-mat-khau"
					method="POST">
					<div class="row">

						<div class="field">
							<label class="label">Mật khẩu hiện tại</label>
							<div class="control">
								<input type="password" class="form-control" name="password"
									id="ip_password" placeholder="Mật khẩu hiện tại" value=""
									required>
							</div>
							<div class="invalid-feedback">Mật khẩu hợp lệ là bắt buộc.</div>
						</div>

						<div class="col-sm-1">

							<button class="btn btn-outline-secondary" type="button"
								id="btnPassword">
								<span class="fas fa-eye"></span>
							</button>

						</div>

						<div class="field">
							<label class="label">Mật khẩu mới</label>
							<div class="control">
								<input type="password" class="form-control" name="repassword1"
									id="ip_repassword1" placeholder="Mật khẩu mới" value=""
									required>
							</div>
							<div class="invalid-feedback">Mật khẩu hợp lệ là bắt buộc.</div>
						</div>


						<div class="col-sm-1">

							<button class="btn btn-outline-secondary" type="button"
								id="btnrePassword1">
								<span class="fas fa-eye"></span>
							</button>

						</div>

						<div class="field">
							<label class="label">Nhập lại mật khẩu</label>
							<div class="control">
								<input type="password" class="form-control" name="repassword2"
									id="ip_repassword2" placeholder="Nhập lại mật khẩu" value=""
									required>
							</div>
							<div class="invalid-feedback">Mật khẩu hợp lệ là bắt buộc.</div>
						</div>

						<div class="col-sm-1">

							<button class="btn btn-outline-secondary" type="button"
								id="btnrePassword2" >
								<span class="fas fa-eye"></span>
							</button>

						</div>

						<%
						if (request.getAttribute("error-pass") != null) {
						%>
						<label style="color: red"><%=request.getAttribute("error-pass")%></label>
						<%
						}
						%>

					</div>

					<div class="field">
						<div class="control">
							<button type="submit" class="button green">Thay đổi mật
								khẩu</button>
						</div>
					</div>


				</form>

				<%
				}
				%>
			</div>
		</div>
	</section>

	<script src="/themes/js/show-password.js"></script>
</body>
</html>
