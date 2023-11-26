<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" class="">
<head>
  <title>Sản phẩm - Admin G15</title>
</head>
<body>
	<div id="app">

		<!-- header -->
		<%@ include file="/quan-tri-admin/header-admin.jsp"%>

		<section class="is-title-bar">
			<div
				class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
				<ul>
					<li>Admin</li>
					<li>Sản phẩm</li>
				</ul>

			</div>
		</section>
		<!-- Noi dung -->
		<section class="is-hero-bar">
			<div
				class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
				<h1 class="title">Bảng sản phẩm</h1>
				<!-- Nut Them -->
				<a href="./add-product" class="button blue"> <span class="icon"><i
						class="mdi mdi-credit-card-plus"></i></span> <span>Thêm mới</span>
				</a>
				<!--  -->
			</div>
		</section>

		<section class="section main-section">
			<div class="navbar-item">
				<div class="control" style="width: 50%">
					<form id="searchBox" action="./search-p-ajax" method="get">
						<div class="form-group d-flex">
							<input type="text" name="txtSearch" class="form-control"
								placeholder="Bạn cần tìm..." aria-describedby="helpId"
								oninput="searchByName(this)" />
							<button type="submit" class="btn btn-primary mx-2">Tìm</button>
						</div>
					</form>
				</div>
			</div>
			<div class="row justify-content-between mb-3">
				<div class="col col-lg-4 col-sm-4 text-end">
					<div class="dropdown">
						<a class="btn btn-light border mx-1 dropdown-toggle" href="#"
							role="button" id="dropdownMenuPrice" data-bs-toggle="dropdown"
							aria-expanded="false" style="width: 100%"> Xem ${views}
							Dòng/Trang </a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuPrice"
							style="width: 100%">
							<li><a class="dropdown-item"
								href="${urlPatterns}?views=<c:out value="${total}"/>">Xem
									Tất cả</a></li>
							<li><a class="dropdown-item" href="${urlPatterns}?views=10">Xem
									10 Dòng/Trang</a></li>
							<li><a class="dropdown-item" href="${urlPatterns}?views=50">Xem
									50 Dòng/Trang</a></li>
							<li><a class="dropdown-item" href="${urlPatterns}?views=80">Xem
									80 Dòng/Trang</a></li>
							<li><a class="dropdown-item" href="${urlPatterns}?views=110">Xem
									110 Dòng/Trang</a></li>
						</ul>
					</div>
				</div>
				<div class="col col-lg-8 col-sm-8">
					<div class="row justify-content-end">
						<div class="col col-lg-3 col-sm-6">
							<div class="dropdown">
								<a class="btn btn-light border mx-1 dropdown-toggle" href="#"
									role="button" id="dropdownMenuCate" data-bs-toggle="dropdown"
									aria-expanded="false" style="width: 100%"> ${nameCode} </a>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenuCate"
									style="width: 100%">
									<c:forEach items="${listCate}" var="category">
										<li><a class="dropdown-item"
											href="?code=${category.codecate}"> ${category.title} </a></li>
									</c:forEach>
								</ul>
							</div>
						</div>
						<div class="col col-lg-3 col-sm-6">
							<div class="dropdown">
								<a class="btn btn-light border mx-1 dropdown-toggle" href="#"
									role="button" id="dropdownMenuSort" data-bs-toggle="dropdown"
									aria-expanded="false" style="width: 100%"> ${nameSort} </a>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenuSort"
									style="width: 100%">
									<li><a class="dropdown-item"
										href="${urlPatterns}?sort=desc">Giá cao đến thấp</a></li>
									<li><a class="dropdown-item"
										href="${urlPatterns}?sort=asc">Giá thấp đến cao</a></li>
									<li><a class="dropdown-item"
										href="${urlPatterns}?sort=discount">Giá khuyến mãi</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br>
			<%--      top bar product--%>
			<div class="notification blue">
				<div
					class="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0">
					<div class="col col-lg-8">
						<span class="icon"><i class="mdi mdi-buffer"></i></span> <b>Bảng
							sản phẩm</b>
					</div>
					<div class="col col-lg-2">
						<strong>${count}/${total} sản phẩm</strong>
					</div>
					<div class="col col-lg-2">
						<ul
							class="pages d-flex justify-content-end align-items-center mt-3">
							<li class="mx-1"><c:if test="${tag==1}">
									<a href='${urlPatterns}?page=1<c:out value="${contentPara}"/>'
										class="btn btn-light"><i class="fas fa-caret-left"></i></a>
								</c:if> <c:if test="${tag>1}">
									<a
										href='${urlPatterns}?page=${tag-1}<c:out value="${contentPara}"/>'
										class="btn btn-dark"><i class="fas fa-caret-left"></i></a>
								</c:if></li>
							<li class="mx-1"><strong>${tag}</strong>/${endP}</li>
							<li class="mx-1"><c:if test="${tag<endP}">
									<a
										href='${urlPatterns}?page=${tag+1}<c:out value="${contentPara}"/>'
										class="btn btn-dark"><i class="fas fa-caret-right"></i></a>
								</c:if> <c:if test="${tag==endP}">
									<a
										href='${urlPatterns}?page=${endP}<c:out value="${contentPara}"/>'
										class="btn btn-light"><i class="fas fa-caret-right"></i></a>
								</c:if></li>
						</ul>
					</div>
				</div>
			</div>
			<c:if test="${ipm==1}">
				<div class="notification red">
					<div
						class="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0">
						<div>
							<span class="icon"><i class="mdi mdi-buffer"></i></span> <b>${delnameProduct}</b>
						</div>
						<button type="button"
							class="button small textual --jb-notification-dismiss"
							onclick="hideNotify()">Dismiss</button>
					</div>
				</div>
			</c:if>

			<!-- bảng sản phẩm -->
			<div class="card has-table">
				<div class="card-content">
					<table>
						<thead>
							<tr>
								<th>Id</th>
								<th>Mã</th>
								<th>Tên</th>
								<th>Hình ảnh</th>
								<th>Ngày tạo</th>
								<th>Giá</th>
								<th>Giá giảm</th>
								<th>Thao tác</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="body-table-products">
							<c:forEach items="${listProduct}" var="p">
								<tr>
									<td data-label="Id">${p.idproduct}</td>
									<td data-label="Ma">${p.sku}</td>
									<td data-label="Name">${p.title}</td>
									<td data-label="Image"><img
										src='images\products\<c:out value="${p.codecate}"/>/<c:out value="${p.image}"/>'
										alt="<c:out value="${p.image}"/>" width="100"></td>
									<td data-label="Status">${p.startAt}</td>
									<td data-label="Price"><span class="price"> <c:if
												test="${p.discount > 0}">
												<del>
													<fmt:formatNumber type="number" maxFractionDigits="3"
														value="${p.price}" />
													VND
												</del>
											</c:if> <c:if test="${p.discount == 0}">
												<strong><fmt:formatNumber type="number"
														maxFractionDigits="3" value="${p.price}" /> VND</strong>
											</c:if>
									</span></td>
									<td data-label="Discount"><span class="price-sale">
											<c:if test="${p.discount > 0}">
												<strong><fmt:formatNumber type="number"
														maxFractionDigits="3" value="${p.discount}" /> VND</strong>
											</c:if> <c:if test="${p.discount == 0}">
												<span>0 VND</span>
											</c:if>
									</span></td>
									<td class="actions-cell">
										<div class="buttons right nowrap">
											<a href="/edit-product?idproduct=${p.idproduct}">
												<button class="button small green " type="button">
													<span class="icon"><i class="mdi mdi-eye"></i></span>
												</button>
											</a> <a href="?delIdproduct=${p.idproduct}">
												<button class="button small red --jb-modal"
													data-target="sample-modal">
													<span class="icon"><i class="mdi mdi-trash-can"></i></span>
												</button>
											</a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<div class="table-pagination">
						<div class="flex items-center justify-between">
							<style>
.pages .disable {
	display: none;
}

.pages .page-item a {
	border: 1px solid #333;
}
</style>
							<ul class="pages d-flex justify-content-center mt-3">
								<li class="page-item ${tag==1?"disable":"btn-light"}"><a
									href='${urlPatterns}?page=${tag-1}<c:out value="${contentPara}"/>'
									class="btn btn-light"><i class="fas fa-caret-left"></i></a></li>
								<c:forEach begin="1" end="${endP}" var="i">
									<li class="page-item mx-2"><a
										href='${urlPatterns}?page=${i}<c:out value="${contentPara}"/>'
										class="btn ${tag==i?"btn-dark":"btn-light"}">${i}</a></li>
								</c:forEach>
								<li class="page-item ${tag==endP?"disable":"btn-light"}"><a
									href='${urlPatterns}?page=${tag+1}<c:out value="${contentPara}"/>'
									class="btn btn-light"><i class="fas fa-caret-right"></i></a></li>
							</ul>
							<small>Trang <strong style="color: #333">${tag}</strong>/${endP}
							</small>
						</div>
					</div>
				</div>
			</div>

			<c:if test="${count==0}">
				<div class="card empty">
					<div class="card-content">
						<div>
							<span class="icon large"><i
								class="mdi mdi-emoticon-sad mdi-48px"></i></span>
						</div>
						<p>Không có gì ở đây.....</p>
					</div>
				</div>
			</c:if>
		</section>

	</div>



	<!-- Icons below are for demo only. Feel free to use any icon pack. Docs: https://bulma.io/documentation/elements/icon/ -->
  <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.9.95/css/materialdesignicons.min.css" />
  <!-- JS -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script>
    function searchByName(param){
      var txtSearch = param.value;
      console.log(txtSearch);
      $.ajax({
        url: "./search-p-ajax",
        type: "get",
        data:{
          txtS: txtSearch
        },
        success: function (data) {
          var row = document.getElementById("body-table-products");
          row.innerHTML = data;
        },
        error: function (xhr) {
        }
      });
    }
  </script>
</body>

</html>