<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Đơn đặt may - Admin G15</title>
  
  
  
  
  
  
    <!-- Tailwind is included -->
    <link rel="stylesheet" href="../css/main.css?v=1628755089081" />
  
    <!-- Bootstrap core CSS -->
  
    <link rel="stylesheet" href="../css/admin.css" />
  
  
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

<nav id="navbar-main" class="navbar is-fixed-top">
  <div class="navbar-brand">
    <a class="navbar-item mobile-aside-button">
      <span class="icon"><i class="mdi mdi-forwardburger mdi-24px"></i></span>
    </a>
   
  </div>
  <div class="navbar-brand is-right">
    <a class="navbar-item --jb-navbar-menu-toggle" data-target="navbar-menu">
      <span class="icon"><i class="mdi mdi-dots-vertical mdi-24px"></i></span>
    </a>
  </div>
  <div class="navbar-menu" id="navbar-menu">
    <div class="navbar-end">
      
      <div class="navbar-item dropdown has-divider has-user-avatar">
        <a class="navbar-link">
          <div class="user-avatar">
            <a href="profile.jsp" class="rounded-full">
              <span class="icon"><i class="mdi mdi-account"></i></span>
              <span>Thông tin tài khoản</span>
            </a>
          </div>
         
        </a>
     
       
      </div>
      <a href="https://justboil.me/tailwind-admin-templates" class="navbar-item has-divider desktop-icon-only">
        <span class="icon"><i class="mdi mdi-help-circle-outline"></i></span>
        <span>Chi tiết</span>
      </a>
      <a href="https://github.com/justboil/admin-one-tailwind" class="navbar-item has-divider desktop-icon-only">
        <span class="icon"><i class="mdi mdi-github-circle"></i></span>
        <span>GitHub</span>
      </a>
      
      <a title="Đăng xuất" class="navbar-item desktop-icon-only">
        <span class="icon"><i class="mdi mdi-logout"></i></span>
        <span>Đăng xuất</span>
      </a>
    </div>
  </div>
</nav>

<!-- menu -->
<aside class="aside is-placed-left is-expanded">
  <div class="aside-tools">
    <div>
      Admin <b class="font-black">G15</b>
    </div>
  </div>
  <div class="menu is-menu-main">
   
    <ul class="menu-list">
      <li class="--set-active-index-html">
        <a href="../index.jsp">
          <span class="icon"><i class="mdi mdi-desktop-mac"></i></span>
          <span class="menu-item-label">Trang chủ</span>
        </a>
      </li>
    </ul>
   
    <ul class="menu-list">
      <!-- Nguoi dung -->
      <li class="--set-active-customers-html">
        <a href="../khach-hang.jsp">
          <span class="icon"><i class="mdi mdi-account-group-outline"></i></span>
          <span class="menu-item-label">Khách hàng</span>
        </a>
      </li>
      <!--  -->
      <!-- Danh muc -->
      <li class="--set-active-tables-html">
        <a href="../danh-muc.jsp">
          <span class="icon"><i class="mdi mdi-table"></i></span>
          <span class="menu-item-label">Danh mục</span>
        </a>
      </li>
      <!-- -->

      <!-- San pham -->
      <li class="--set-active-products-html">
        <a href="../san-pham.jsp">
          <span class="icon"><i class="mdi mdi-table"></i></span>
          <span class="menu-item-label">Sản phẩm</span>
        </a>
      </li>
      <!--  -->
       <!-- Voucher-->
       <li class="--set-active-voucher-html">
        <a href="../voucher.jsp">
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
            <a href="../don-hang/ql-don-may-san.jsp">
              <span>Đơn may sẵn</span>
            </a>
          </li>
          <li>
            <a href="../don-hang/ql-don-dat-may.jsp">
              <span>Đơn đặt may</span>
            </a>
          </li>
        </ul>
      </li>

      <li >
        <a class="dropdown">
          <span class="icon"><i class="mdi mdi-view-list"></i></span>
          <span class="menu-item-label">Bài viết</span>
          <span class="icon"><i class="mdi mdi-plus"></i></span>
        </a>
        <ul>
          <li>
            <a href="../bai-viet/gioi-thieu.jsp">
              <span>Giới thiệu</span>
            </a>
          </li>
          <li>
            <a href="../bai-viet/tin-tuc.jsp">
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
            <a href="../thongtin-cuahang/logo.jsp">
              <span>Logo</span>
            </a>
          </li>
          <li>
            <a href="../thongtin-cuahang/banner.jsp">
              <span>Banner</span>
            </a>
          </li>
          <li>
            <a href="../thongtin-cuahang/bieu-tuong.jsp">
              <span>Biểu tượng</span>
            </a>
          </li>
          <li>
            <a href="../thongtin-cuahang/mangxh-login-register.jsp">
              <span>Mạng xã hội</span>
            </a>
          </li>
          <li>
            <a href="../thongtin-cuahang/lien-he.jsp">
              <span>Liên hệ</span>
            </a>
          </li>
          <li>
            <a href="../thongtin-cuahang/footer.jsp">
              <span>Footer</span>
            </a>
          </li>
          <li>
            <a href="../thongtin-cuahang/cauhinhchung.jsp">
              <span>Cấu hình chung</span>
            </a>
          </li>
          <li>
            <a href="../thongtin-cuahang/gmail.jsp">
              <span>Gửi gmail</span>
            </a>
          </li>
          <!-- <li>
      <a href="bai-viet/gioi-thieu.jsp">
        <span>Giới thiệu</span>
      </a>
    </li>
    <li>
      <a href="bai-viet/tin-tuc.jsp">
        <span>Tin Tức</span>
      </a>
    </li> -->
        </ul>
      </li>
      <!--  -->

      <!-- Binh luận -->
      <li class="--set-active-cmt-html">
        <a href="../binh-luan.jsp">
          <span class="icon"><i class="mdi mdi-comment-text-multiple"></i></span>
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
          Thêm sản phẩm mới
        </p>
      </header>
      <div class="card-content">
        <form method="get">
          <div class="field">
            <label class="label">Từ</label>
            <div class="field-body">
              <div class="field">
                <div class="control icons-left">
                  <input class="input" type="text" placeholder="Tên danh mục ">
                  <span class="icon left"><i class="mdi mdi-table"></i></span>
                </div>
              </div>
           
            </div>
          </div>
         
         
          <hr>
         

          <!-- Mô tả danh mục -->
          <div class="field">
            <label class="label">Mô tả danh mục</label>
            <div class="control">
              <textarea class="textarea" placeholder="Sản phẩm này là ......"></textarea>
            </div>
          </div>
          <div class="card">
            <header class="card-header">
              <p class="card-header-title">
                <span class="icon"><i class="mdi mdi-ballot-outline"></i></span>
                Yếu tố tuỳ chỉnh
              </p>
            </header>
            <div class="card-content">
              <div class="field">
                <label class="label">Trạng thái sản phẩm</label>
                <div class="field-body">
                  <div class="field grouped multiline">
                    <div class="control">
                      <label class="checkbox"><input type="checkbox" value="lorem" checked>
                        <span class="check"></span>
                        <span class="control-label">Xuất bản</span>
                      </label>
                    </div>
                    <div class="control">
                      <label class="checkbox"><input type="checkbox" value="ipsum">
                        <span class="check"></span>
                        <span class="control-label">Lưu nháp</span>
                      </label>
                    </div>
                    <!-- <div class="control">
                      <label class="checkbox"><input type="checkbox" value="dolore">
                        <span class="check is-primary"></span>
                        <span class="control-label">Dolore</span>
                      </label>
                    </div> -->
                  </div>
                </div>
              </div>
              <hr>
              <div class="field">
                <label class="label">Hiển thị</label>
                <div class="field-body">
                  <div class="field grouped multiline">
                    <div class="control">
                      <label class="radio">
                        <input type="radio" name="sample-radio" value="one" checked>
                        <span class="check"></span>
                        <span class="control-label">Có</span>
                      </label>
                    </div>
                    <div class="control">
                      <label class="radio">
                        <input type="radio" name="sample-radio" value="two">
                        <span class="check"></span>
                        <span class="control-label">Không</span>
                      </label>
                    </div>
                  </div>
                </div>
              </div>
              <hr>
        
            </div>
          </div>
          <hr>

          <div class="field grouped">
            <div class="control">
              <button type="submit" class="button green">
                Tạo danh mục
              </button>
            </div>
            <div class="control">
              <button type="reset" class="button red">
                Xoá tất cả nội dung
              </button>
            </div>
            <div class="control">
              <button type="reset" class="button red">
                Huỷ
              </button>
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

<!-- <div id="sample-modal" class="modal">
  <div class="modal-background --jb-modal-close"></div>
  <div class="modal-card">
    <header class="modal-card-head">
      <p class="modal-card-title">Sample modal</p>
    </header>
    <section class="modal-card-body">
      <p>Lorem ipsum dolor sit amet <b>adipiscing elit</b></p>
      <p>This is sample modal</p>
    </section>
    <footer class="modal-card-foot">
      <button class="button --jb-modal-close">Cancel</button>
      <button class="button red --jb-modal-close">Confirm</button>
    </footer>
  </div>
</div>

<div id="sample-modal-2" class="modal">
  <div class="modal-background --jb-modal-close"></div>
  <div class="modal-card">
    <header class="modal-card-head">
      <p class="modal-card-title">Sample modal</p>
    </header>
    <section class="modal-card-body">
      <p>Lorem ipsum dolor sit amet <b>adipiscing elit</b></p>
      <p>This is sample modal</p>
    </section>
    <footer class="modal-card-foot">
      <button class="button --jb-modal-close">Cancel</button>
      <button class="button blue --jb-modal-close">Confirm</button>
    </footer>
  </div>
</div> -->

</div>

<!-- Scripts below are for demo only -->
<script type="text/javascript" src="../js/main.min.js?v=1628755089081"></script>


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
