<%@ page import="model.User"%>
<%@ page import="model.Product"%>
<%@ page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>

<title>G15 | Sản phẩm</title>

<link rel="stylesheet" href="../themes/css1/product.css">


</head>

<body>
	<!-- header -->


	<%@ include file="header.jsp"%>



	<!-- product_page -->
	<main id="product_page">
		<div class="container">
			<!-- main__header -->
			<div class="main__header">
				<div class="breadcrumbs">
					<a href="index.jsp">Trang chủ</a> <span class="div">/</span> <strong>Sản
						phẩm</strong>
				</div>
				<h1>Sản phẩm</h1>
			</div>

			<!-- container listproduct -->
			<div class="d-flex">
				<!-- menu bar product -->
				<article class="col col-md-3">
					<section id="menu_side">
						<div class="row">
							<div class="col col-lg-12 menu-item">
								<button class="btn btn-secondary" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapseStatus"
									aria-expanded="true" aria-controls="collapseStatus">
									Trạng thái<i class="fas fa-chevron-up"></i>
								</button>
								<div class="collapse show" id="collapseStatus">
									<ul>
										<li><a href="#">Sản phẩm bán chạy</a></li>
										<li><a href="#">Sản phẩm nổi bật</a></li>
									</ul>
								</div>
							</div>
							<div class="col col-lg-12 menu-item">
								<button class="btn btn-secondary" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapseCate"
									aria-expanded="true" aria-controls="collapseCate">
									Dòng sản phẩm <i class="fas fa-chevron-up"></i>
								</button>
								<div class="collapse show" id="collapseCate">
									<ul>
										<li><a href="#">Váy dạ hội</a></li>
										<li><a href="#">Đầm, váy</a></li>
										<li><a href="#">Áo dài</a></li>
										<li><a href="#">Vest</a></li>
										<li><a href="#">Chân váy</a></li>
										<li><a href="#">Quần</a></li>
										<li><a href="#">Set đồ</a></li>
										<li><a href="#">Áo khoác</a></li>
									</ul>
								</div>
							</div>
							<div class="col col-lg-12 menu-item">
								<button class="btn btn-secondary" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapsePrice"
									aria-expanded="true" aria-controls="collapsePrice">
									Giá<i class="fas fa-chevron-up"></i>
								</button>
								<div class="collapse show" id="collapsePrice">
									<ul>
										<li><a href="#">Dưới 1.000.000</a></li>
										<li><a href="#">Từ 1.000.000 đến 5.000.000</a></li>
										<li><a href="#">Từ 5.000.000</a></li>
									</ul>
								</div>
							</div>
							<div class="col col-lg-12 menu-item">
								<button class="btn btn-secondary" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapseSaleoff"
									aria-expanded="true" aria-controls="collapseSaleoff">
									Sản phẩm khuyến mãi <i class="fas fa-chevron-up"></i>
								</button>
								<div class="collapse show" id="collapseSaleoff">
									<ul>
										<li><a href="sale-off.jsp">Giá Siêu đặc biệt</a></li>


										<li><a href="#">Áo dài</a></li>
										<li><a href="#">Vest</a></li>
										<li><a href="#">Chân váy</a></li>
										<li><a href="#">Quần</a></li>
										<li><a href="#">Set đồ</a></li>
										<li><a href="#">Áo khoác</a></li>
									</ul>
								</div>
							</div>
						</div>
					</section>
				</article>
				<!-- product -->
				<article class="col col-md-9">
					<section id="section_prod_list">
						<div class="container">
							<!-- filter product -->
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
							<!-- list product -->
							<div class="products">
								<div id="page_prods" class="row--grid">
									<%
									List<Product> list = (List<Product>) request.getAttribute("listproduct");
									for (Product p : list) {
									%>
									<div class="card product-item">
										<a href="/detail?idproduct=<%=p.getIdproduct()%>"> <img
											src="<%=p.getImage()%>" class="card-img-top" alt="">
										</a>
										<div class="card-body text-center">
											<h3 class="card-title">
												<%=p.getSku()%>
											</h3>
											<p class="card-price">
												<span class="price"> <del>
														<%=p.getPrice()%>
														VND
													</del>
												</span> <span class="price-sale"> <strong> <%=p.getDiscount()%>
														VND
												</strong>
												</span>
											</p>
											<div class="card-btn">
												<button class="btn btn-like" value="ak3"
													title="Thêm vào mục yêu thích">
													<i class="fas fa-heart"></i>

												</button>

												<form action="/cart/add-to-cart" method="POST">
													<input name="ismeasure" type="hidden" value="0"> <input
														name="id" type="hidden" value="<%=p.getIdproduct()%>">
													<input type="hidden" name="get_quantity_order"
														id="get_quantity_order" class="form-control" value="1"
														min="1" /> <input name="get_size_order" type="hidden" value="S"/>
													<button class="fas fa-cart-plus"></button>
												</form>
												<a href="/datmay?idproduct=<%=p.getIdproduct()%>"
													class="btn btn-outline-dark m-2" id="datmay_btn">ĐẶT
													MAY</a>
											</div>
										</div>
									</div>
									<%
									}
									%>
								</div>
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


	<script src="../themes/js/paginateProducts.js"></script>

</body>

</html>