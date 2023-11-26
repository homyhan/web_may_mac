<%@ page import="model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- header -->
<div class="col-md-3 left">
	<div class="row">
		<div class="carousel-inner-account">
			<div class="row">
				<div class="col-sm-2">
					<h1 class='fas fa-user-alt'></h1>
				</div>
				<div class="col-sm-3">
					<%
					User info = (User) session.getAttribute("userLogin");
					if (info != null) {
					%>
					<h2><%=info.getUsername()%>
					</h2>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>
	<section id="menu_side">
		<div class="row">
			<div class="col col-lg-12 menu-item">
				<div class="collapse show" id="collapseStatus">
					<ul>
						<li><a href="../thong-tin-khach-hang/quan-ly-tai-khoan.jsp">Tài
								khoản</a></li>
						<li><a href="../thong-tin-khach-hang/thay-doi-mat-khau.jsp">Thay
								đổi mật khẩu</a></li>
						<li><a href="/tai-khoan/dia-chi">Địa chỉ</a></li>
						<li><a href="/tai-khoan/don-hang">Đơn hàng của tôi</a></li>
						<li><a href="/tai-khoan/voucher">Kho
								Voucher</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
</div>