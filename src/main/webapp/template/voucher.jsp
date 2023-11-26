<%@ page import="model.Voucher" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>G15 | Mã giảm giá</title>
</head>
<body>
<%@ include file="/template/header.jsp"%>
<main id="main">
    <div class="container">
        <div class="wrapper" style="text-align: center">
            <h1>Mã giảm giá</h1>
        </div>
        <div class="row">
            <%
                List<Voucher> list = (List<Voucher>) request.getAttribute("listVoucher");
                for (Voucher v : list) {
            %>
                <div class="content_container col-sm-5" style="border: solid 1px #f3f1f1; border-radius: 5px; margin: 20px 20px">
                    <div style="background-color: black; border-top-right-radius: 5px; border-top-left-radius: 5px; font-size: 25px;color: #FFFFFF;padding: 24px;margin: 0 -12px; text-align: center">
                        <%=v.getNameVoucher()%>
                    </div>
                    <div class="content row">
                    <span style="padding: 0 16px; float: left; width: 70%">
                        <p><%=v.getDiktat()%></p>
                        <i style="font-size: 13px; font-weight: normal">Từ <%=v.getStartAt()%> đến <%=v.getFinishAt()%></i>
                    </span>
                        <a href="/saveVoucher?id=<%=v.getIdvouchers()%>"
                           style="background-color: #ed4d2b; border-bottom-right-radius: 5px; color: #fff; float: right; width: 30%;">
                            <p style=" text-align: center; padding-top: 16px">Lưu</p>
                        </a>
                    </div>
                </div>
            <%
                }
            %>
        </div>

    </div>
</main>
<%@ include file="/template/footer.jsp"%>
</body>
</html>