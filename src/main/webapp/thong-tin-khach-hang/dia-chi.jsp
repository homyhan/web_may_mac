<%@page import="helper.Contants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="model.Address"%>
<%@ page import="model.User"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

						<!-- Thông tin địa chỉ-->

						<h1 class="text-center mb-3">Thông tin tài khoản</h1>

						<p>Bạn muốn giao hàng đến địa chỉ khác?</p>
						<button class="btn btn-dark">
							<a href="../thong-tin-khach-hang/them-dia-chi-moi.jsp"> Thêm
								địa chỉ mới </a>

						</button>
						<%
						if (request.getAttribute("addressList") != null) {
							List<Address> result = (ArrayList<Address>) request.getAttribute("addressList");
							for (int i = 0; i < result.size(); i++) {
						%>
						<div class="content_box_profile_page">
							<div class="row">
								<div
									class="col-lg-12 col-md-6 col-sm-6 item-address space_bottom_10">
									<div class="item_sodiachi relative width_common "
										id="item_sodiachi_3681403">
										<div class="row">
											<div class="name_diachi space_bottom_5">
												<strong><%=result.get(i).getName()%></strong> - <%=result.get(i).getPhone()%>
											</div>
											<div class="default space_bottom_5">
												<span role="mark" class="default-color"><%=result.get(i).getIsdefault()== 1 ? "Mặc định" : ""%></span>
											</div>
										</div>

										<div class="address_diachi"><%=result.get(i).getAddress()%></div>

										<div claa="row">

											<button class="btn btn-dark" disabled="">Thiết lập
												mặc định</button>

											<button class="btn btn-dark">
												<a href="../thong-tin-khach-hang/them-dia-chi-moi.jsp">
													Chỉnh sửa </a>


											</button>
											<button class="btn btn-dark">Xóa</button>
										</div>

									</div>
								</div>

							</div>
							<div class="clearfix"></div>
						</div>

						<%
						}
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