<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>

  <title>G15 | Sản phẩm</title>
  
  <link rel="stylesheet" href="/themes/css1/product.css">
  </head>
<body>
<!-- header -->
<%@ include file="/template/header.jsp"%>

<main id="product_page">
  <div class="container">
    <%--  Breadcrumb  --%>
    <jsp:include page="_breadcrumb.jsp"></jsp:include>
    <div class="d-flex">
      <%-- Sidebar --%>
      <jsp:include page="_sidebar.jsp"></jsp:include>
      <%-- List Product --%>
      <article class="col col-md-9">
        <section id="section_prod_list">
          <div class="container">
            <%--     top-bar-product        --%>
            <jsp:include page="_top-bar-product.jsp"></jsp:include>
            <div class="products">
              <div id="page_prods" class="row--grid">
                <c:forEach items="${listProduct}" var="p">
                  <div class="card product-item">
                    <a href="/detail?idproduct=${p.idproduct}">
                      <img src='images\products\<c:out value="${p.codecate}"/>/<c:out value="${p.image}"/>'
                           class="card-img-top" alt="<c:out value="${p.image}"/>">
                    </a>
                    <div class="card-body text-center">
                      <a href="/detail?idproduct=${p.idproduct}">
                        <h3 class="card-title" style="min-height: 50px">${p.title}</h3>
                        <p class="card-price">
                          <span class="price">
                                                        <c:if test="${p.discount > 0}">
                                                            <del><fmt:formatNumber type="number" maxFractionDigits="3"
                                                                                   value="${p.price}"/> VND</del>
                                                        </c:if>
                                                        <c:if test="${p.discount == 0}">
                                                            <strong><fmt:formatNumber type="number"
                                                                                      maxFractionDigits="3"
                                                                                      value="${p.price}"/> VND</strong>
                                                        </c:if>
                                                    </span>
                          <span class="price-sale">
                                                        <c:if test="${p.discount > 0}">
                                                            <strong><fmt:formatNumber type="number"
                                                                                      maxFractionDigits="3"
                                                                                      value="${p.discount}"/> VND</strong>
                                                        </c:if>
                                                    </span>
                        </p>
                      </a>
                      <div   class="card-btn d-flex justify-content-between">
                     
                        
                        <form action="/cart/add-to-cart" method="POST"  style="width: 50%">
                            <input name="ismeasure" type="hidden" value="0"> <input
                              name="id" type="hidden" value="${p.idproduct}">
                            <input type="hidden" name="get_quantity_order"
                              id="get_quantity_order" class="form-control" value="1"
                              min="1" /> <input name="get_size_order" type="hidden" value="S"/>
                            <button class="btn btn-primary" style="width: 100%"><i class="fas fa-cart-plus"></i></button>
                          </form>
                          <a href="/datmay?idproduct=${p.idproduct}"
                            class="btn btn-outline-dark mx-2" id="datmay_btn" style="width: 50%">ĐẶT
                            MAY</a>
                      </div>
                    </div>
                  </div>
                </c:forEach>
              </div>
              <style>
                .pages .disable{
                  display: none;
                }
                .pages .page-item a{
                  border: 1px solid #333;
                }
              </style>
              <ul class="pages d-flex justify-content-center mt-3">
                <li class="page-item ${tag==1?"disable":"btn-light"}">
                  <a href='${urlPatterns}?page=${tag-1}<c:out value="${contentPara}"/>' class="btn btn-light"><i class="fas fa-caret-left"></i></a>
                </li>
                <c:forEach begin="1" end="${endP}" var="i">
                  <li class="page-item mx-2"><a href='${urlPatterns}?page=${i}<c:out value="${contentPara}"/>' class="btn ${tag==i?"btn-dark":"btn-light"}">${i}</a></li>
                </c:forEach>
                <li class="page-item ${tag==endP?"disable":"btn-light"}">
                  <a href='${urlPatterns}?page=${tag+1}<c:out value="${contentPara}"/>' class="btn btn-light"><i class="fas fa-caret-right"></i></a>
                </li>
              </ul>
            </div>
          </div>
        </section>
      </article>
    </div>
  </div>
</main>

<!-- footer -->
<%@ include file="/template/footer.jsp"%>

<!-- JS -->
<script src="../themes/js/paginateProducts.js"></script>

</body>

</html>