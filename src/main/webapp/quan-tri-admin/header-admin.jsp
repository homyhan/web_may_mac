<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="response.RolePermissionResponse"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html lang="en" class="">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Đơn đặt may - Admin G15</title>




<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="stylesheet" href="libs/Glider.js-master/glider.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	integrity="sha512-L7MWcK7FNPcwNqnLdZq86lTHYLdQqZaz5YcAgE+5cnGmlw8JT03QB2+oxL100UeB6RlzZLUxCGSS4/++mNZdxw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>


<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
	integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
	crossorigin="anonymous"></script>


<!-- Tailwind is included -->
<link rel="stylesheet"
	href="/quan-tri-admin/css/main.css?v=1628755089081" />

<!-- Bootstrap core CSS -->

<link rel="stylesheet" href="/quan-tri-admin/css/admin.css" />


<link rel="apple-touch-icon" sizes="180x180" href="apple-touch-icon.png" />
<link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png" />
<link rel="icon" type="image/png" sizes="16x16" href="favicon-16x16.png" />
<link rel="mask-icon" href="safari-pinned-tab.svg" color="#00b4b6" />

<meta name="description" content="Admin One - free Tailwind dashboard" />

<meta property="og:url"
	content="https://justboil.github.io/admin-one-tailwind/" />
<meta property="og:site_name" content="JustBoil.me" />
<meta property="og:title" content="Admin One HTML" />
<meta property="og:description"
	content="Admin One - free Tailwind dashboard" />
<meta property="og:image"
	content="https://justboil.me/images/one-tailwind/repository-preview-hi-res.png" />
<meta property="og:image:type" content="image/png" />
<meta property="og:image:width" content="1920" />
<meta property="og:image:height" content="960" />

<meta property="twitter:card" content="summary_large_image" />
<meta property="twitter:title" content="Admin One HTML" />
<meta property="twitter:description"
	content="Admin One - free Tailwind dashboard" />
<meta property="twitter:image:src"
	content="https://justboil.me/images/one-tailwind/repository-preview-hi-res.png" />
<meta property="twitter:image:width" content="1920" />
<meta property="twitter:image:height" content="960" />

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async
	src="https://www.googletagmanager.com/gtag/js?id=UA-130795909-1"></script>
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

			<div class="navbar-brand is-right">
				<a class="navbar-item --jb-navbar-menu-toggle"
					data-target="navbar-menu"> <span class="icon"><i
						class="mdi mdi-dots-vertical mdi-24px"></i></span>
				</a>
			</div>
			<div class="navbar-menu" id="navbar-menu">
				<div class="navbar-end">
					<div class="navbar-item dropdown has-divider has-user-avatar">
						<a class="navbar-link">
							<div class="user-avatar">
								<a href="/quan-tri-admin/profile.jsp" class="rounded-full">
									<span class="icon"><i class="mdi mdi-account"></i></span> <span>Thông
										tin tài khoản</span>
								</a>
							</div>
						</a>

					</div>
				</div>
				<a href="https://justboil.me/tailwind-admin-templates"
					class="navbar-item has-divider desktop-icon-only"> <span
					class="icon"><i class="mdi mdi-help-circle-outline"></i></span> <span>Chi
						tiết</span>
				</a> <a href="https://github.com/justboil/admin-one-tailwind"
					class="navbar-item has-divider desktop-icon-only"> <span
					class="icon"><i class="mdi mdi-github-circle"></i></span> <span>GitHub</span>
				</a> <a href="/sign-out" title="Đăng xuất"
					class="navbar-item desktop-icon-only"> <span class="icon"><i
						class="mdi mdi-logout"></i></span> <span>Đăng xuất</span>
				</a>
			</div>
	</div>
	</nav>

	<aside class="aside is-placed-left is-expanded">
		<div class="aside-tools">
			<div>
				Admin <b class="font-black">G15</b>
			</div>
		</div>
		<div class="menu is-menu-main">
			<ul class="menu-list">
				<li class="active"><a href="indexAdmin.jsp"> <span
						class="icon"><i class="mdi mdi-desktop-mac"></i></span> <span
						class="menu-item-label">Trang chủ</span>
				</a></li>
			</ul>
			<ul class="menu-list">
			<%
			if (session.getAttribute("userLogin") != null) {
			User infoUser = (User) session.getAttribute("userLogin");

			 if (session.getAttribute("permissions") != null){
				List<RolePermissionResponse> permissions = (ArrayList<RolePermissionResponse>) session.getAttribute("permissions");
				 for (int i = 0; i < permissions.size(); i++) {
					 RolePermissionResponse item = permissions.get(i);
									 
				if (item.getActionpermission().equals("product.list")){ %>
			    <!-- San pham -->
			    <li class="--set-active-products-html"><a href="/admin-products"> <span class="icon"><i
			                    class="mdi mdi-table"></i></span> <span class="menu-item-label"><%= item.getPermissionname() %></span>
			        </a></li>
			    <!--  -->
			    <% } else if (item.getActionpermission().equals("order.list")){ %>
			    <!-- Don hang -->
			    <li class="--set-active-dh-html"><a href="/admin/don-hang">
			            <span class="icon"><i class="mdi mdi-view-list"></i></span> <span class="menu-item-label"><%= item.getPermissionname() %></span>
			        </a></li>
			    <!--  -->
			    
			    <%} else if (item.getActionpermission().equals("user.list")){ %>
			    <!-- Nguoi dung -->
			    <li class="--set-active-customers-html"><a href="/admin/tai-khoan"> <span class="icon"><i
			                    class="mdi mdi-account-group-outline"></i></span> <span class="menu-item-label"><%= item.getPermissionname() %></span>
			        </a></li>
			    <!--  -->

				<%} else if (item.getActionpermission().equals("voucher.list")){ %>
				<!-- Voucher -->
				<li class="--set-active-customers-html"><a href="/admin/voucher"> <span class="icon"><i
						class="mdi mdi-account-group-outline"></i></span> <span class="menu-item-label"><%= item.getPermissionname() %></span>
				</a></li>
				<!--  -->
			    
			   	<%} else if (item.getActionpermission().equals("permission.list")){ %>
			  	 <!-- Phan quyen user -->
			    <li class="--set-active-customers-html"><a href="/admin/permision/phan-quyen-user"> <span class="icon"><i
			                    class="mdi mdi-account-group-outline"></i></span> <span class="menu-item-label"><%= item.getPermissionname() %></span>
			        </a></li>
			    <!--  -->
			    
			    <%} else if (item.getActionpermission().equals("role.list")){ %>
			  	 <!-- Phan quyen user -->
			    <li class="--set-active-customers-html"><a href="/admin/permision/phan-quyen-role"> <span class="icon"><i
			                    class="mdi mdi-account-group-outline"></i></span> <span class="menu-item-label"><%= item.getPermissionname() %></span>
			        </a></li>
			    <!--  -->
		       <%			
		       	 			}
				 		}
				 	}
				}
				%>
			</ul>

		</div>
	</aside>

	<footer class="footer">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-3 md:space-y-0">
			<div class="flex items-center justify-start space-x-3">
				<div>© 2022, G15</div>

				<div></div>

			</div>


		</div>
	</footer>

	</div>

	<!-- Scripts below are for demo only -->
	<script type="text/javascript" src="../js/main.min.js?v=1628755089081"></script>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
	<script type="text/javascript" src="../js/chart.sample.min.js"></script>

	<script>
		!(function(f, b, e, v, n, t, s) {
			if (f.fbq)
				return;
			n = f.fbq = function() {
				n.callMethod ? n.callMethod.apply(n, arguments) : n.queue
						.push(arguments);
			};
			if (!f._fbq)
				f._fbq = n;
			n.push = n;
			n.loaded = !0;
			n.version = "2.0";
			n.queue = [];
			t = b.createElement(e);
			t.async = !0;
			t.src = v;
			s = b.getElementsByTagName(e)[0];
			s.parentNode.insertBefore(t, s);
		})(window, document, "script",
				"https://connect.facebook.net/en_US/fbevents.js");
		fbq("init", "658339141622648");
		fbq("track", "PageView");
	</script>
	<noscript>
		<img height="1" width="1" style="display: none"
			src="https://www.facebook.com/tr?id=658339141622648&ev=PageView&noscript=1" />
	</noscript>

	<!-- Icons below are for demo only. Feel free to use any icon pack. Docs: https://bulma.io/documentation/elements/icon/ -->
	<link rel="stylesheet"
		href="https://cdn.materialdesignicons.com/4.9.95/css/materialdesignicons.min.css" />
</body>

</html>