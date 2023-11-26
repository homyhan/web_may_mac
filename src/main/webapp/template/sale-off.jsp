<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>

<title>G15 | Khuyến mãi</title>

<link rel="stylesheet" href="../themes/css1/product.css">

</head>

<body>
	<!-- header -->


	<%@ include file="header.jsp"%>



	<main id="product_page">
		<div class="container">
			<div class="main__header">
				<div class="breadcrumbs">
					<a href="index.jsp">Trang chủ</a> <span>/</span> <a
						href="san-pham.jsp">Sản phẩm</a> <span>/</span> <strong>Giá
						siêu đặc biệt</strong>
				</div>
				<h1>Giá siêu đặc biệt</h1>
			</div>
			<div class="dd-flex">

				<article class="col col-md-9">
					<section id="section_prod_list">
						<div class="container">
                

							<div class="row justify-content-between align-items-center mb-3">
								<div class="col col-lg-3">
									<strong id="getTotalProduct"></strong> sản phẩm
								</div>
								<div class="col col-lg-3">
									<select class="form-select" aria-label="Default select example">
										<option selected>Mới nhất</option>
										<option value="1">Giá tăng dần</option>
										<option value="2">Giá giảm dần</option>
									</select>
								</div>
							</div>
							<div class="products">
								<div id="page_prods" class="row--gridd">


									<div class="card product-item">
										<a href="chi-tiet-san-pham.jsp"> <img
											src="/images/products/set-do/setdo(1).jpg"
											class="card-img-top" alt="">
											<div class="card-body text-center">
												<h3 class="card-title">Set đồ mẫu 1</h3>
												<p class="card-price">
													<span class="price"> <del>1.190.000 VND</del>
													</span> <span class="price-sale"> <strong>
															1.280.000 VND </strong>
													</span>
												</p>
										</a>
										<div class="card-btn">
											<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
											<a href="gio-hang.jsp" class="btn btn-primary"><i
												class="fas fa-cart-plus"></i></a> <a
												href="dat-may-theo-yeu-cau.jsp" class="btn btn-dark">ĐẶT
												MAY</a>
										</div>
									</div>
								</div>
								<div class="card product-item">
									<a href="chi-tiet-san-pham.jsp"> <img
										src="/images/products/set-do/setdo(2).jpg" class="card-img-top"
										alt="">
										<div class="card-body text-center">
											<h3 class="card-title">Set đồ mẫu 2</h3>
											<p class="card-price">
												<span class="price"> <del>1.190.000 VND</del>
												</span> <span class="price-sale"> <strong>
														1.280.000 VND </strong>
												</span>
											</p></a>
									<div class="card-btn">
										<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
										<a href="gio-hang.jsp" class="btn btn-primary"><i
											class="fas fa-cart-plus"></i></a> <a
											href="dat-may-theo-yeu-cau.jsp" class="btn btn-dark">ĐẶT
											MAY</a>
									</div>
								</div>
							</div>
							<div class="card product-item">
								<a href="chi-tiet-san-pham.jsp"> <img
									src="/images/products/set-do/setdo(3).jpg" class="card-img-top"
									alt="">
									<div class="card-body text-center">
										<h3 class="card-title">Set đồ mẫu 3</h3>
										<p class="card-price">
											<span class="price"> <del>1.190.000 VND</del>
											</span> <span class="price-sale"> <strong> 1.280.000
													VND </strong>
											</span>
										</p></a>
								<div class="card-btn">
									<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
									<a href="gio-hang.jsp" class="btn btn-primary"><i
										class="fas fa-cart-plus"></i></a> <a
										href="dat-may-theo-yeu-cau.jsp" class="btn btn-dark">ĐẶT
										MAY</a>
								</div>
							</div>
						</div>
						<div class="card product-item">
							<a href="chi-tiet-san-pham.jsp"> <img
								src="/images/products/set-do/setdo(4).jpg" class="card-img-top"
								alt="">
								<div class="card-body text-center">
									<h3 class="card-title">Set đồ mẫu 4</h3>
									<p class="card-price">
										<span class="price"> <del>1.190.000 VND</del>
										</span> <span class="price-sale"> <strong> 1.280.000
												VND </strong>
										</span>
									</p></a>
							<div class="card-btn">
								<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
								<a href="gio-hang.jsp" class="btn btn-primary"><i
									class="fas fa-cart-plus"></i></a> <a
									href="dat-may-theo-yeu-cau.jsp" class="btn btn-dark">ĐẶT
									MAY</a>
							</div>
						</div>
			</div>
			<div class="card product-item">
				<a href="chi-tiet-san-pham.jsp"> <img
					src="/images/products/set-do/setdo(5).jpg" class="card-img-top"
					alt="">
					<div class="card-body text-center">
						<h3 class="card-title">Set đồ mẫu 5</h3>
						<p class="card-price">
							<span class="price"> <del>1.190.000 VND</del>
							</span> <span class="price-sale"> <strong> 1.280.000 VND
							</strong>
							</span>
						</p></a>
				<div class="card-btn">
					<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
					<a href="gio-hang.jsp" class="btn btn-primary"><i
						class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
						class="btn btn-dark">ĐẶT MAY</a>
				</div>
			</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/set-do/setdo(6).jpg" class="card-img-top"
				alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Set đồ mẫu 6</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>


		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/chan-vay/CV (1).jpg" class="card-img-top"
				alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Chân váy mẫu 1</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/chan-vay/CV (2).jpg" class="card-img-top"
				alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Chân váy mẫu 2</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/chan-vay/CV (3).jpg" class="card-img-top"
				alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Chân váy mẫu 3</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>


		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/dam-vay/DV (1).jpg" class="card-img-top" alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Đầm váy mẫu 1</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/dam-vay/DV (2).jpg" class="card-img-top" alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Đầm váy mẫu 2</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/dam-vay/DV (3).jpg" class="card-img-top" alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Đầm váy mẫu 3</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/dam-vay/DV (4).jpg" class="card-img-top" alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Đầm váy mẫu 4</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/dam-vay/DV (5).jpg" class="card-img-top" alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Đầm váy mẫu 5</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/dam-vay/DV (6).jpg" class="card-img-top" alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Đầm váy mẫu 6</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/dam-vay/DV (7).jpg" class="card-img-top" alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Đầm váy mẫu 7</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/dam-vay/DV (8).jpg" class="card-img-top" alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Đầm váy mẫu 8</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/dam-vay/DV (9).jpg" class="card-img-top" alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Đầm váy mẫu 9</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/dam-vay/DV (10).jpg" class="card-img-top"
				alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Đầm váy mẫu 10</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/dam-vay/DV (11).jpg" class="card-img-top"
				alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Đầm váy mẫu 11</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>
		<div class="card product-item">
			<a href="chi-tiet-san-pham.jsp"> <img
				src="/images/products/dam-vay/DV (12).jpg" class="card-img-top"
				alt="">
				<div class="card-body text-center">
					<h3 class="card-title">Đầm váy mẫu 12</h3>
					<p class="card-price">
						<span class="price"> <del>1.190.000 VND</del>
						</span> <span class="price-sale"> <strong> 1.280.000 VND
						</strong>
						</span>
					</p></a>
			<div class="card-btn">
				<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>
				<a href="gio-hang.jsp" class="btn btn-primary"><i
					class="fas fa-cart-plus"></i></a> <a href="dat-may-theo-yeu-cau.jsp"
					class="btn btn-dark">ĐẶT MAY</a>
			</div>
		</div>
		</div>



		</div>
		<ul class="pagination"></ul>
		</div>
		</div>
		</section>
		</article>
		</div>
		</div>
	</main>
	<!-- footer -->
	<%@ include file="footer.jsp"%>

	<!-- js -->
</body>

</html>