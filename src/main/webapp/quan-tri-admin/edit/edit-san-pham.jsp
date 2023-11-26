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
    <div class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
      <ul>
        <li>Admin</li>
        <li>Chỉnh sửa phẩm mới</li>
      </ul>

    </div>
  </section>

  <section class="is-hero-bar">
    <div class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
      <h1 class="title">
        Chỉnh sửa sản phẩm
      </h1>

    </div>
  </section>
  <c:forEach items="${listProduct}" var="p">
    <section class="section main-section">
      <div class="card mb-6">
        <header class="card-header">
          <p class="card-header-title">
            <span class="icon"><i class="mdi mdi-ballot"></i></span>
            Chỉnh sửa sản phẩm ${msg}
          </p>
        </header>
        <div class="card-content">
          <form action="/edit-product" method="POST">
          <%-- <form action="/edit-product" method="POST" enctype="multipart/form-data"> --%>
            <div class="field">
              <div class="field-body row">
                <div class="field col-lg-12">
                  <div class="control icons-left">
                      <%--                  name-product --%>
                    <input class="input" type="text" placeholder="Tên sản phẩm" name="name" required value="${p.title}">
                    <span class="icon left"><i class="mdi mdi-table"></i></span>
                  </div>
                </div>
                <div class="field col-lg-6">
                  <div class="control icons-left">
                      <%--                  id-product --%>
                    <input class="input" type="text" placeholder="Mã sản phẩm" name="sku" required value="${p.sku}">
                  </div>
                </div>
                <div class="field col-lg-6">
                  <div class="field-body">
                    <div class="field">
                      <div class="field addons">
                        <div class="control expanded">
                          <input class="input" type="text" placeholder="Số lượng sản phẩm" name="qty" required  value="${p.quantity}">
                        </div>
                      </div>
                      <p class="help">Không nhập số 0 đầu tiên</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="field row">
              <div class="control col col-lg-4">
                <div class="select">
                  <label class="label">Danh mục sản phẩm:</label>
                  <select name="cate">
                    <option value="${idCate}">${nameCate}</option>
                    <c:forEach items="${listCate}" var="category">
                      <option value="${category.idcategory}">${category.title}</option>
                    </c:forEach>
                  </select>
                </div>
              </div>
              <div class="control col col-lg-4">
                <div class="select">
                  <label class="label">Chất liệu sản phẩm</label>
                  <select name="material">
                    <option value="${idM}">${nameM}</option>
                    <c:forEach items="${listMaterial}" var="m">
                      <option value="${m.idmaterial}">${m.title}</option>
                    </c:forEach>
                  </select>
                </div>
              </div>
              <div class="control col col-lg-4">
                <div class="select">
                  <label class="label">Màu sản phẩm</label>
                  <select name="color">
                    <option value="${idColor}">${nameColor}</option>
                    <c:forEach items="${listColor}" var="color">
                      <option value="${color.idcolor}">${color.title}</option>
                    </c:forEach>
                  </select>
                </div>
              </div>
            </div>
            <hr>
            <div class="field-body row">
              <div class="field col-lg-6">
                <label class="label">Giá (Ví dụ: 1000000)</label>
                <div class="control">
                  <input class="input" type="text" placeholder="Giá sản phẩm (VND)" name="price" required value="<fmt:formatNumber type="number" maxFractionDigits="3" value="${p.price}"/>">
                </div>
                <br>
                <div class="control">
                  <input class="input" type="text" placeholder="Giá khuyến mãi (VND)" name="discount" required value="<fmt:formatNumber type="number" maxFractionDigits="3" value="${p.discount}"/>">
                </div>
              </div>
              <div class="field col-lg-6">
                <label class="label">Mô tả sản phẩm</label>
                <div class="control">
                  <textarea class="textarea" placeholder="Sản phẩm này là ......" name="content" required>
                    ${p.content}
                  </textarea>
                </div>
              </div>
            </div>
            <hr>
            <div class="card">
              <header class="card-header">
                <p class="card-header-title">
                  <span class="icon"><i class="mdi mdi-ballot-outline"></i></span>
                  Yếu tố tuỳ chỉnh
                </p>
              </header>
              <div class="card-content row">
                <div class="field col-lg-6">
                  <label class="label">Trạng thái danh mục</label>
                  <div class="field-body">
                    <div class="field grouped multiline">
                      <div class="control">
                        <label class="radio">
                          <input type="radio" name="mode" value="1" checked="checked">
                          <span class="check"></span>
                          <span class="control-label">Mới nhất</span>
                        </label>
                      </div>
                      <div class="control">
                        <label class="radio">
                          <input type="radio" name="mode" value="2">
                          <span class="check"></span>
                          <span class="control-label">Bán chạy</span>
                        </label>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="field col-lg-6">
                  <label class="label">Hiển thị</label>
                  <div class="field-body">
                    <div class="field grouped multiline">
                      <div class="control">
                        <label class="radio">
                          <input type="radio" name="status" value="1" checked="checked">
                          <span class="check"></span>
                          <span class="control-label">Có</span>
                        </label>
                      </div>
                      <div class="control">
                        <label class="radio">
                          <input type="radio" name="status" value="0">
                          <span class="check"></span>
                          <span class="control-label">Không</span>
                        </label>
                      </div>
                    </div>
                  </div>
                </div>
                <hr>
                <div class="field col-lg-12">
                  <img src='images\products\<c:out value="${p.codecate}"/>/<c:out value="${p.image}"/>' alt="<c:out value="${p.image}"/>" width="100">
                  <label class="label">Hình ảnh</label>
                  <div class="field-body">
                    <div class="field file">
                      <div class="mb-3">
                        <label for="imgProduct" class="form-label">Upload file image product</label>
                        <input class="form-control" type="file" id="imgProduct" name="imgProduct">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="field grouped">
            	<input type="hidden" name="idproduct" value="${p.idproduct}"></input>
              <div class="control">
                <button type="submit" class="button green">
                  Cập nhật
                </button>
              </div>
              <div class="control">
                <button type="reset" class="btn btn-warning">
                  Reset
                </button>
              </div>
              <div class="control">
                <a href="/admin-products" class="button red">
                  Huỷ
                </a>
              </div>
            </div>
          </form>
        </div>
      </div>
    </section>
  </c:forEach>

</div>

<!-- Scripts below are for demo only -->
<script type="text/javascript" src="js/main.min.js?v=1628755089081"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
<script type="text/javascript" src="js/chart.sample.min.js"></script>

<script>
  !function(f,b,e,v,n,t,s)
  {if(f.fbq)return;n=f.fbq=function(){n.callMethod?
          n.callMethod.apply(n,arguments):n.queue.push(arguments)};
    if(!f._fbq)f._fbq=n;n.push=n;n.loaded=!0;n.version='2.0';
    n.queue=[];t=b.createElement(e);t.async=!0;
    t.src=v;s=b.getElementsByTagName(e)[0];
    s.parentNode.insertBefore(t,s)}(window, document,'script',
          'https://connect.facebook.net/en_US/fbevents.js');
  fbq('init', '658339141622648');
  fbq('track', 'PageView');
</script>
<noscript><img height="1" width="1" style="display:none" src="https://www.facebook.com/tr?id=658339141622648&ev=PageView&noscript=1"/></noscript>

<!-- Icons below are for demo only. Feel free to use any icon pack. Docs: https://bulma.io/documentation/elements/icon/ -->
<link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.9.95/css/materialdesignicons.min.css">

</body>
</html>
