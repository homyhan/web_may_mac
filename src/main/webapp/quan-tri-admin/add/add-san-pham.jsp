<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" class="">

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Sản phẩm - Admin G15</title>

  <!-- Tailwind is included -->
  <link rel="stylesheet" href="css/main.css?v=1628755089081" />
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="css/admin.css" />

  <link rel="apple-touch-icon" sizes="180x180" href="apple-touch-icon.png" />
  <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png" />
  <link rel="icon" type="image/png" sizes="16x16" href="favicon-16x16.png" />
  <link rel="mask-icon" href="safari-pinned-tab.svg" color="#00b4b6" />

  <meta name="description" content="Admin One - free Tailwind dashboard" />

  <meta property="og:url" content="https://justboil.github.io/admin-one-tailwind/" />
  <meta property="og:site_name" content="JustBoil.me" />
  <meta property="og:title" content="Admin One HTML" />
  <meta property="og:description" content="Admin One - free Tailwind dashboard" />
  <meta property="og:image" content="https://justboil.me/images/one-tailwind/repository-preview-hi-res.png" />
  <meta property="og:image:type" content="image/png" />
  <meta property="og:image:width" content="1920" />
  <meta property="og:image:height" content="960" />

  <meta property="twitter:card" content="summary_large_image" />
  <meta property="twitter:title" content="Admin One HTML" />
  <meta property="twitter:description" content="Admin One - free Tailwind dashboard" />
  <meta property="twitter:image:src" content="https://justboil.me/images/one-tailwind/repository-preview-hi-res.png" />
  <meta property="twitter:image:width" content="1920" />
  <meta property="twitter:image:height" content="960" />

  <!-- Global site tag (gtag.js) - Google Analytics -->
  <script async src="https://www.googletagmanager.com/gtag/js?id=UA-130795909-1"></script>
  <script>
    window.dataLayer = window.dataLayer || [];
    function gtag() {
      dataLayer.push(arguments);
    }
    gtag("js", new Date());
    gtag("config", "UA-130795909-1");
  </script>
</head>


<body>

<div id="app">
  <jsp:include page="../header-admin.jsp"></jsp:include>

  <aside class="aside is-placed-left is-expanded">
    <div class="aside-tools">
      <div>
        Admin <b class="font-black">G15</b>
      </div>
    </div>
    <div class="menu is-menu-main">

      <ul class="menu-list">
        <li class="--set-active-index-html">
          <a href="index.html">
            <span class="icon"><i class="mdi mdi-desktop-mac"></i></span>
            <span class="menu-item-label">Trang chủ</span>
          </a>
        </li>
      </ul>

      <ul class="menu-list">
        <!-- Nguoi dung -->
        <li class="--set-active-customers-html">
          <a href="khach-hang.html">
            <span class="icon"><i class="mdi mdi-account-group-outline"></i></span>
            <span class="menu-item-label">Khách hàng</span>
          </a>
        </li>
        <!--  -->
        <!-- Danh muc -->
        <li class="--set-active-tables-html">
          <a href="danh-muc.html">
            <span class="icon"><i class="mdi mdi-format-list-bulleted"></i></span>
            <span class="menu-item-label">Danh mục</span>
          </a>
        </li>
        <!-- -->

        <!-- San pham -->
        <li class="--set-active-products-html">
          <a href="san-pham.html">
            <span class="icon"><i class="mdi mdi-table"></i></span>
            <span class="menu-item-label">Sản phẩm</span>
          </a>
        </li>
        <!--  -->
        <!-- Voucher-->
        <li class="--set-active-voucher-html">
          <a href="voucher.html">
            <span class="icon"><i class="mdi mdi-sale"></i></span>
            <span class="menu-item-label">Phiếu giảm giá</span>
          </a>
        </li>
        <!--  -->
        <!-- Don hang -->
        <li>
          <a class="dropdown">
            <span class="icon"><i class="mdi mdi-view-list"></i></span>
            <span class="menu-item-label">Đơn hàng</span>
            <span class="icon"><i class="mdi mdi-plus"></i></span>
          </a>
          <ul>
            <li>
              <a href="don-hang/ql-don-may-san.html">
                <span>Đơn may sẵn</span>
              </a>
            </li>
            <li>
              <a href="don-hang/ql-don-dat-may.html">
                <span>Đơn đặt may</span>
              </a>
            </li>
          </ul>
        </li>

        <li class="--set-active-bv-html">
          <a class="dropdown">
            <span class="icon"><i class="mdi mdi-view-list"></i></span>
            <span class="menu-item-label">Bài viết</span>
            <span class="icon"><i class="mdi mdi-plus"></i></span>
          </a>
          <ul>
            <li>
              <a href="bai-viet/gioi-thieu.html">
                <span>Giới thiệu</span>
              </a>
            </li>
            <li>
              <a href="bai-viet/tin-tuc.html">
                <span>Tin tức</span>
              </a>
            </li>
          </ul>
        </li>
        <!-- Thong tin cua hang -->
        <li>
          <a class="dropdown">
            <span class="icon"><i class="mdi mdi-view-list"></i></span>
            <span class="menu-item-label">Thông tin cửa hàng</span>
            <span class="icon"><i class="mdi mdi-plus"></i></span>
          </a>
          <ul>
            <li>
              <a href="thongtin-cuahang/logo.html">
                <span>Logo</span>
              </a>
            </li>
            <li>
              <a href="thongtin-cuahang/banner.html">
                <span>Banner</span>
              </a>
            </li>
            <li>
              <a href="thongtin-cuahang/bieu-tuong.html">
                <span>Biểu tượng</span>
              </a>
            </li>
            <li>
              <a href="thongtin-cuahang/mangxh-login-register.html">
                <span>Mạng xã hội</span>
              </a>
            </li>
            <li>
              <a href="thongtin-cuahang/lien-he.html">
                <span>Liên hệ</span>
              </a>
            </li>
            <li>
              <a href="thongtin-cuahang/footer.html">
                <span>Footer</span>
              </a>
            </li>
            <li>
              <a href="thongtin-cuahang/cauhinhchung.html">
                <span>Cấu hình chung</span>
              </a>
            </li>
            <li>
              <a href="thongtin-cuahang/gmail.html">
                <span>Gửi gmail</span>
              </a>
            </li>
            <!-- <li>
        <a href="bai-viet/gioi-thieu.html">
          <span>Giới thiệu</span>
        </a>
      </li>
      <li>
        <a href="bai-viet/tin-tuc.html">
          <span>Tin Tức</span>
        </a>
      </li> -->
          </ul>
        </li>
        <!--  -->

        <!-- Binh luận -->
        <li class="--set-active-cmt-html">
          <a href="binh-luan.html">
            <span class="icon"><i class="mdi mdi-table"></i></span>
            <span class="menu-item-label">Bình luận</span>
          </a>
        </li>
        <!--  -->
      </ul>


    </div>
  </aside>

  <section class="is-title-bar">
    <div class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
      <ul>
        <li>Admin</li>
        <li>Thêm sản phẩm mới</li>
      </ul>

    </div>
  </section>

  <section class="is-hero-bar">
    <div class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
      <h1 class="title">
        Thêm sản phẩm mới
      </h1>

    </div>
  </section>

  <section class="section main-section">
    <div class="card mb-6">
      <header class="card-header">
        <p class="card-header-title">
          <span class="icon"><i class="mdi mdi-ballot"></i></span>
          Thêm sản phẩm mới ${msg}
        </p>
      </header>
      <div class="card-content">
        <form action="/add-product" method="post" enctype="multipart/form-data">
          <div class="field">
            <div class="field-body row">
              <div class="field col-lg-12">
                <div class="control icons-left">
<%--                  name-product --%>
                  <input class="input" type="text" placeholder="Tên sản phẩm" name="name" required>
                  <span class="icon left"><i class="mdi mdi-table"></i></span>
                  <i>${error}</i>
                </div>
              </div>
              <div class="field col-lg-6">
                <div class="control icons-left">
<%--                  id-product --%>
                  <input class="input" type="text" placeholder="Mã sản phẩm" name="sku" required>
                  <i>${error}</i>
                </div>
              </div>
              <div class="field col-lg-6">
                <div class="field-body">
                  <div class="field">
                    <div class="field addons">
                      <div class="control expanded">
                        <input class="input" type="text" placeholder="Số lượng sản phẩm" name="qty" required>
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
                <label class="label">Danh mục sản phẩm</label>
                <select name="cate">
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
                <input class="input" type="text" placeholder="Giá sản phẩm (VND)" name="price" required>
              </div>
              <br>
              <div class="control">
                <input class="input" type="text" placeholder="Giá khuyến mãi (VND)" name="discount" required>
              </div>
            </div>
            <div class="field col-lg-6">
              <label class="label">Mô tả sản phẩm</label>
              <div class="control">
                <textarea class="textarea" placeholder="Sản phẩm này là ......" name="content" required></textarea>
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
            <div class="control">
              <button type="submit" class="button green">
                Tạo sản phẩm
              </button>
            </div>
            <div class="control">
              <button type="reset" class="button red">
                Xoá tất cả nội dung
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

  <footer class="footer">
    <div class="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0">
      <div class="flex items-center justify-start space-x-3">
        <div>© 2022, G15</div>
        <div>
        </div>
      </div>
    </div>
  </footer>

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
