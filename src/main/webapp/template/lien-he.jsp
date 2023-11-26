<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

<title>G15 | Liên hệ</title>





<link rel="stylesheet" href="/themes/css1/lien-he.css">

</head>

<body>
	<!-- header -->


	<%@ include file="header.jsp"%>








	<!-- Content page -->
	<section class="bg0 p-t-104 p-b-116">
		<div class="container-contact100">
			<div class="wrap-contact100">
				<form class="contact100-form validate-form" action="/lien-he" method="post">
					<strong class="contact100-form-title">Liên hệ cửa hàng</strong>
					   <c:if test="${status == 0}">
						  <strong class="contact100-form-title" style="color: red;">
								thất bại
						  </strong>
					</c:if>
					<c:if test="${status == 1}">
						<strong class="contact100-form-title" style="color: green;">
							thành công
						</strong>
					</c:if>
					<div class="wrap-input100 validate-input bg1 rs1-wrap-input100 alert-validate" data-validate="Please Type Your Name">
						<span class="label-input100">Họ và tên *</span>
						<input class="input100" type="text" name="name" placeholder="Họ và tên" required>
						<i style="color: red">${errorName}</i>
					</div>
					<div class="wrap-input100 validate-input bg1 rs1-wrap-input100 alert-validate"
						 data-validate="Enter Your Email (e@a.x)">
						<span class="label-input100">Email *</span>
						<input class="input100" type="text" name="email" placeholder="Email " required>
						<i style="color: red">${errorEmail}</i>
					</div>
					<div class="wrap-input100 bg1 rs1-wrap-input100">
						<span class="label-input100">Số điện thoại</span>
						<input class="input100" type="text" name="phone" placeholder="Số điện thoại" required>
						<i style="color: red">${errorPhone}</i>
					</div>
					<div class="wrap-input100 bg1 rs1-wrap-input100">
						<span class="label-input100">Hẹn lịch đặt may đồ tại cửa hàng:</span>
						<label for="start">(Nếu có)</label>
						<input type="date" id="start" name="trip-start" value="2022-12-01" min="2022-12-01" max="2023-12-31">
					</div>
					<div class="wrap-input100 validate-input bg0 rs1-alert-validate alert-validate"
						 data-validate="Please Type Your Message">
						<span class="label-input100">Ghi chú</span>
						<textarea class="input100" name="message" placeholder="Yêu cầu của bạn gửi tới của hàng"></textarea>
						<i style="color: red">${errorMsg}</i>
						<!--                <span class="btn-hide-validate"></span><span class="btn-hide-validate"></span>-->
					</div>
					<div class="container-contact100-form-btn">
						<button class="contact100-form-btn" type="submit">
							Gửi
						</button>
					</div>
				</form>
			</div>
		</div>

	</section>



	<!-- Map -->
	<div class="map">



		<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.2156930380256!2d106.78957711425707!3d10.871192760411297!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175276398969f7b%3A0x9672b7efd0893fc4!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBOw7RuZyBMw6JtIFRwLiBI4buTIENow60gTWluaA!5e0!3m2!1svi!2s!4v1636529721564!5m2!1svi!2s"
			width="100%" height="500px" frameborder="0" style="border: 0"
			allowfullscreen=""></iframe>
	</div>
	<!-- footer -->
	<%@ include file="footer.jsp"%>

	<!-- js -->
</body>

</html>