<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>

<title>G15 | Đăng nhập</title>




<link rel="stylesheet" href="../themes/css1/dang-nhap.css">
</head>

<body>
	<!-- header -->


	<%@ include file="header.jsp"%>


	<main id="main">
		<section>

			<div class="container-lg">
				<div class="row justify-content-center">

					<!-- <div class="d-flex box"> -->

					<div class="col-md-5 left">
						<div class="carousel-inner-login">
							<img src="../images/logo-new.jpg" class="login" alt="First slide">
						</div>


					</div>
					<div class="col-md-7 right">
						<h1 class="text-center mb-3">Quên mật khẩu</h1>
						<div class="content">
							<form class="frm_login" validate
								action="/tai-khoan/quen-mat-khau" method="POST">
								<div class="row">


									<div class="col-12">
										<label for="email" class="form-label">Email/ Tên đăng
											nhập <span class="text-muted">(Tùy chọn)</span>
										</label> <input type="email" class="form-control" name="email"
											id="email" placeholder="Email" required>
										<div class="invalid-feedback">Vui lòng nhập một địa chỉ
											email hợp lệ để đăng nhập.</div>
									</div>

									<%
									if (request.getAttribute("error") != null) {
									%>
									<label style="color: red"><%=request.getAttribute("error")%></label>
									<%
									}
									%>

									<%
									if (request.getAttribute("message") != null) {
									%>
									<label style="color: green"><%=request.getAttribute("message")%></label>
									<%
									}
									%>
								</div>
								<hr>
								<button id="login_btn" class="btn btn-dark" type="submit">
									Lấy lại mật khẩu</button>

							</form>
						</div>
						<hr>

						<p class="d-flex text-center justify-content-center-login">
							Bạn đã có sẵn một tài khoản G15? <a
								href="/template/dang-nhap.jsp"> Đăng nhập</a>
						</p>
						<p class="d-flex text-center justify-content-center-login">
							Chưa có tài khoản tại G15? <a href="/template/dang-ky.jsp">
								Đăng ký</a>
						</p>
					</div>

				</div>

			</div>

		</section>
	</main>

	<!-- footer -->
	<%@ include file="footer.jsp"%>

</body>

</html>