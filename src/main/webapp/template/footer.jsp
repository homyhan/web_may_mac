<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="shortcut icon" href="images/logo-new.jpg" type="image/x-icon">
<!-- THEME -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="stylesheet" href="libs/Glider.js-master/glider.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	integrity="sha512-L7MWcK7FNPcwNqnLdZq86lTHYLdQqZaz5YcAgE+5cnGmlw8JT03QB2+oxL100UeB6RlzZLUxCGSS4/++mNZdxw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@400;700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="/themes/css/main.css">
<link rel="stylesheet" href="/themes/css/style_section.css">
<link rel="stylesheet" href="/themes/css1/footer.css">
</head>

<body>
	<!-- footer -->
	<footer>
		<div class="container">
			<div class="d-flex">
				<div class="col-md-3">
					<div class="store d-flex ">
						<img src="../images/logo2.png" class="img-footer" alt=""> <a
							href="lienhe.jsp" class="storeBtn btn">TÌM CỬA HÀNG</a>
					</div>
				</div>
				<div class="col-md-9">
					<div class="content-foot">
						<div class="row">
							<div class="col-md-3">
								<ul class="menu-bot">
									<li class="head">SẢN PHẨM</li>

									<li><a href="da-hoi.jsp">Váy dạ hội</a></li>
									<li><a href="ao-dai.jsp">Áo dài</a></li>
									<li><a href="dam-vay.jsp">Đầm, váy</a></li>

									<li><a href="vest.jsp">Vest</a></li>
									<li><a href="chan-vay.jsp">Chân váy</a></li>
									<li><a href="quan.jsp">Quần</a></li>
									<li><a href="set-do.jsp">Set đồ</a></li>
									<li><a href="ao-khoac.jsp">Áo khoác</a></li>
								</ul>
							</div>
							<div class="col-md-3">
								<ul class="menu-bot">
									<li class="head">VỀ CÔNG TY</li>
									<li><a href="tuyen-dung.jsp">Tuyển dụng</a></li>
									<li><a href="lien-he.jsp">Liên hệ</a></li>
									<li><a href="ve-chung-toi.jsp">Về MBA</a></li>

									<li class="head">THÀNH VIÊN</li>
									<li>Nguyễn Thị Trúc Mai</li>
									<li>Châu Quế Bình</li>
									<li>Trần Thu An</li>


								</ul>
							</div>
							<div class="col-md-3">
								<div class="menu-bot">
									<div class="head">MBA SOCIAL</div>
									<div class="d-flex ">
										<a href="#" class="socialIcon"> <img
											src="../images/icon_social1.png" alt="">
										</a> <a href="#" class="socialIcon"> <img
											src="../images/icon_social2.png" alt="">
										</a> <a href="#" class="socialIcon"> <img
											src="../images/icon_social3.png" alt="">
										</a>

									</div>


								</div>
							</div>
							<div class="col-md-3">
								<ul class="menu-bot">


									<!-- <div class="col-sm-6 col-lg-3 p-b-50"> -->
									<div class="head">Đăng ký nhận email</div>

									<form action="./registerNotify" method="post">
										<div class="wrap-input1 w-full p-b-4">
											<input class="input1 bg-none plh1 stext-107 cl7" type="email" name="emailTo"
												   placeholder="email@example.com" style="width: 100%; border-radius: 6px">
											<div class="focus-input1 trans-04"></div>
										</div>
										<div class="p-t-18">
											<button class="flex-c-m stext-101 cl0 size-103 bg1 bor1 hov-btn2 p-lr-15 trans-04" type="submit">
												Gửi
											</button>
										</div>
									</form>
									${msgRegisterNotify}
									<!-- </div> -->


								</ul>
							</div>


						</div>
						<div class="row">

							<div class="col-md-12">
								<p>
									Copy <i class="fa fa-copyright" aria-hidden="true"></i> 2020
									MBA. All rights reserved
								</p>

							</div>
						</div>


					</div>
				</div>
			</div>
		</div>
	</footer>

	<!-- on_top_btn -->
	<a href="#section_banner" type="button" id="to_top_btn" class="btn"
		data-toggle="tooltip" data-placement="top" title="Back to Top"> <i
		class="fas fa-chevron-up"></i>
	</a>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
	<script src="/themes/js/main.js"></script>

	<script src="/themes/js/form-validation-login.js"></script>

	<!-- <link rel="stylesheet" href="themes/css1/style.css"> -->
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
	<!-- THEME -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
		integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<!-- thông tin khach hang -->
	<script src="/themes/js/show-password.js"></script>
	<script src="libs/hip.js"></script>
	<script src="/libs/jquery.exzoom.js"></script>
</body>

</html>

