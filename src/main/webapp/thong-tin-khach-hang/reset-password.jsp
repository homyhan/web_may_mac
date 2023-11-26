<%@ page import="model.User"%>

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

						<!-- Thay đổi mật khẩu -->

						<h1 class="text-center mb-3">Thay đổi mật khẩu</h1>
						
						<%
						String username = (String)request.getAttribute("username");
						String token = (String)request.getAttribute("token");
						%>

						<form class="frm_login" action="/tai-khoan/reset-password?username=<%=username%>&token=<%=token%>" method="POST">
							<div class="row">

								<div class="col-sm-11">
									<label for="ip_password" class="form-label">Mật khẩu
										mới</label> <input type="password" class="form-control"
										name="repassword1" id="ip_repassword1"
										placeholder="Mật khẩu mới" value="" required>

									<div class="invalid-feedback">Mật khẩu hợp lệ là bắt
										buộc.</div>
								</div>

								<div class="col-sm-1">

									<button class="btn btn-outline-secondary" type="button"
										id="btnrePassword1">
										<span class="fas fa-eye"></span>
									</button>

								</div>

								<div class="col-sm-11">
									<label for="ip_repassword" class="form-label">Nhập lại
										mật khẩu</label> <input type="password" class="form-control"
										name="repassword2" id="ip_repassword2"
										placeholder="Nhập lại mật khẩu" value="" required>

									<div class="invalid-feedback">Nhập lại mật khẩu hợp lệ là
										bắt buộc.</div>
								</div>
								<div class="col-sm-1">

									<button class="btn btn-outline-secondary" type="button"
										id="btnrePassword2">
										<span class="fas fa-eye"></span>
									</button>

								</div>


								<%
								if (request.getAttribute("error") != null) {
								%>
								<label style="color: red"><%=request.getAttribute("error")%></label>
								<%
								}
								%>



							</div>
							<button id="login_btn" class="btn btn-dark" type="submit">
								Thay đổi mật khẩu</button>


						</form>


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