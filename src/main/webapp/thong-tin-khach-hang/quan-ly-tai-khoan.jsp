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

						<!-- Thông tin tài khoản -->



						<h1 class="text-center mb-3">Thông tin tài khoản</h1>
						<%
						if (session.getAttribute("userLogin") != null) {
							User infoUser = (User) session.getAttribute("userLogin");
						%>


						<form class="needs-validation"
							action="/tai-khoan/cap-nhat-tai-khoan" method="POST">
							<div class="row ">
								<div class="col-sm-6">
									<label for="lastName" class="form-label">Họ</label> <input
										type="text" class="form-control" name="lastname"
										value="<%=infoUser.getLastname()%>" placeholder="Nguyễn"
										required>
									<div class="invalid-feedback">Họ hợp lệ là bắt buộc.</div>
								</div>

								<div class="col-sm-6">
									<label for="firstName" class="form-label">Tên </label> <input
										type="tel" class="form-control" name="firstname"
										value="<%=infoUser.getFirstname()%>" placeholder="Trúc Mai"
										required>
									<div class="invalid-feedback">Tên hợp lệ là bắt buộc.</div>
								</div>

								<div class="col-sm-12">
									<label for="username" class="form-label">Tên đăng nhập</label>
									<input type="text" class="form-control" name="username"
										placeholder="mainguyen" value="<%=infoUser.getUsername()%>"
										required>
									<div class="invalid-feedback">Tên đăng nhập hợp lệ là bắt
										buộc.</div>
								</div>
								<div class="col-12">
									<label for="email" class="form-label">Email<span
										class="text-muted">(Tùy chọn)</span></label> <input type="email"
										class="form-control" name="email"
										value="<%=infoUser.getEmail()%>"
										placeholder="mainguyen@gmail.com">
									<div class="invalid-feedback">Vui lòng nhập một địa chỉ
										email hợp lệ để cập nhật thông tin vận chuyển.</div>
								</div>

								<div class="col-12">
									<label for="phone" class="form-label">Số điện thoại</label> <input
										type="tel" class="form-control" name="phone"
										value="<%=infoUser.getPhone()%>" placeholder="0123456789">
									<div class="invalid-feedback">Vui lòng nhập số điện thoại
										hợp lệ để cập nhật thông tin vận chuyển.</div>
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
								Cập nhật</button>
						</form>
						<%
						}
						%>
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