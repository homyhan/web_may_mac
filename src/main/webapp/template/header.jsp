<%@page import="model.User"%>
<%@page import="java.util.Map"%>
<%@page import="response.ProductCartResponse"%>
<%@page import="java.util.HashMap"%>
<%@ page import="model.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Category" %>
<%@ page import="service.CategoryService" %>
<%@ page import="DAO.ICatalogDaO" %>
<%@ page import="DAO.impl.CatalogDaO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>G15 | Đăng nhập</title>
	<link rel="shortcut icon" href="<c:url value='/images/logo-new.jpg'/>"
		  type="image/x-icon">
	<!-- CSS only -->
	<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
			crossorigin="anonymous">
	<link rel="stylesheet" href="libs/glider.css">
	<link rel="stylesheet"
		  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
		  integrity="sha512-L7MWcK7FNPcwNqnLdZq86lTHYLdQqZaz5YcAgE+5cnGmlw8JT03QB2+oxL100UeB6RlzZLUxCGSS4/++mNZdxw=="
		  crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link
			href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@400;700&display=swap"
			rel="stylesheet">
	<link rel="stylesheet" href="libs/jquery.exzoom.min.css">
	<link rel="stylesheet" href="<c:url value='/themes/css/main.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/themes/css/style_section.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/themes/css1/menu.css'/>"/>
</head>

<body>
<!-- header -->
<header id="header">
	<div class="container">
		<div class="d-flex  align-items-center">
			<div class="col col-md-2">
				<a href="./index.jsp"> <img src="<c:url value='/images/logo-new.jpg'/>" alt=""
											width="150" id="logo"/>					</a>
			</div>
			<div class="col col-md-10">
				<div id="top-head">
					<div class="d-flex">
						<div class="col col-md-2 col-sm-12"></div>
						<div class="col col-md-5 col-sm-12">
							<form id="searchBox" action="./search" method="get">
								<div class="form-group d-flex">
									<input type="text" name="txtSearch" id="searchInput"
										   class="form-control" placeholder="Bạn cần tìm..."
										   aria-describedby="helpId" oninput="searchByName(this)" />
									<ul id="result_search_box">
									</ul>
									<button type="submit" class="btn" id="searchBtn">
										<i class="fas fa-search"></i>
									</button>
								</div>
							</form>
						</div>


						<!-- Thong tin khi ddang nhaap -->
						<div class="col-md-5 col-sm-12">
							<ul class="d-flex">
								<li>
									<a href="<c:url value='/template/quy-trinh-dat-may.jsp'/>" class="quy_trinh">Quy trình đặt may</a></li>
								<%
									User auth = (User) session.getAttribute("userLogin");
									if (auth == null) {
								%>

								<li>
									<!-- <img src="images/icon_dang_nhap.png" alt="" /> --> <a
										href="<c:url value='/template/dang-nhap.jsp'/>" class='fas fa-user-alt'> <span
										id="get_name_user">Đăng nhập</span>
								</a>
								</li>
								<li>
									<!-- <img src="images/icon_dang_nhap.png" alt="" /> --> <a
										href="<c:url value ='/template/dang-ky.jsp'/>" class='fas fa-user-alt'> <span
										id="get_name_user">Đăng ký</span></a>
								</li>
								<%
								} else {
								%>


								<div class="nav-item dropdown">
									<a href="<c:url value='/quan-tri-admin/khach-hang/khach-hang.jsp'/>"
									   class="nav-link dropdown-toggle show"
									   data-bs-toggle="dropdown" aria-expanded="true"> <img
											class="rounded-circle me-lg-2" src="../images/profie.png"
											alt="" style="width: 40px; height: 40px;"> <span
											class="d-none d-lg-inline-flex"> <%=auth.getUsername()%>
										</span>
									</a>
									<!-- có chữ show nó sẽ show ra -->
									<!-- <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0 show" data-bs-popper="none"> -->
									<div
											class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0 "
											data-bs-popper="none">
										<a href="<c:url value='/thong-tin-khach-hang/quan-ly-tai-khoan.jsp'/>"
										   class="dropdown-item">Tài khoản</a>
										<hr>
										<!-- <a href="khach-hang.jsp"  class="dropdown-item"  >Cài đặt</a> -->
										<a href="/sign-out" class="dropdown-item">Đăng suất</a>
									</div>
								</div>
								<!-- -- -->
								<!-- Thong tin khi ddang nhaap -->
								<%
									}
								%>
							</ul>
						</div>


						<!-- end Thong tin khi ddang nhaap -->
					</div>
				</div>
				<div id="sidebar">
					<div class="container">
						<div class="d-flex">
							<div class="col-md-12">
								<ul class="menu d-flex">
									<li class="menu-item"><a
											href="<c:url value ='/template/ve-chung-toi.jsp'/>" class="d-flex">
										<h4>GIỚI THIỆU</h4>
									</a></li>
									<li class="menu-item"><a href="/products" class="d-flex">
										<h4>SẢN PHẨM</h4> <i class="fas fa-chevron-down"></i>
										<div class="menu-sub">
											<!-- <ul> -->
											<%
												ICatalogDaO catalogDaO = new CatalogDaO();
												List<Category> listCatalog = catalogDaO.findAll();
											%>
											<c:forEach var="catalog" items="<%=listCatalog%>">
												<a href="/products/catalogs?id=<c:out value="${catalog.idcategory}"/> "
												   class="menu-link d-flex">
													<h5><c:out value="${catalog.title}"/></h5>
												</a>
											</c:forEach>
											<!-- </ul> -->
										</div>

									</a></li>
									<li class="menu-item"><a href="<c:url value='/template/sewing_set.jsp'/>"
															 class="d-flex">
										<h4>ĐẶT MAY</h4>
									</a></li>
									<li class="menu-item"><a href="<c:url value='/template/lien-he.jsp'/>"
															 class="d-flex">
										<h4>LIÊN HỆ</h4>
									</a></li>
									<li class="menu-item"><a href="<c:url value='/template/tin-tuc.jsp'/>"
															 class="d-flex">
										<h4>TIN TỨC</h4>
									</a></li>
									<li class="menu-item d-flex" style="display: inline">
										<a href="/cart" class="col-lg d-flex" style="margin-right: 15px">
											<i class="fa fa-cart-plus" width="24"></i> <%
											int size = 0;
											if (session.getAttribute("productCartList") != null) {
												HashMap<Integer, ProductCartResponse> cartList = (HashMap<Integer, ProductCartResponse>) session
														.getAttribute("productCartList");

												size = cartList.size();
											}
										%> <span> <%=size%>
											</span>
										</a>
										<a href="/voucher" class="col-lg d-flex">
											<i class="fas fa-ticket-alt" width="24"></i>
										</a>
									</li>

								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</header>
<section id="section_banner">
	<div class="container-lg">
		<div id="hotServiceCarousel" class="carousel slide"
			 data-bs-ride="carousel">
			<div class="carousel-inner text-center">
				<p class="carousel-item" data-bs-interval="3000">
					<strong>NHẬN ĐẶT MAY TRANG PHỤC THEO SỐ ĐO CỦA BẠN</strong>
				</p>
				<p class="carousel-item active" data-bs-interval="3000">
					<strong>TẶNG PHIẾU MUA HÀNG TRỊ GIÁ ĐẾN 10 TRIỆU !!!</strong>
				</p>
				<p class="carousel-item">
					<strong>NHẬN ĐỔI MỚI 100% NẾU SẢN PHẨM LỖI TỪ CỦA HÀNG</strong>
				</p>

			</div>
		</div>
	</div>
</section>
<style>
	#searchBox {
		position: relative;
	}
	#searchBox #result_search_box {
		padding-left: 0;
		width: 100%;
		position: absolute;
		top: 110%;
		background: #fff;
		z-index: 999;
		overflow-y: scroll;
		box-shadow: 0 4px 8px 0 rgb(0 0 0/ 20%), 0 6px 20px 0 rgb(0 0 0/ 19%);
		display: none;
		border-radius: 6px;
	}

	#searchBox:hover #result_search_box {
		display: block;
		/*height: 300px;*/
	}

	#searchBox #result_search_box .item {
		background: #fff;
	}

	#searchBox #result_search_box .item img {
		width: 70px;
		margin-right: 20px;
	}
</style>
<!-- JS -->
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	function searchByName(param) {
		var obj = document.getElementById('searchInput');
		obj.onmouseover = function () {
			if (param.value == null) {
				document.getElementById('result_search_box').style = 'height: 0px';
			}
			if (param.value != null) {
				document.getElementById('result_search_box').style = 'height: 300px';

			}
		}
		obj.oninput = function () {
			if (param.value == null) {
				document.getElementById('result_search_box').style = 'height: 0px';
				document.getElementById('result_search_box').style = 'display: none';
			}
			if (param.value != null) {
				document.getElementById('result_search_box').style = 'height: 300px';
			}
		}
		var txtSearch = param.value;
		console.log(txtSearch);
		$.ajax({
			url : "./search-ajax",
			type : "get",
			data : {
				txtS : txtSearch
			},
			success : function(data) {
				var row = document.getElementById("result_search_box");
				row.innerHTML = data;
			},
			error : function(xhr) {
			}
		});
	}

</script>
</body>

</html>