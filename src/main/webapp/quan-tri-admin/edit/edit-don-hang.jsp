<%--
  Created by IntelliJ IDEA.
  User: Cuong HQ
  Date: 12/6/2023
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="model.Order"%>
<%@page import="model.Invoice"%>
<%@page import="response.OrderOrderdetailResponse"%>
<%@page import="model.OrderDetail"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="helper.Contants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="response.InvoiceResponse"%>
<%@page import="response.OrderOrderdetailResponse"%>
<%@page import="java.util.List"%>
<%@ page import="service.OrderService" %>
<%@ page import="service.UserService" %>
<%@ page import="service.OrderDetailService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en" class="">

<head>
    <title>Đơn may sẵn - Admin G15</title>

</head>

<body>

<!-- header -->
<%@ include file="/quan-tri-admin/header-admin.jsp"%>

<section class="is-title-bar">
    <div
            class="flex flex-col md:flex-row items-center justify-between space-y-6 md:space-y-0">
        <ul>
            <li>Admin</li>
            <li>Đơn đặt may</li>
        </ul>

    </div>
</section>



<section class="section main-section">

    <h2 class="fs-1 text-center fw-bold mb-5">Chỉnh sửa thông tin đơn hàng</h2>
    <div class="w-50 mx-auto">
        <form method="POST" action="/admin/edit-don-hang">
            <%
                if (request.getAttribute("showOrderdetailTempToEdit") != null) {
                    int idOrder = (int)request.getAttribute("idOrderToEdit");
                    List<Order> orderDetail = (ArrayList<Order>) request.getAttribute("showOrderdetailTempToEdit");

                    for (int i = 0; i < orderDetail.size(); i++) {
            %>
            <input type="hidden" value="<%=idOrder%>" name="idOrder">
            <input type="hidden" value="<%=orderDetail.get(i).getIduser()%>" name="idUser">
            <div class="mb-3">
                <label for="idAddress" class="form-label">Id Address</label>
                <input type="text" class="form-control" id="idAddress" name="idAddress" value="<%=orderDetail.get(i).getIdaddress()%>">
            </div>
            <div class="mb-3">
                <label for="subtotal" class="form-label">Subtotal</label>
                <input type="text" class="form-control" id="subtotal" name="subtotal" value="<%=orderDetail.get(i).getSubtotal()%>">
            </div>
            <div class="mb-3">
                <label for="itemDiscount" class="form-label">ItemDiscount</label>
                <input type="text" class="form-control" id="itemDiscount" name="itemDiscount" value="<%=orderDetail.get(i).getItemdiscount()%>">
            </div>
            <div class="mb-3">
                <label for="shipping" class="form-label">Shipping</label>
                <input type="text" class="form-control" id="shipping" name="shipping" value="<%=orderDetail.get(i).getShipping()%>">
            </div>
            <div class="mb-3">
                <label for="grandtotal" class="form-label">GrandToal</label>
                <input type="text" class="form-control" id="grandtotal" name="grandtotal" value="<%=orderDetail.get(i).getGrandtotal()%>">
            </div>
            <div class="mb-3">

                <input class="btn btn-success" type="submit" class="form-control" value="Save">
                <a class="btn btn-outline-dark" href="/admin/don-hang">Quay lại</a>
            </div>
            <%
                    }
                }
            %>

        </form>

    </div>

</section>
</body>

</html>
