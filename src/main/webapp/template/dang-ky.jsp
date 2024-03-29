<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>

<title>G15 | Đăng ký</title>

<link rel="stylesheet" href="../themes/css1/dang-ky.css">
	<style>
		.hidden {
			display: none;
		}
	</style>
</head>

<body>
	<!-- header -->
	<%@ include file="header.jsp"%>



	<main id="main">
		<div class="container-lg">
			<div class="row justify-content-center">

				<!-- <div class="d-flex box"> -->

				<div class="col-md-5 left">
					<div class="carousel-inner-login">
						<img src="../images/logo-new.jpg" class="login" alt="First slide">
					</div>


				</div>
				<div class="col-md-7 right">
					<h1 class="text-center mb-3">Đăng ký</h1>
					<div class="content">
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

								<div class="col-sm-12">
									<label for="ip_password" class="form-label">Mật khẩu</label> <input
										type="password" class="form-control" name="password"
										placeholder="" value="" id="ip_password" required>
									<div class="invalid-feedback">Mật khẩu hợp lệ là bắt
										buộc.</div>
								</div>




								<div class="col-sm-1">

									<button class="btn btn-outline-secondary" type="button"
										id="btnPassword">
										<span class="fas fa-eye"></span>
									</button>

								</div>



								<div class="col-sm-12">
									<label for="ip_repassword" class="form-label">Nhập lại
										mật khẩu</label> <input type="password" class="form-control"
										name="repassword" placeholder="" value="" id="ip_repassword1" required>
									<div class="invalid-feedback">Nhập lại mật khẩu hợp lệ là
										bắt buộc.</div>
								</div>

								
								<div class="col-sm-1">

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

								<%
								if (request.getAttribute("error") != null) {
								%>
<%--								<label style="color: red"><%=request.getAttribute("error")%></label>--%>
								<div class="alert alert-danger mt-3" role="alert">
									<%=request.getAttribute("error")%>
								</div>
								<%
								}
								%>

							</div>

							<%--							FORM KEY --%>

							<label>
								<input type="radio" name="keyStatus" id="hasKey" onclick="showKeyInputs()"> Có key
							</label>

							<label>
								<input type="radio" name="keyStatus" id="noKey" onclick="disableKeyInputs()"> Chưa có key
							</label>

							<div id="keyInputs">
								<div class="hidden" id="keyInput1">
									Public key: <input class="form-control" type="text" name="publicKeyReq" id="publicKey">
								</div>
								<div class="hidden" id="keyInput2">
									Private key: <input class="form-control" type="text" name="privateKeyReq" id="privateKey">
								</div>
							</div>

							<!-- Trong phần head của trang JSP -->
							<input type="hidden" name="publicKeyReq" id="hiddenPublicKey">
							<input type="hidden" name="privateKeyReq" id="hiddenPrivateKey">


							<!-- Thêm vào bên trong thẻ form -->
							<input type="hidden" id="selectedFolderPath" name="selectedFolderPath" value="">

							<%--							END --%>

							<hr>

							<button id="regis_btn" class="btn btn-dark" type="submit">
								Đăng Ký</button>
						</form>
					</div>
					<hr>
					<p class="d-flex my-3 justify-content-center-login">
						Bạn đã có sẵn một tài khoản? <a href="dang-nhap.jsp"> Đăng
							nhập </a>
					</p>
				</div>

			</div>

		</div>
		</div>
	</main>
	<!-- footer -->
	<%@ include file="footer.jsp"%>

	<!-- js -->


	<%--	START KEY --%>
	<script>
		function showKeyInputs() {
			document.getElementById('keyInput1').classList.remove('hidden');
			document.getElementById('keyInput2').classList.remove('hidden');
			document.getElementById('keyInput1').querySelector('input').disabled =false;
			document.getElementById('keyInput2').querySelector('input').disabled =false;
			document.getElementById('keyInput1').querySelector('input').value="";
			document.getElementById('keyInput2').querySelector('input').value="";
		}

		function disableKeyInputs() {
			document.getElementById('keyInput1').classList.remove('hidden');
			document.getElementById('keyInput2').classList.remove('hidden');
			document.getElementById('keyInput1').querySelector('input').disabled =true;
			document.getElementById('keyInput2').querySelector('input').disabled =true;
		}
	</script>

	<!-- Add this at the end of your JSP file, before </body> -->
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function () {
			$("input[name='keyStatus']").change(function () {
				if ($("#noKey").prop("checked")) {
					// Make an AJAX request to the server-side endpoint
					$.ajax({
						type: "GET",
						url: "/template/generateKeys",// Update the URL to match your server-side endpoint
						dataType: "json",
						success: function (data) {
							// Update the input fields with the generated keys
							$("#publicKey").val(data.publicKey);
							$("#privateKey").val(data.privateKey);

							$("#hiddenPublicKey").val(data.publicKey);
							$("#hiddenPrivateKey").val(data.privateKey);
						},
						error: function () {
							alert("Error generating keys");
						}
					});
				}
			});
		});
	</script>
	<%--END KEY--%>


</body>

</html>