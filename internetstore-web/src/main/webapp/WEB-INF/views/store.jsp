<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>--%>

<html>

<head>
    <title>Goods List</title>
    <%--<link href="<c:url value='/static/css2/bootstrap.css' />" rel="stylesheet"/>--%>
    <%--<link href="<c:url value='/static/css2/app.css' />" rel="stylesheet"/>--%>
</head>

<body>
<%@include file="header.jsp" %>
<%@include file="categories-bar.jsp" %>


<div class="col-xs-12 col-sm-12 col-md-7 top-search-holder">
    <!-- /.contact-row -->
    <div class="search-area">
        <div class="tab-pane " id="list-container">
            <div class="category-product">
                <div class="category-product-inner wow fadeInUp">
                    <div class="products">
                        <div class="product-list product">
                            <div class="row product-list-row">

                                <c:forEach items="${parameters}" var="parameters">
                                    <h6>${parameters.name}</h6>
                                    <a>${parameters.description}</a>
                                </c:forEach>

                                <c:forEach items="${goods}" var="goods">


                                    <div class="category-product-inner wow fadeInUp  fa-border">
                                        <div class="products">
                                            <div class="product-list product">
                                                <div class="row product-list-row">
                                                    <div class="col col-sm-4 col-lg-2">
                                                        <div class="product-image">
                                                            <img src="<c:url value='/static/images/products/p1.jpg'/>"
                                                                 height="110">
                                                        </div>
                                                    </div>
                                                    <!-- /.col -->
                                                    <div class="col col-sm-8 col-lg-8">
                                                        <div class="product-info">
                                                            <h3 class="name"><a href="#">${goods.name}</a>
                                                            </h3>
                                                            <div class="rating rateit-small"></div>
                                                            <div class="product-price"><span
                                                                    class="price">Price: $${goods.price}</span>
                                                            </div>
                                                            <!-- /.product-price -->
                                                            <div class="description m-t-10">
                                                                    ${goods.description}
                                                                <br>
                                                            </div>
                                                            <div class="description m-t-10">
                                                                <c:forEach items="${goods.goodsParameterList}"
                                                                           var="params">
                                                                    <span class="value">${params.parameter.name}: </span>


                                                                    <%--<c:when test="${params.parameter.parameterType == 'param_num'}">--%>
                                                                        <span class="value">${params.numValue}</span>
                                                                    <%--</c:when>--%>
                                                                    <%--<c:otherwise>--%>
                                                                        <%--<span class="value">${params.stringValue}</span>--%>
                                                                    <%--</c:otherwise>--%>
                                                                </c:forEach>
                                                            </div>
                                                            <div class="action">
                                                                <a href="addtocart?id=${goods.id}"
                                                                   class="btn btn-primary btn-black">Add to cart</a>
                                                            </div>
                                                            <br>
                                                            <!-- /.cart -->

                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>