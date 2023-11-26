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



						<h1 class="text-center mb-3">Thông tin địa chỉ</h1>


						<form class="needs-validation" action="/tai-khoan/them-dia-chi" method="POST">
							<div class="row ">
								<div class="col-sm-12">
									<label for="lastName" class="form-label">Tên người nhận</label>
									<input type="text" class="form-control" name="name"
										placeholder="Nguyễn Văn A" required>
									<div class="invalid-feedback">Họ hợp lệ là bắt buộc.</div>
								</div>

								<div class="col-12">
									<label for="phone" class="form-label">Số điện thoại </label> <input
										type="tel" class="form-control" name="phone"
										placeholder="0123456789" required>
									<div class="invalid-feedback">Vui lòng nhập số điện thoại
										hợp lệ để cập nhật thông tin vận chuyển.</div>
								</div>

								<div class="col-12">
									<label for="address" class="form-label">Địa chỉ giao
										hàng</label> <input type="text" class="form-control" name="address"
										placeholder="Quận Bình Thạnh" required>
									<div class="invalid-feedback">Vui lòng nhập địa chỉ vận
										chuyển của bạn.</div>
								</div>
								<div class="col-12">
									<label for="content" class="form-label">Ghi chú khi
										giao hàng</label> <input type="text" class="form-control"
										name="content" value="Giao giờ hành chính"
										placeholder="Ghi chú">
									<div class="invalid-feedback">Vui lòng nhập ghi chú.</div>
								</div>

								<div class="col-lg-12 col-md-12 col-sm-12">
									<label class="checkbox-inline"> <input type="checkbox"
										name="isdefault" value="1" checked="checked"> Đặt làm
										địa chỉ mặc định
									</label>
								</div>
							</div>

							<button id="login_btn" class="btn btn-dark" type="submit">
								Cập nhật</button>
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