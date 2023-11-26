
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>G15 | Tra cứu đơn hàng</title>


<link rel="stylesheet" href="../themes/css1/tra-cuu-don-hang.css">


</head>
<body>
	<!-- header -->


	<%@ include file="header.jsp"%>


	<main id="main">
		<div class="container">
			<div class="row justify-content-center">

				<div class="col-md-5 left">
					<div class="carousel-inner-login">
						<img src="images/logo-new.jpg" class="login" alt="First slide">
					</div>


				</div>
				<div class="col-md-7 right">
					<h1 class="text-center mb-3">TRA CỨU ĐƠN HÀNG</h1>
					<form action="">
						<div class="form-group mb-3">
							<input type="text" name="codeOrder" id=""
								placeholder="Mã đơn hàng" class="form-control">
						</div>
						<div class="form-group mb-3">
							<input type="text" name="phoneOrder" id=""
								placeholder="Số điện thoại" class="form-control">
						</div>
						<button class="btn btn-dark" style="width: 100%">
							Tra cứu <i class="fas fa-search"></i>
						</button>
					</form>
				</div>




			</div>
		</div>
	</main>

	<!-- footer -->
	<%@ include file="footer.jsp"%>

	<!-- js -->

</body>
</html>