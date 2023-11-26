
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>G15 | Yêu thích</title>

<link rel="stylesheet" href="../themes/css1/product.css">
</head>
<body>
	<!-- header -->


	<%@ include file="header.jsp"%>


	<main id="love_page" class="py-4">
		<div class="container-lg">
			<h2 class="text-center">DANH SÁCH YÊU THÍCH CỦA BẠN</h2>
			<section id="list_love">
				<p id="num_prod">
					<strong id="getTotalProduct"></strong> sản phẩm được yêu thích
				</p>
				<div class="products">
					<div id="page_prods" class="row--grid grid-4">
						<div class="card product-item">
							<a href="chi-tiet-san-pham.jsp"> <img
								src="images/products/da-hoi/DH (1).jpg" class="card-img-top"
								alt="">

								<div class="card-body text-center">

									<h3 class="card-title">Dạ hội mẫu 1</h3>
									<p class="card-price">
										<span class="price"> <del>1.280.000 VND</del>
										</span> <span class="price-sale"> <strong> 980.000
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
						<a href="chi-tiet-san-pham.jsp"></a> <img
							src="images/products/da-hoi/DH (2).jpg" class="card-img-top"
							alt="">
						<div class="card-body text-center">
							<h3 class="card-title">Dạ hội mẫu 2</h3>
							<p class="card-price">
								<span class="price"> <strong>1.280.000 VND</strong>
								</span> <span class="price-sale"> <strong> </strong>
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
							src="images/products/da-hoi/DH (3).jpg" class="card-img-top"
							alt="">
							<div class="card-body text-center">
								<h3 class="card-title">Dạ hội mẫu 3</h3>
								<p class="card-price">
									<span class="price"> <del>1.280.000 VND</del>
									</span> <span class="price-sale"> <strong> 980.000 VND
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
						src="images/products/da-hoi/DH (4).jpg" class="card-img-top"
						alt="">
						<div class="card-body text-center">
							<h3 class="card-title">Dạ hội mẫu 4</h3>
							<p class="card-price">
								<span class="price"> <del>1.280.000 VND</del>
								</span> <span class="price-sale"> <strong> 980.000 VND
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
		</div>
		<hr>
		<div class="btn_handle">
			<div class="d-flex">
				<div class="col-md-6">
					<button class="del_all_prod btn">XÓA HẾT</button>
				</div>
				<div class="col-md-6">
					<a href="san-pham.jsp" class="btn return_btn">XEM THÊM SẢN PHẨM</a>
				</div>
			</div>
		</div>
		</section>
		</div>
	</main>

	<!-- footer -->
	<%@ include file="footer.jsp"%>

	<!-- js -->
</body>
</html>