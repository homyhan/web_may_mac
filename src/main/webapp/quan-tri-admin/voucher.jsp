<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Phiếu giảm giá - Admin G15</title>

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
    <meta property="twitter:image:src"
        content="https://justboil.me/images/one-tailwind/repository-preview-hi-res.png" />
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
                    <a href="https://justboil.me/tailwind-admin-templates"
                        class="navbar-item has-divider desktop-icon-only">
                        <span class="icon"><i class="mdi mdi-help-circle-outline"></i></span>
                        <span>Chi tiết</span>
                    </a>
                    <a href="https://github.com/justboil/admin-one-tailwind"
                        class="navbar-item has-divider desktop-icon-only">
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

        <aside class="aside is-placed-left is-expanded">
            <div class="aside-tools">
                <div>Admin <b class="font-black">G15</b></div>
            </div>
            <div class="menu is-menu-main">
                <ul class="menu-list">
                    <li class="--set-active-customers-html">
                        <a href="index.jsp">
                            <span class="icon"><i class="mdi mdi-desktop-mac"></i></span>
                            <span class="menu-item-label">Trang chủ</span>
                        </a>
                    </li>
                </ul>

                <ul class="menu-list">
                    <!-- Nguoi dung -->
                    <li class="--set-active-cus-html">
                        <a href="khach-hang.jsp">
                            <span class="icon"><i class="mdi mdi-account-group-outline"></i></span>
                            <span class="menu-item-label">Khách hàng</span>
                        </a>
                    </li>
                    <!--  -->
                    <!-- Danh muc -->
                    <li class="--set-active-tables-html">
                        <a href="danh-muc.jsp">
                            <span class="icon"><i class="mdi mdi-format-list-bulleted"></i></span>
                            <span class="menu-item-label">Danh mục</span>
                        </a>
                    </li>
                    <!-- -->

                    <!-- San pham -->
                    <li class="--set-active-products-html">
                        <a href="san-pham.jsp">
                            <span class="icon"><i class="mdi mdi-table"></i></span>
                            <span class="menu-item-label">Sản phẩm</span>
                        </a>
                    </li>
                    <!--  -->
                    <!-- Voucher-->
                    <li class="active">
                        <a href="voucher.jsp">
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
                                <a href="don-hang/ql-don-may-san.jsp">
                                    <span>Đơn may sẵn</span>
                                </a>
                            </li>
                            <li>
                                <a href="don-hang/ql-don-dat-may.jsp">
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
                                <a href="bai-viet/gioi-thieu.jsp">
                                    <span>Giới thiệu</span>
                                </a>
                            </li>
                            <li>
                                <a href="bai-viet/tin-tuc.jsp">
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
                                <a href="thongtin-cuahang/logo.jsp">
                                    <span>Logo</span>
                                </a>
                            </li>
                            <li>
                                <a href="thongtin-cuahang/banner.jsp">
                                    <span>Banner</span>
                                </a>
                            </li>
                            <li>
                                <a href="thongtin-cuahang/bieu-tuong.jsp">
                                    <span>Biểu tượng</span>
                                </a>
                            </li>
                            <li>
                                <a href="thongtin-cuahang/mangxh-login-register.jsp">
                                    <span>Mạng xã hội</span>
                                </a>
                            </li>
                            <li>
                                <a href="thongtin-cuahang/lien-he.jsp">
                                    <span>Liên hệ</span>
                                </a>
                            </li>
                            <li>
                                <a href="thongtin-cuahang/footer.jsp">
                                    <span>Footer</span>
                                </a>
                            </li>
                            <li>
                                <a href="thongtin-cuahang/cauhinhchung.jsp">
                                    <span>Cấu hình chung</span>
                                </a>
                            </li>
                            <li>
                                <a href="thongtin-cuahang/gmail.jsp">
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
                        <a href="binh-luan.jsp">
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
                    <li>Phiếu giảm giá</li>
                </ul>

            </div>
        </section>
        <!-- Noi dung -->
        <section class="is-hero-bar">
            <div class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
                <h1 class="title">
                    Bảng phiếu giảm giá
                </h1>
                <!-- Nut Them -->
                <a href="add.jsp" class="button blue">
                    <span class="icon"><i class="mdi mdi-credit-card-plus"></i></span>
                    <span>Thêm mới</span>
                </a>
                <!--  -->
            </div>
        </section>

        <section class="section main-section">
            <div class="navbar-item">
                <div class="control">
                    <input placeholder="Tìm kiếm..." class="input" />
                </div>
            </div>
            <div class="notification blue">
                <div class="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0">
                    <div>
                        <span class="icon"><i class="mdi mdi-buffer"></i></span>
                        <b>Bảng phiếu giảm giá</b>
                    </div>
                    <button type="button" class="button small textual --jb-notification-dismiss">Bỏ qua</button>
                </div>
            </div>
            <div class="card has-table">
                <header class="card-header">
                    <p class="card-header-title">
                        <span class="icon"><i class="mdi mdi-sale"></i></span>
                        Phiếu giảm giá
                    </p>
                    <a href="#" class="card-header-icon">
                        <span class="icon"><i class="mdi mdi-reload"></i></span>
                    </a>
                </header>
                <div class="card-content">
                    <table>
                        <thead>
                            <tr>
                                <th class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </th>
                                <th class="image-cell"></th>
                                <th>Tên đăng nhập</th>
                                <th>Họ và tên</th>
                                <th>Email</th>
                                <th>Số điện thoại</th>
                                <th>Địa chỉ giao hàng</th>
                                <th>Ẩn/hiện</th>
                                <th>Thao tác</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/rebecca-bauch.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Rebecca Bauch</td>
                                <td data-label="Company">Daugherty-Daniel</td>
                                <td data-label="City">South Cory</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="79">79</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Oct 25, 2021">Oct 25, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/felicita-yundt.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Felicita Yundt</td>
                                <td data-label="Company">Johns-Weissnat</td>
                                <td data-label="City">East Ariel</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="67">67</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Jan 8, 2021">Jan 8, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/mr-larry-satterfield-v.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Mr. Larry Satterfield V</td>
                                <td data-label="Company">Hyatt Ltd</td>
                                <td data-label="City">Windlerburgh</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="16">16</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Dec 18, 2021">Dec 18, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/mr-broderick-kub.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Mr. Broderick Kub</td>
                                <td data-label="Company">Kshlerin, Bauch and Ernser</td>
                                <td data-label="City">New Kirstenport</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="71">71</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Sep 13, 2021">Sep 13, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/barry-weber.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Barry Weber</td>
                                <td data-label="Company">Schulist, Mosciski and Heidenreich</td>
                                <td data-label="City">East Violettestad</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="80">80</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Jul 24, 2021">Jul 24, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/bert-kautzer-md.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Bert Kautzer MD</td>
                                <td data-label="Company">Gerhold and Sons</td>
                                <td data-label="City">Mayeport</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="62">62</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Mar 30, 2021">Mar 30, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/lonzo-steuber.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Lonzo Steuber</td>
                                <td data-label="Company">Skiles Ltd</td>
                                <td data-label="City">Marilouville</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="17">17</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Feb 12, 2021">Feb 12, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/jonathon-hahn.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Jonathon Hahn</td>
                                <td data-label="Company">Flatley Ltd</td>
                                <td data-label="City">Billiemouth</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="74">74</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Dec 30, 2021">Dec 30, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/ryley-wuckert.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Ryley Wuckert</td>
                                <td data-label="Company">Heller-Little</td>
                                <td data-label="City">Emeraldtown</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="54">54</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Jun 28, 2021">Jun 28, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/sienna-hayes.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Sienna Hayes</td>
                                <td data-label="Company">Conn, Jerde and Douglas</td>
                                <td data-label="City">Jonathanfort</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="55">55</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Mar 7, 2021">Mar 7, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="table-pagination">
                        <div class="flex items-center justify-between">
                            <div class="buttons">
                                <button type="button" class="button active">1</button>
                                <button type="button" class="button">2</button>
                                <button type="button" class="button">3</button>
                            </div>
                            <small>Page 1 of 3</small>
                        </div>
                    </div>
                </div>
            </div>

            <div class="notification green">
                <div class="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0">
                    <div>
                        <span class="icon"><i class="mdi mdi-buffer"></i></span>
                        <b>Tightly wrapped.</b> Table header becomes card header
                    </div>
                    <button type="button" class="button small textual --jb-notification-dismiss">Dismiss</button>
                </div>
            </div>

            <div class="card has-table">
                <div class="card-content">
                    <table>
                        <thead>
                            <tr>
                                <th class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </th>
                                <th class="image-cell"></th>
                                <th>Name</th>
                                <th>Company</th>
                                <th>City</th>
                                <th>Progress</th>
                                <th>Created</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/rebecca-bauch.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Rebecca Bauch</td>
                                <td data-label="Company">Daugherty-Daniel</td>
                                <td data-label="City">South Cory</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="79">79</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Oct 25, 2021">Oct 25, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/felicita-yundt.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Felicita Yundt</td>
                                <td data-label="Company">Johns-Weissnat</td>
                                <td data-label="City">East Ariel</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="67">67</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Jan 8, 2021">Jan 8, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/mr-larry-satterfield-v.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Mr. Larry Satterfield V</td>
                                <td data-label="Company">Hyatt Ltd</td>
                                <td data-label="City">Windlerburgh</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="16">16</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Dec 18, 2021">Dec 18, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/mr-broderick-kub.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Mr. Broderick Kub</td>
                                <td data-label="Company">Kshlerin, Bauch and Ernser</td>
                                <td data-label="City">New Kirstenport</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="71">71</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Sep 13, 2021">Sep 13, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/barry-weber.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Barry Weber</td>
                                <td data-label="Company">Schulist, Mosciski and Heidenreich</td>
                                <td data-label="City">East Violettestad</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="80">80</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Jul 24, 2021">Jul 24, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/bert-kautzer-md.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Bert Kautzer MD</td>
                                <td data-label="Company">Gerhold and Sons</td>
                                <td data-label="City">Mayeport</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="62">62</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Mar 30, 2021">Mar 30, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/lonzo-steuber.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Lonzo Steuber</td>
                                <td data-label="Company">Skiles Ltd</td>
                                <td data-label="City">Marilouville</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="17">17</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Feb 12, 2021">Feb 12, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/jonathon-hahn.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Jonathon Hahn</td>
                                <td data-label="Company">Flatley Ltd</td>
                                <td data-label="City">Billiemouth</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="74">74</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Dec 30, 2021">Dec 30, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/ryley-wuckert.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Ryley Wuckert</td>
                                <td data-label="Company">Heller-Little</td>
                                <td data-label="City">Emeraldtown</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="54">54</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Jun 28, 2021">Jun 28, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="checkbox-cell">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        <span class="check"></span>
                                    </label>
                                </td>
                                <td class="image-cell">
                                    <div class="image">
                                        <img src="https://avatars.dicebear.com/v2/initials/sienna-hayes.svg"
                                            class="rounded-full">
                                    </div>
                                </td>
                                <td data-label="Name">Sienna Hayes</td>
                                <td data-label="Company">Conn, Jerde and Douglas</td>
                                <td data-label="City">Jonathanfort</td>
                                <td data-label="Progress" class="progress-cell">
                                    <progress max="100" value="55">55</progress>
                                </td>
                                <td data-label="Created">
                                    <small class="text-gray-500" title="Mar 7, 2021">Mar 7, 2021</small>
                                </td>
                                <td data-label="Hidden">
                                    <button class="button " data-target="sample-modal-2" type="button">
                                        <span class="icon"> <input class="icon" type="checkbox" id="1" name="1"
                                                value="1"></span>
                                    </button>


                                </td>
                                <td class="actions-cell">
                                    <div class="buttons right nowrap">
                                        <button class="button small red --jb-modal" data-target="sample-modal"
                                            type="button">
                                            <span class="icon"><i class="mdi mdi-trash-can"></i></span>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="table-pagination">
                        <div class="flex items-center justify-between">
                            <div class="buttons">
                                <button type="button" class="button active">1</button>
                                <button type="button" class="button">2</button>
                                <button type="button" class="button">3</button>
                            </div>
                            <small>Page 1 of 3</small>
                        </div>
                    </div>
                </div>
            </div>

            <div class="notification red">
                <div class="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0">
                    <div>
                        <span class="icon"><i class="mdi mdi-buffer"></i></span>
                        <b>Bảng trống.</b>
                    </div>
                    <button type="button" class="button small textual --jb-notification-dismiss">Dismiss</button>
                </div>
            </div>

            <div class="card empty">
                <div class="card-content">
                    <div>
                        <span class="icon large"><i class="mdi mdi-emoticon-sad mdi-48px"></i></span>
                    </div>
                    <p>Không có gì ở đây.....</p>
                </div>
            </div>
        </section>

        <!--  -->


        <footer class="footer">
            <div class="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0">
              <div class="flex items-center justify-start space-x-3">
                <div>© 2022, G15</div>
        
                <div>
        
                </div>
               
              </div>
        
        
            </div>
          </footer>

        <div id="sample-modal" class="modal">
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
        </div>
    </div>

    <!-- Scripts below are for demo only -->
    <script type="text/javascript" src="js/main.min.js?v=1628755089081"></script>

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
    <script type="text/javascript" src="js/chart.sample.min.js"></script>

    <script>
        !(function (f, b, e, v, n, t, s) {
            if (f.fbq) return;
            n = f.fbq = function () {
                n.callMethod
                    ? n.callMethod.apply(n, arguments)
                    : n.queue.push(arguments);
            };
            if (!f._fbq) f._fbq = n;
            n.push = n;
            n.loaded = !0;
            n.version = "2.0";
            n.queue = [];
            t = b.createElement(e);
            t.async = !0;
            t.src = v;
            s = b.getElementsByTagName(e)[0];
            s.parentNode.insertBefore(t, s);
        })(
            window,
            document,
            "script",
            "https://connect.facebook.net/en_US/fbevents.js"
        );
        fbq("init", "658339141622648");
        fbq("track", "PageView");
    </script>
    <noscript><img height="1" width="1" style="display: none"
            src="https://www.facebook.com/tr?id=658339141622648&ev=PageView&noscript=1" /></noscript>

    <!-- Icons below are for demo only. Feel free to use any icon pack. Docs: https://bulma.io/documentation/elements/icon/ -->
    <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.9.95/css/materialdesignicons.min.css" />
</body>

</html>