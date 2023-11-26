<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="main__header">
    <div class="breadcrumbs">
        <a href="./">Trang chủ</a>
        <span class="div">/</span>
        <c:if test="${isProductPage==1}"><strong>Sản phẩm</strong></c:if>
        <c:if test="${isProductPage==0}">
            <a href="./products">Sản phẩm</a>
            <span class="div">/</span>
            <strong>${mainTitle}</strong>
        </c:if>
    </div>
    <h1>${mainTitle}</h1>
</div>
