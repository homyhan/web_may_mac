<%@page import="response.ProductInf"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>

<title>G15 | Chi tiết sản phẩm</title>

<link rel="stylesheet" href="/themes/css1/chi-tiet-don-hang.css">
<link rel="stylesheet" href="libs/jquery.exzoom.min.css">

<!-- <link rel="stylesheet" href="themes/css1/style.css"> -->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
</head>

<body>
	<!-- header -->


	<%@ include file="header.jsp"%>
	<main id="detail_page">
		<div class="container-lg">
			<div class="main__header">
				<div class="breadcrumbs">
					<a href="index.jsp">Trang chủ</a> <span class="div">/</span> <a
						href="san-pham.jsp">Dạ hội</a> <span class="div">/</span> <strong>Dạ
						hội đen</strong>
				</div>
				<h1>DẠ HỘI ĐEN</h1>
			</div>

			<section class="content_prod row">
				<%
				if (request.getAttribute("productdetail") != null) {
					ProductInf item = (ProductInf) request.getAttribute("productdetail");
				%>
				<article class="col-lg-6 col picts_prod">
					<div class="exzoom" id="exzoom">
						<div class="exzoom_img_box">
							<ul class="exzoom_img_ul">

								<li><img
									src='images\products\<c:out value="<%=item.getCodecate()%>"/>/<c:out value="<%=item.getImage()%>"/>'
									class="card-img-top"
									alt="<c:out value="<%=item.getImage()%>"/>"></li>

							</ul>
						</div>
						<!-- <div class="exzoom_nav"></div> -->
					</div>
					<script>
						$(function() {
							$("#exzoom").exzoom({
								"autoPlay" : true,
								"autoPlayTimeout" : 2000
							});
						});
					</script>
				</article>


				<article id="infor_prod" class="col col-md-6">
					<!-- danh gia san pham -->


					<h3>

						<strong id="get_ID_prod"> <%=item.getTitle()%></strong>

					</h3>
					<div class="rating_section mb-2">
						<div class="d-flex">
							<p>
								<span class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span>
							</p>
							<a href="#comments_review" class="btn">4.7</a>
						</div>
					</div>
					<!-- ma san pham, trang thai va gia -->
					<div class="box_group">



						<div class="d-flex mb-2">
							<div class="col-md-6 p-0">
								Mã sản phẩm: <strong id="get_ID_prod"> <%=item.getSku()%>
								</strong>
							</div>
							<div class="col-md-6 p-0">
								Tình trạng: <strong id="get_state_prod">Sản phẩm nổi
									bật</strong>
							</div>
						</div>
						<p class="priceP">

							<span class="me-3"><del>
									<fmt:formatNumber type="number" maxFractionDigits="3"
										value="<%=item.getPrice()%>" />
								</del>VND</span> <strong class="pricesale"> <fmt:formatNumber
									type="number" maxFractionDigits="3"
									value="<%=item.getDiscount()%>" /> VND
							</strong>
						</p>
					</div>

					<!-- form chon size, so luong, them vao gio hang, thanh toan  -->
					<div class="box_group">

						<form id="select_info_prod" action="/cart/add-to-cart"
							method="POST">
							<div class="row">
								<input name="ismeasure" type="hidden" value="0"> <input
									name="id" type="hidden" value="<%=item.getIdproduct()%>" />
								<div class="form-group col-md-6 mb-2">
									<label for="get_size_prod" class="form-label">SIZE</label> <select
										class="form-select" name="get_size_order"
										aria-label="Default select example">
										<%
										ArrayList<String> eqArray = new ArrayList<String>();
										eqArray.add("S");
										eqArray.add("M");
										eqArray.add("L");
										eqArray.add("XL");
										eqArray.add("2XL");
										eqArray.add("3XL");
										for (int count = 0; count < eqArray.size(); count++) {
										%>
										<option value="<%=eqArray.get(count)%>">
											<%=eqArray.get(count)%>
										</option>
										<%
										}
										%>
									</select>
								</div>
								<div class="form-group col-md-6  mb-2">

									<label for="get_quantity_order" class="form-label">SỐ
										LƯỢNG</label> <input type="number" name="get_quantity_order"
										id="get_quantity_order" class="form-control" value="1" min="1" />


								</div>
							</div>
							<button class="btn btn-dark" type="submit">THÊM VÀO GIỎ
								HÀNG</button>

						</form>
						<div class="d-flex">
							<button class="btn btn-outline-dark m-2 btn-like">
								<i class="fas fa-heart"></i>
							</button>

							<a href="/datmay?idproduct=<%=item.getIdproduct()%>"
								class="btn btn-outline-dark m-2" id="datmay_btn">ĐẶT MAY</a>
						</div>

					</div>
					<!-- mo ta -->
					<div class="box_group">
						<p id="get_descript_prod">
							Chất liệu: vải tổng hợp cao cấp <br> Kiểu dáng: áo dài thiết
							kế tay bồng, tone màu đỏ trơn, cổ vuông, kết hợp họa tiết hoa
							đính nổi<br> Phù hợp: lễ tết, cưới hỏi, đi sự kiện, tạo vẻ
							trẻ trung, duyên dáng cho người mặc.<br>
						</p>
					</div>
					<div class="box_group">

						<button type="button" class="collapsible">
							THÔNG TIN SẢN PHẨM <i class="fas fa-chevron-down"></i>
						</button>
						<div class="content">
							<table>
								<tbody>
									<tr>
										<td class="xl67"
											style="border-bottom: 2px solid black; height: 38px; width: 118px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"> <span
												style="color: black"> <span style="font-weight: 700">

														<span style="font-style: normal"> <span
															style="text-decoration: none">SIZE&nbsp;</span>
													</span>

												</span></span></span>
										</td>
										<td class="xl68"
											style="border-bottom: 2px solid black; width: 152px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 700"><span
														style="font-style: normal"><span
															style="text-decoration: none">S - 02</span></span></span></span></span>
										</td>
										<td class="xl68"
											style="border-bottom: 2px solid black; width: 152px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 700"><span
														style="font-style: normal"><span
															style="text-decoration: none">M - 04</span></span></span></span></span>
										</td>
										<td class="xl68"
											style="border-bottom: 2px solid black; width: 152px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 700"><span
														style="font-style: normal"><span
															style="text-decoration: none">L - 06</span></span></span></span></span>
										</td>
										<td class="xl68"
											style="border-bottom: 2px solid black; width: 152px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 700"><span
														style="font-style: normal"><span
															style="text-decoration: none">XL - 08</span></span></span></span></span>
										</td>
										<td class="xl68"
											style="border-bottom: 2px solid black; width: 152px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 700"><span
														style="font-style: normal"><span
															style="text-decoration: none">2XL - 10</span></span></span></span></span>
										</td>
										<td class="xl68"
											style="border-bottom: 2px solid black; width: 152px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 700"><span
														style="font-style: normal"><span
															style="text-decoration: none">3XL - 12</span></span></span></span></span>
										</td>
									</tr>
									<tr>
										<td class="xl69"
											style="border-bottom: 2px solid black; height: 38px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 700"><span
														style="font-style: normal"><span
															style="text-decoration: none">VAI (cm)</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">35</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">36</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">37</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">38</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">39</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">40</span></span></span></span></span>
										</td>
									</tr>
									<tr>
										<td class="xl69"
											style="border-bottom: 2px solid black; height: 38px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 700"><span
														style="font-style: normal"><span
															style="text-decoration: none">NGỰC (cm)</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">82</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">86</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">90</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">94</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">98</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">102</span></span></span></span></span>
										</td>
									</tr>
									<tr>
										<td class="xl69"
											style="border-bottom: 2px solid black; height: 38px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 700"><span
														style="font-style: normal"><span
															style="text-decoration: none">EO (cm)</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">66&nbsp;</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">70</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">75</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">80</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">84</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">88</span></span></span></span></span>
										</td>
									</tr>
									<tr>
										<td class="xl69"
											style="border-bottom: 2px solid black; height: 38px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 700"><span
														style="font-style: normal"><span
															style="text-decoration: none">MÔNG (cm)</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">86</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">90</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">94</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">98</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">102</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">106</span></span></span></span></span>
										</td>
									</tr>
									<tr>
										<td class="xl72"
											style="border-bottom: 2px solid black; height: 38px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 700"><span
														style="font-style: normal"><span
															style="text-decoration: none">CÂN NẶNG (kg)</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">45 - 50</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">51 - 55</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">56 - 60</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">61 - 64</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">65 - 68</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">69 - 70</span></span></span></span></span>
										</td>
									</tr>
									<tr>
										<td class="xl69"
											style="border-bottom: 2px solid black; height: 38px; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 700"><span
														style="font-style: normal"><span
															style="text-decoration: none">CHIỀU CAO (cm).</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">150 - 160</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">155 - 160</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">155 - 160</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">160 - 165</span></span></span></span></span>
										</td>
										<td class="xl70"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">160 - 165</span></span></span></span></span>
										</td>
										<td class="xl71"
											style="border-bottom: 2px solid black; vertical-align: middle; padding-top: 1px; padding-right: 1px; padding-left: 1px; white-space: nowrap; border-top: none; border-right: none; border-left: none; text-align: center;">
											<span style="font-size: 16px"><span
												style="color: black"><span style="font-weight: 400"><span
														style="font-style: normal"><span
															style="text-decoration: none">160 - 165</span></span></span></span></span>
										</td>
									</tr>
								</tbody>
							</table>
						</div>


					</div>


					<div class="box_group">
						<button type="button" class="collapsible">
							QUY ĐỊNH SẢN PHẨM <i class="fas fa-chevron-down"></i>
						</button>
						<div class="content">
							<ul class="menu" style="list-style: decimal;">
								<li class="menu-item">Chỉ đổi hàng 1 lần duy nhất, mong bạn
									cân nhắc kĩ trước khi quyết định.</li>
								<li class="menu-item">Thời hạn đổi sản phẩm khi mua trực
									tiếp tại cửa hàng là 07 ngày, kể từ ngày mua. Đổi sản phẩm khi
									mua online là 14 ngày, kể từ ngày nhận hàng.</li>
								<li class="menu-item">Sản phẩm đổi phải kèm hóa đơn. Bắt
									buộc phải còn nguyên tem, hộp, nhãn mác.</li>
								<li class="menu-item">Sản phẩm đổi không có dấu hiệu đã qua
									sử dụng, không giặt tẩy, bám bẩn, biến dạng.</li>
								<li class="menu-item">MBA chỉ ưu tiên hỗ trợ đổi size.
									Trong trường hợp sản phẩm hết size cần đổi, bạn có thể đổi sang
									01 sản phẩm khác:
									<p>- Nếu sản phẩm muốn đổi ngang giá trị hoặc có giá trị
										cao hơn, bạn sẽ cần bù khoảng chênh lệch tại thời điểm đổi
										(nếu có).</p>
									<p>- Nếu bạn mong muốn đổi sản phẩm có giá trị thấp hơn,
										chúng tôi sẽ không hoàn lại tiền.</p>
								</li>
								<li class="menu-item">Trong trường hợp sản phẩm - size bạn
									muốn đổi không còn hàng trong hệ thống. Vui lòng chọn sản phẩm
									khác.</li>
								<li class="menu-item">Không hoàn trả bằng tiền mặt dù bất
									cứ trong trường hợp nào. Mong bạn thông cảm.</li>
							</ul>
						</div>

					</div>
					<div class="box_group">
						<button type="button" class="collapsible">
							BẢO HÀNH THẾ NÀO <i class="fas fa-chevron-down"></i>
						</button>
						<div class="content">
							<p>
								Mỗi đôi bộ đồ MBA trước khi xuất xưởng đều trải qua nhiều khâu
								kiểm tra. Tuy vậy, trong quá trình sử dụng, nếu nhận thấy các
								lỗi và trong thời gian 6 tháng từ ngày mua hàng, mong bạn sớm
								gửi sản phẩm về MBA nhằm giúp chúng tôi có cơ hội phục vụ bạn
								tốt hơn. Vui lòng gửi sản phẩm về bất kỳ cửa hàng MBA nào, hoặc
								gửi đến trung tâm bảo hành Ananas ngay trong trung tâm TP.HCM
								trong giờ hành chính: <br> Lầu 1, 75/1 Mai Thị Lựu, P. Đa
								Kao, Q1, TP.HCM <br> Hotline: 028 3526 7774
							</p>
						</div>

					</div>
				</article>
				<%
				}
				%>
			</section>
		</div>
		<!-- san pham lien qua -->
		<section id="section_prods_concern" class="my-3">
			<div class="container-fluid">
				<div class="container">

					<h2>SẢN PHẨM LIÊN QUAN</h2>


					<div class="slider owl-carousel">


						<div class="content"">
							<div class=" card card_product product-item">
								<a href="chi-tiet-san-pham.jsp"> <img
									src="images/products/da-hoi/DH (7).jpg" class="card-img-top"
									alt="banner_1">
								</a>
								<div class="card-body">
									<h5>
										<a href="#">Dạ hội 5 </a>
									</h5>
									<p class="bold">
										<span>1.520</span>.000VND
									</p>
								</div>
							</div>
						</div>
						<div class="content">
							<div class="card card_product">
								<a href="chi-tiet-san-pham.jsp"> <img
									src="images/products/da-hoi/DH (8).jpg" class="card-img-top"
									alt="banner_1">
								</a>
								<div class="card-body">
									<h5>
										<a href="#">Dạ hội 2 </a>
									</h5>
									<p class="bold">
										<span>520</span>.000VND
									</p>
								</div>
							</div>
						</div>
						<div class="content">
							<div class="card card_product">
								<a href="chi-tiet-san-pham.jsp"> <img
									src="images/products/da-hoi/DH (17).jpg" class="card-img-top"
									alt="banner_1">
								</a>
								<div class="card-body">
									<h5>
										<a href="#">Dạ hội 9 </a>
									</h5>
									<p class="bold">
										<span>1.020</span>.000VND
									</p>
								</div>
							</div>
						</div>
						<div class="content">
							<div class="card card_product">
								<a href="chi-tiet-san-pham.jsp"> <img
									src="images/products/da-hoi/DH (6).jpg" class="card-img-top"
									alt="banner_1">
								</a>
								<div class="card-body">
									<h5>
										<a href="#">Dạ hội 4 </a>
									</h5>
									<p class="bold">
										<span>520</span>.000VND
									</p>
								</div>
							</div>
						</div>


					</div>

					<script>
						$(".slider").owlCarousel({
							loop : true,
							autoplay : true,
							autoplayTimeout : 2000, //2000ms = 2s;
							autoplayHoverPause : true,
						});
					</script>

				</div>
			</div>

		</section>
		<!-- comment -->
		<section id="comments_review">
			<div class="container">
				<h2>ĐÁNH GIÁ</h2>
				<div class="box d-flex">
					<div class="rating_section col-lg-5 d-flex me-3">
						<p class="col-md-7 rating">
							<span class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span>
						</p>
						<p class="big-size col-md-5">4.7</p>
					</div>
					<div class="comments col-md-7">
						<div class="comment d-flex">
							<div class="avata">
								<canvas id="canvas0" width="50" height="50"></canvas>
							</div>
							<div class="content ml-3">
								<div class="d-flex">
									<div class="name_avata">
										<h5 id="idName0">An</h5>
									</div>
									<div class="num_rating">
										<span>4</span> <span class="fa fa-star checked"></span>
									</div>
								</div>
								<p class="cmt_content">Khá tốt! Sản phẩm phù hợp với túi
									tiền, thoáng mát.</p>
							</div>
						</div>
						<div class="comment d-flex">
							<div class="avata">
								<canvas id="canvas1" width="50" height="50"></canvas>
							</div>
							<div class="content ml-3">
								<div class="d-flex">
									<div class="name_avata">
										<h5 id="idName1">Bình</h5>
									</div>
									<div class="num_rating">
										<span>5</span> <span class="fa fa-star checked"></span>
									</div>
								</div>
								<p class="cmt_content">Rất thoải mái</p>
							</div>
						</div>
						<div class="comment d-flex">
							<div class="avata">
								<canvas id="canvas2" width="50" height="50"></canvas>
							</div>
							<div class="content ml-3">
								<div class="d-flex">
									<div class="name_avata">
										<h5 id="idName2">Mai</h5>
									</div>
									<div class="num_rating">
										<span>5</span> <span class="fa fa-star checked"></span>
									</div>
								</div>
								<p class="cmt_content">Được</p>
							</div>
						</div>
					</div>
				</div>
				<!-- </div> -->
				<script>
					$(function() {
						$user_name = $("#idName0").text().substr(0, 1)
								.toUpperCase();
						var canvas = document.getElementById("canvas0");
						var context = canvas.getContext("2d");

						var x = canvas.width / 2;
						var y = canvas.height / 2;

						context.rect(0, 0, 50, 50);
						context.fillStyle = "#333";
						context.fill();

						context.font = "30px RobotoBold";
						context.textAlign = "center";
						context.fillStyle = "white";
						context.fillText($user_name, x, y + 10);
					});
					$(function() {
						$user_name = $("#idName1").text().substr(0, 1)
								.toUpperCase();
						var canvas = document.getElementById("canvas1");
						var context = canvas.getContext("2d");

						var x = canvas.width / 2;
						var y = canvas.height / 2;

						context.rect(0, 0, 50, 50);
						context.fillStyle = "#333";
						context.fill();

						context.font = "30px RobotoBold";
						context.textAlign = "center";
						context.fillStyle = "white";
						context.fillText($user_name, x, y + 10);
					});
					$(function() {
						$user_name = $("#idName2").text().substr(0, 1)
								.toUpperCase();
						var canvas = document.getElementById("canvas2");
						var context = canvas.getContext("2d");

						var x = canvas.width / 2;
						var y = canvas.height / 2;

						context.rect(0, 0, 50, 50);
						context.fillStyle = "#333";
						context.fill();

						context.font = "30px RobotoBold";
						context.textAlign = "center";
						context.fillStyle = "white";
						context.fillText($user_name, x, y + 10);
					});
				</script>
		</section>
	</main>


	<!-- footer -->
	<%@ include file="footer.jsp"%>

	<!-- js -->
	<!-- xử lý  -->

	<script>
		var coll = document.getElementsByClassName("collapsible");
		var i;

		for (i = 0; i < coll.length; i++) {
			coll[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var content = this.nextElementSibling;
				if (content.style.display === "block") {
					content.style.display = "none";
				} else {
					content.style.display = "block";
				}
			});
		}
	</script>



</body>

</html>