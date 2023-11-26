<%@page import="response.CartResponse" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Map" %>
<%@page import="response.ProductCartResponse" %>
<%@page import="java.util.HashMap" %>
<%@ page import="model.Product" %>
<%@ page import="model.User" %>
<%@ page import="response.VoucherResponse" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>G15 | GIỎ HÀNG</title>

    <link rel="stylesheet" href="../themes/css1/gio-hang.css">
</head>

<body>
<!-- header -->
<%@ include file="header.jsp" %>
<main>
    <section id="gio_hang_page">
        <div class="container">
            <div class="row">
                <artical id="content_cart" class="col col-lg-7 m-4">
                    <div id="my_cart" class="show">
                        <div class="title">
                            <h4>GIỎ HÀNG</h4>
                        </div>
                        <%
                            if (session.getAttribute("productCartList") != null) {
                                HashMap<Integer, ProductCartResponse> cart = (HashMap<Integer, ProductCartResponse>) session
                                        .getAttribute("productCartList");
                                for (Map.Entry<Integer, ProductCartResponse> entry : cart.entrySet()) {
                                    Integer key = entry.getKey();
                                    ProductCartResponse item = entry.getValue();
                        %>
                        <div id="list_order">
                            <div class="card">

                                <div class="row">

                                    <img src='/images\products\<c:out value="<%=item.getProduct().getCodecate() %>"/>/<c:out value="<%=item.getProduct().getImage() %>"/>'
                                         class="card-img" alt="<c:out value="<%=item.getProduct().getImage() %>"/>">
                                    <div class="card-body col-md-6">
                                        <h4 class="card-title">
                                            <a href="#"><%=item.product.getTitle()%>
                                            </a>
                                        </h4>
                                        <p class="card-price">
                                            <strong>Giá:</strong>
                                            <fmt:formatNumber type="number" maxFractionDigits="3"
                                                              value="<%=item.getProduct().getPrice()%>"/>
                                        </p>
                                        <div class="edit_box">
                                            <div class="box_group">
                                                <form id="select_info_prod" action="/cart/update-quantity"
                                                      method="POST">
                                                    <div class="row">
                                                        <input name="ismeasure" type="hidden"
                                                               value="<%=item.getDetail().getIsmeasure()%>"> <input
                                                            name="id" type="hidden"
                                                            value="<%=item.getProduct().getIdproduct()%>"/>

                                                        <%
                                                            if (item.getDetail().getIsmeasure() == 0) {
                                                        %>
                                                        <div class="form-group col-md-6 mb-2">

                                                            <label for="get_size_prod" class="form-label">SIZE</label>

                                                            <select class="form-select" name="get_size_order"
                                                                    aria-label="Default select example">
                                                                <%
                                                                    ArrayList<String> eqArray = new ArrayList<String>();
                                                                    eqArray.add("S");
                                                                    eqArray.add("M");
                                                                    eqArray.add("L");
                                                                    eqArray.add("XL");
                                                                    eqArray.add("2XL");
                                                                    eqArray.add("3XL");
                                                                    for (int i = 0; i < eqArray.size(); i++) {
                                                                %>
                                                                <option value="<%=eqArray.get(i)%>"
                                                                        <%= eqArray.get(i).equals(item.getDetail().getSize()) ? "selected" : "" %>
                                                                >
                                                                    <%=eqArray.get(i)%>
                                                                </option>
                                                                <%
                                                                    }
                                                                %>
                                                                <!-- <option value="key1" >value1</option>
                                                                <option value="key2" selected>value2</option> -->
                                                            </select>
                                                        </div>

                                                        <div class="form-group col-md-6  mb-2">

                                                            <label for="get_quantity_order" class="form-label">SỐ
                                                                LƯỢNG</label> <input type="number"
                                                                                     name="get_quantity_order"
                                                                                     id="get_quantity_order"
                                                                                     class="form-control"
                                                                                     value="<%=item.getQuantity()%>"
                                                                                     min="1"/>

                                                            <button type="submit">Cập nhật</button>
                                                        </div>
                                                        <%
                                                        } else {
                                                        %>
                                                        <div class="form-group col-md-12  mb-2">
                                                            <a
                                                                    href="/datmay?idproduct=<%=item.getProduct().getIdproduct()%>"
                                                                    class="btn btn-outline-dark m-2" id="datmay_btn">Cập
                                                                nhật</a>
                                                        </div>

                                                        <%
                                                            }
                                                        %>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="check_price col-md-3">
                                        <h4>
											<span class="check_price_prod">
											<fmt:formatNumber type="number" maxFractionDigits="3"
                                                              value="<%=item.getProduct().getDiscount()%>"/>
											</span>
                                        </h4>
                                        <i class="check_val_prod">Còn hàng</i>
                                        <form id="select_info_prod" action="/cart/remove-product"
                                              method="POST">
                                            <input name="ismeasure" type="hidden"
                                                   value="<%=item.getDetail().getIsmeasure()%>"> <input
                                                name="id" type="hidden"
                                                value="<%=item.product.getIdproduct()%>"/>

                                            <button class="delete_btn" type="submit">
                                                <i class="far fa-trash-alt"></i>
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%
                                }
                            }
                        %>
                        <hr>
                        <div id="btn_handle">
                            <div class="d-flex">
                                <div class="col-md-6">
                                    <form id="select_info_prod" action="/cart/remove-all"
                                          method="POST">
                                        <button id="del_all_prod" type="submit">XÓA HẾT</button>
                                    </form>
                                </div>
                                <div class="col-md-6">
                                    <a href="/products" class="btn">QUAY LẠI MUA HÀNG</a>
                                </div>
                            </div>
                        </div>

                    </div>

                </artical>
                <artical id="total_cart" class="col-lg-4 col my-4">
                    <%
                        if
                        (
                        session
                        .
                        getAttribute
                        (
                        "cartInfo"
                        )
                        !=
                        null
                        )
                        {
                        CartResponse
                        cartresp
                        =
                        (
                        CartResponse
                        )
                        session
                        .
                        getAttribute
                        (
                        "cartInfo"
                        )
                        ;
                    %>
                    <h4>ĐƠN HÀNG</h4>

                    <div class="form-group">
                        <div class="d-flex"
                             style="justify-content: space-between; align-items: center;">
                            <h5>Đơn hàng</h5>
                            <h3>
								<span id="total_price_final">
								<fmt:formatNumber type="number" maxFractionDigits="3"
                                                  value="<%=cartresp.getSubtotal()%>"/>
								</span>
                                VND
                            </h3>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="d-flex"
                             style="justify-content: space-between; align-items: center;">
                            <h5>Giảm</h5>
                            <h3>
								<span id="total_price_final">
								<fmt:formatNumber type="number" maxFractionDigits="3"
                                                  value="<%=(cartresp.getItemdiscount() - cartresp.getSubtotal())%>"/>
								</span>VND
                            </h3>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="d-flex"
                             style="justify-content: space-between; align-items: center;">
                            <h5>TẠM TÍNH</h5>
                            <h3>
								<span id="total_price_final">
								<fmt:formatNumber type="number" maxFractionDigits="3"
                                                  value="<%=cartresp.getItemdiscount()%>"/>
								</span>
                                VND
                            </h3>
                        </div>
                    </div>
                    <a href="/thanh-toan" class="btn tttt_btn"> TIẾP TỤC THANH TOÁN
                    </a> <%
                    }
                %></artical>
            </div>
        </div>
    </section>
</main>

<!-- footer -->
<%@ include file="footer.jsp" %>

<!-- js -->


</body>

</html>