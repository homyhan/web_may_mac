<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en" class="">

<head>

<title>Trang chủ - Admin G15</title>

</head>

<body>


	<!-- header -->
	<%@ include file="/quan-tri-admin/header-admin.jsp"%>


	<section class="is-title-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<ul>
				<li>Admin</li>
				<li>Trang chủ</li>
			</ul>
			<!-- Nut Them -->
			<!-- <a
            href="https://justboil.me/"
            onclick="alert('Coming soon'); return false"
            target="_blank"
            class="button blue"
          >
            <span class="icon"
              ><i class="mdi mdi-credit-card-outline"></i
            ></span>
            <span>Premium Demo</span>
          </a> -->
		</div>
	</section>

	<section class="is-hero-bar">
		<div
			class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
			<h1 class="title">Trang chủ</h1>
			<!-- <button class="button light">Thêm</button> -->
		</div>
	</section>

	<section class="section main-section">
		<div class="grid gap-6 grid-cols-1 md:grid-cols-3 mb-6">
			<div class="card">
				<div class="card-content">
					<div class="flex items-center justify-between">
						<div class="widget-label">
							<h3>Khách hàng</h3>
							<h1>512</h1>
						</div>
						<span class="icon widget-icon text-green-500"><i
							class="mdi mdi-account-multiple mdi-48px"></i></span>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-content">
					<div class="flex items-center justify-between">
						<div class="widget-label">
							<h3>Doanh thu</h3>
							<h1>0,5 tỉ</h1>
						</div>
						<span class="icon widget-icon text-blue-500"><i
							class="mdi mdi-cart-outline mdi-48px"></i></span>
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-content">
					<div class="flex items-center justify-between">
						<div class="widget-label">
							<h3>Màn biểu diễn</h3>
							<h1>256%</h1>
						</div>
						<span class="icon widget-icon text-red-500"><i
							class="mdi mdi-finance mdi-48px"></i></span>
					</div>
				</div>
			</div>
		</div>

		<div class="card mb-6">
			<header class="card-header">
				<p class="card-header-title">
					<span class="icon"><i class="mdi mdi-finance"></i></span> Màn biểu
					diễn
				</p>
				<a href="#" class="card-header-icon"> <span class="icon"><i
						class="mdi mdi-reload"></i></span>
				</a>
			</header>
			<div class="card-content">
				<div class="chart-area">
					<div class="h-full">
						<div class="chartjs-size-monitor">
							<div class="chartjs-size-monitor-expand">
								<div></div>
							</div>
							<div class="chartjs-size-monitor-shrink">
								<div></div>
							</div>
						</div>
						<canvas id="big-line-chart" width="2992" height="1000"
							class="chartjs-render-monitor block"
							style="height: 400px; width: 1197px"></canvas>
					</div>
				</div>
			</div>
		</div>



	</section>
</body>

</html>