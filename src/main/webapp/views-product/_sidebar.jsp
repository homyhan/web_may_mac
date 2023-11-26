<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<article class="col col-md-3">
    <section id="menu_side">
        <div class="row">
            <%-- dòng sản phẩm --%>
            <div class="col col-lg-12 menu-item">
                <button class="btn btn-secondary" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapseCate"
                        aria-expanded="true" aria-controls="collapseCate">
                    Dòng sản phẩm <i class="fas fa-chevron-up"></i>
                </button>
                <div class="collapse show" id="collapseCate">
                    <ul>
                        <c:forEach items="${listCate}" var="category">
                            <li>
                                <a href="productsByCode?code=${category.codecate}">
                                        ${category.title}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

            <!-- chất liệu -->
            <div class="col col-lg-12 menu-item">
                <button class="btn btn-secondary" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapsematerial" aria-expanded="true"
                        aria-controls="collapsematerial">
                    Chất liệu<i class="fas fa-chevron-up"></i>
                </button>
                <div class="collapse show" id="collapsematerial">
                    <ul>
                        <c:forEach items="${listMaterial}" var="m">
                            <li>
                                <a href="productsByCode?code=${m.codematerial}">
                                        ${m.title}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

            <%-- màu sắc --%>
            <div class="col col-lg-12 menu-item">
                <button class="btn btn-secondary" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapsecolor" aria-expanded="true"
                        aria-controls="collapsecolor">
                    Màu sắc<i class="fas fa-chevron-up"></i>
                </button>
                <div class="collapse show" id="collapsecolor">
                    <ul style="display: grid; grid-template-columns: repeat(auto-fill, 40px); gap: 5px">
                        <c:forEach items="${listColor}" var="color">
                            <li>
                                <a href="productsByCode?code=${color.codecolor}" style="height: 40px;background-color: ${color.codecolor}; border: 2px solid black; border-radius: 6px" class="btn btn-color">
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

            <%--  khuyến mãi --%>
            <div class="col col-lg-12 menu-item">
                <button class="btn btn-secondary" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapseSaleoff" aria-expanded="true"
                        aria-controls="collapseSaleoff">
                    Sản phẩm khuyến mãi <i class="fas fa-chevron-up"></i>
                </button>
                <div class="collapse show" id="collapseSaleoff">
                    <ul>
                        <li>
                            <a href="productsByCode?code=big-deal&discount=true">
                                Giá Siêu đặc biệt
                            </a>
                        </li>
                        <c:forEach items="${listCate}" var="category">
                            <li>
                                <a href="productsByCode?code=${category.codecate}&discount=true">
                                        ${category.title}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </section>
</article>