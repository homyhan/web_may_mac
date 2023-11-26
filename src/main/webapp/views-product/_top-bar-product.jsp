<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="row justify-content-between align-items-center mb-3">
    <div class="col col-lg-8">
        <div class="d-flex align-items-center">
            <span class="me-3">Sắp xếp theo: </span>
            <ul class="d-flex align-items-center mb-0">
                <li>
                    <c:if test="${isProductPage==1}">
                        <c:if test="${newChecked==0}">
                            <a href="${urlPatterns}?sort=new" class="btn btn-light border mx-1">Mới nhất</a>
                        </c:if>
                        <c:if test="${newChecked==1}">
                            <a href="${urlPatterns}?sort=new" class="btn btn-dark border mx-1">Mới nhất</a>
                        </c:if>
                    </c:if>
                    <c:if test="${isProductPage==0}">
                        <c:if test="${newChecked==0}">
                            <a href="${urlPatterns}?sort=new<c:out value="${contentPara}"/>" class="btn btn-light border mx-1">Mới nhất</a>
                        </c:if>
                        <c:if test="${newChecked==1}">
                            <a href="${urlPatterns}?sort=new<c:out value="${contentPara}"/>" class="btn btn-dark border mx-1">Mới nhất</a>
                        </c:if>
                    </c:if>
                </li>
                <li>
                    <c:if test="${isProductPage==1}">
                        <c:if test="${hotChecked==0}">
                            <a href="${urlPatterns}?sort=hot" class="btn btn-light border mx-1">Nổi bật</a>
                        </c:if>
                        <c:if test="${hotChecked==1}">
                            <a href="${urlPatterns}?sort=hot" class="btn btn-dark border mx-1">Nổi bật</a>
                        </c:if>
                    </c:if>
                    <c:if test="${isProductPage==0}">
                        <c:if test="${hotChecked==0}">
                            <a href="${urlPatterns}?sort=hot<c:out value="${contentPara}"/>" class="btn btn-light border mx-1">Nổi bật</a>
                        </c:if>
                        <c:if test="${hotChecked==1}">
                            <a href="${urlPatterns}?sort=hot<c:out value="${contentPara}"/>" class="btn btn-dark border mx-1">Nổi bật</a>
                        </c:if>
                    </c:if>
                </li>
                <li>
                    <div class="dropdown">
                        <a class="btn btn-light border mx-1 dropdown-toggle" href="#" role="button" id="dropdownMenuPrice" data-bs-toggle="dropdown" aria-expanded="false">
                            Giá ${sortName}
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuPrice">
                            <c:if test="${isProductPage==1}">
                                <li><a class="dropdown-item" href="${urlPatterns}?sort=asc">Giá thấp đến cao</a></li>
                                <li><a class="dropdown-item" href="${urlPatterns}?sort=desc">Giá cao đến thấp</a></li>
                            </c:if>
                            <c:if test="${isProductPage==0}">
                                <li><a class="dropdown-item" href="${urlPatterns}?sort=asc<c:out value="${contentPara}"/>">Giá thấp đến cao</a></li>
                                <li><a class="dropdown-item" href="${urlPatterns}?sort=desc<c:out value="${contentPara}"/>">Giá cao đến thấp</a></li>
                            </c:if>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <div class="col col-lg-2">
        <strong>${count}/${total} sản phẩm</strong>
    </div>
    <div class="col col-lg-2">
        <ul class="pages d-flex justify-content-end align-items-center mt-3">
            <li class="mx-1">
                <c:if test="${tag==1}">
                    <a href='${urlPatterns}?page=1<c:out value="${contentPara}"/>' class="btn btn-light"><i class="fas fa-caret-left"></i></a>
                </c:if>
                <c:if test="${tag>1}">
                    <a href='${urlPatterns}?page=${tag-1}<c:out value="${contentPara}"/>' class="btn btn-dark"><i class="fas fa-caret-left"></i></a>
                </c:if>
            </li>
            <li class="mx-1">
                <strong style="color:#f15f2f">${tag}</strong>/${endP}
            </li>
            <li class="mx-1">
                <c:if test="${tag<endP}">
                    <a href='${urlPatterns}?page=${tag+1}<c:out value="${contentPara}"/>' class="btn btn-dark"><i class="fas fa-caret-right"></i></a>
                </c:if>
                <c:if test="${tag==endP}">
                    <a href='${urlPatterns}?page=${endP}<c:out value="${contentPara}"/>' class="btn btn-light"><i class="fas fa-caret-right"></i></a>
                </c:if>
            </li>
        </ul>
    </div>
</div>

