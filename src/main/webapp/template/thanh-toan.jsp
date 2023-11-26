<%@page import="response.CartResponse" %>
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>G15 | Thanh toán</title>
    <link rel="stylesheet" href="../themes/css1/thanh-toan.css">
</head>
<body>
<!-- header -->
<%@ include file="header.jsp" %>

<main id="checkout_page">
    <div class="container">
        <div class="d-flex">

            <div class="col col-lg-8 pe-5">
                <h4 class="mb-3">Thông tin giao hàng</h4>
                <%
                    Address info = (Address) session.getAttribute("addressDefault");
                    if (info != null) {
                %>

                <div class="row g-3">

                    <div class="col-sm-12">
                        <label for="lastName" class="form-label">Tên người nhận</label> <input
                            type="text" class="form-control" id="lastName"
                            disabled="disabled" placeholder="Vui lòng nhập tên"
                            value="<%=info.getName()%>" required>
                        <div class="invalid-feedback">Họ hợp lệ là bắt buộc.</div>
                    </div>

                    <div class="col-12">
                        <label for="phone" class="form-label">Số điện thoại </label> <input
                            type="tel" class="form-control" id="phone" disabled="disabled"
                            placeholder="0123456789" value="<%=info.getPhone()%>" required>
                        <div class="invalid-feedback">Vui lòng nhập số điện thoại
                            hợp lệ để cập nhật thông tin vận chuyển.
                        </div>
                    </div>
                    <div class="col-12">
                        <label for="validateAddress" class="form-label">Tỉnh/Thành phố
                            <input type="text" class="form-control"
                                   id="validateAddress" placeholder="Nhập địa chỉ giao hàng đến"
                                   disabled="disabled" value="<%=info.getAddress()%>" required></input>
                        </label>
                        <lable for="district" class="form-label"> Quận/Huyện
                            <input type="text" class="form-control"
                                   id="district" placeholder="Nhập địa chỉ giao hàng đến"
                                   disabled="disabled" value="Huyện Cái Bè" required></input>
                        </lable>
                        <lable for="ward" class="form-label"> Xã/ Phường
                            <input type="text" class="form-control"
                            id="ward" placeholder="Nhập địa chỉ giao hàng đến"
                            disabled="disabled" value="Xã An Hữu" required></input>
                        </lable>
                        <div class="invalid-feedback">Địa chỉ giao hàng không được
                            bỏ trống
                        </div>
                    </div>
                    <h4 class="mb-3">Thanh toán</h4>
                </div>
                <%
                    }
                %>
                <div class="my-3">
                    <div class="form-check">
                        <input id="credit" name="paymentMethod" type="radio"
                               class="form-check-input" checked required> <label
                            class="form-check-label" for="credit">Thanh toán trực
                        tiếp khi giao hàng</label>
                    </div>
                    <div class="form-check">
                        <input id="credit" name="paymentMethod" type="radio"
                               class="form-check-input"> <label
                            class="form-check-label" for="credit">Thẻ tín dụng</label>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body">
                        <div class="radio-content-input">
                            <img class="main-img"
                                 src="https://hstatic.net/0/0/global/design/seller/image/payment/other.svg?v=3">
                            <div class="content-wrapper">
									<span class="radio-label-primary">Khách hàng chọn thẻ
										tín dụng sẽ chuyển tiền vào 1 trong các tài khoản sau: </span> </span>
                            </div>
                        </div>
                        <div class="blank-slate">
                            <p>
                                ►G15-MBA <br> Ngân hàng Vietcombank chi nhánh nam sài gòn
                                <br> <b> Số TK :0181436890412</b>
                            </p>

                            <p>
                                ►G15-MBA <br> Ngân hàng Sacombank chi nhánh Lữ Gia-Q11 <br>
                                <b> Số TK : 060023769853</b>
                            </p>

                            <p>
                                ►G15-MBA <br> Ngân hàng BIDV chi nhánh sở giao dịch 2 <br>
                                <b> Số TK : 13010975318754</b>
                            </p>

                            <p>
                                ►G15-MBA <br> Ngân hàng Vietinbank chi nhánh Bắc Sài Gòn <br>
                                <b> Số TK : 1000008632697</b>
                            </p>

                        </div>
                    </div>
                </div>
            </div>
            <!-- section price -->
            <div class="col-md-4" id="total_checkout">

                <h4>ÁP DỤNG MÃ GIẢM GIÁ</h4>

                <%
                    List<Voucher> list = (List<Voucher>) request.getAttribute("vouchers");
                    for (Voucher v : list) {
                %>

                <div data-voucher-id="<%= v.getIdvouchers() %>"
                     style="display: flex; justify-content: space-between; border: 1px solid #ccc; width: 300px; align-items: center; text-align: center; margin-right: 15px; padding-right: 5px">
                    <div style="background-color: #1b1e21; font-size: 14px; color: #FFFFFF; padding: 20px; width: 100px">
                        <%= v.getNameVoucher() %>
                    </div>
                    <span style="padding: 0 4px; font-size: 12px"><%= v.getDiktat() %></span>
                    <a href="/thanh-toan/get-voucher-price?id=<%=v.getIdvouchers()%>">
                        <lable style="padding: 12px; cursor: pointer"
                               onclick="handleVoucherSelection(<%= v.getIdvouchers() %>)">
                            <input type="radio" name="idvoucher" value="<%= v.getValue() %>">
                        </lable>
                    </a>

                </div>
                <%
                    }
                %>

                <a href="/voucher">Thêm Voucher</a>

                <h4>ĐƠN HÀNG</h4>
                <% if (session.getAttribute("cartInfo") != null) {
                    CartResponse cartresp = (CartResponse) session.getAttribute("cartInfo");
                %>
                <ul id="bill" class="p-0">
                    <li class="bill_item d-flex w-100"><span class="col-md-6">
								Đơn hàng </span>
                        <p class="col-md-6">
								<span id="get_price_total">
								<fmt:formatNumber type="number" maxFractionDigits="3"
                                                  value="<%=cartresp.getSubtotal()%>"/>
								VND</span>
                        </p></li>
                    <li class="bill_item d-flex w-100"><span class="col-md-6">
								Giảm </span>
                        <p class="col-md-6">
								<span id="get_discount">
								<fmt:formatNumber type="number" maxFractionDigits="3"
                                                  value="<%=(cartresp.getItemdiscount()-cartresp.getSubtotal())%>"/>
								VND</span>
                        </p></li>
                        <li class="bill_item d-flex w-100"><span class="col-md-6">
								Giảm từ Voucher</span>
                            <p class="col-md-6">
                        <span id="voucher-price">
                        <fmt:formatNumber type="number" maxFractionDigits="3" value="<%=cartresp.getVouchePrice()%>"/>VND
                        </span>
                            </p>
                        </li>
                    <li class="bill_item d-flex w-100"><span class="col-md-6">
								<strong> Phí vận chuyển </strong>
						</span>
                        <p class="col-md-6">
								<span id="ship">
								<fmt:formatNumber type="number" maxFractionDigits="3"
                                                  value="<%=cartresp.getShipping()%>"/>
								VND</span>
                        </p></li>
                </ul>
                <hr>
                <div class="d-flex" id="total_bill">
                    <div class="col-md-6">TỔNG CỘNG</div>
                    <div class="col-md-6">
							<span id="total">
							<fmt:formatNumber type="number" maxFractionDigits="3"
                                              value="<%=cartresp.getGrandtotal()%>"/>
							</span> VND
                    </div>
                </div>
                <form id="frm_bill" action="/thanh-toan/checkout" method="POST">
                    <button class="btn w-100" id="finish_order_btn" type="submit">ĐẶT
                        HÀNG</button>
                </form>
                <%} %>
            </div>
        </div>
    </div>
</main>
<!-- footer -->
<%@ include file="footer.jsp" %>
<!-- js -->
</body>
<script>
    function handleVoucherSelection(voucherId) {
        // Gửi yêu cầu AJAX để lấy giá tương ứng từ máy chủ
        var xhr = new XMLHttpRequest();
        xhr.open('GET', '/thanh-toan/get-voucher-price?id=' + voucherId, true);
        xhr.onload = function () {
            if (xhr.status === 200) {
                // Cập nhật giá trị trong trang HTML
                document.getElementById('voucher-price').innerText = xhr.responseText;
                // cập nhật giá trị tổng cộng
                updateTotal();

            }
        };
        xhr.send();
    }

    function updateTotal() {
        var subtotal = parseFloat(document.getElementById('get_price_total').innerText);
        var itemDiscount = parseFloat(document.getElementById('get_discount').innerText);
        var voucherPrice = parseFloat(document.getElementById('voucher-price').innerText);
        var shipping = parseFloat(document.getElementById('ship').innerText);

        var total = subtotal + itemDiscount - voucherPrice + shipping;

        document.getElementById('total').innerText = total.toFixed(3);
    }
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
</html>