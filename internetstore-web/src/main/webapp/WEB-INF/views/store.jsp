<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>--%>

<html>

<head>
    <title>Goods List</title>
    <%--<link href="<c:url value='/static/css2/bootstrap.css' />" rel="stylesheet"/>--%>
    <%--<link href="<c:url value='/static/css2/app.css' />" rel="stylesheet"/>--%>
</head>

<body>
<%@include file="header.jsp" %>
<div class="breadcrumb">
    <div class="container">
        <div class="breadcrumb-inner">
            <ul class="list-inline list-unstyled">
                <li><a href="<c:url value='/index'/> ">Home</a></li>
                <li class='active'>${currentCategory.name}</li>
            </ul>
        </div><!-- /.breadcrumb-inner -->
    </div><!-- /.container -->
</div><!-- /.breadcrumb -->
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

                                <%--<c:forEach items="${parameters}" var="parameters">--%>
                                <%--<h6>${parameters.name}</h6>--%>
                                <%--<a>${parameters.description}</a>--%>
                                <%--</c:forEach>--%>
                                Price filter:
                                <input type="number" id="pricemin" size="4" value="${pricefilter.min}"/> -
                                <input type="number" id="pricemax" size="4" value="${pricefilter.max}"/>
                                    <script>
                                        function someFunc(){

                                            var minb = document.getElementById("pricemin").value;
                                            var maxb = document.getElementById("pricemax").value;
                                            var min = minb;
                                            var max = maxb;
                                            if(minb<0){
                                                document.getElementById("pricemin").value = 0;
                                                min = 0;
                                            }
                                            if(maxb>1000000){
                                                document.getElementById("pricemax").value = ${pricefilter.max};
                                                max = ${pricefilter.max};
                                            }

                                            var sorttype = document.getElementById("sorttypeselect").value;
                                            var str = "${pageContext.request.contextPath}/store?id=${currentCategory.id}"
                                                + "&min=" + min + "&max=" + max + "&sorttype=" + sorttype;

                                            document.location.href = str;
                                            //alert(str);
                                        }
                                    </script>
                                    &nbsp Sorting type:
                                   <select id="sorttypeselect">
                                       <c:forEach items="${sorttypes}" var="sorttype">
                                           <option >${sorttype}</option>
                                       </c:forEach>
                                   </select>

                                    &nbsp
                                    <a id="setbtn" onclick="someFunc()" class="btn btn-link">Apply</a>


                                <c:forEach items="${goods}" var="goods">

                                    <div class="category-product-inner wow fadeInUp  fa-border">
                                        <div class="products">
                                            <div class="product-list product">
                                                <div class="row product-list-row">
                                                    <div class="col col-sm-2 col-lg-2">
                                                        <div class="product-image">
                                                            <img src="<c:url value='/static/images/products/p1.jpg'/>"
                                                                 height="110">
                                                        </div>
                                                    </div>
                                                    <!-- /.col -->
                                                    <div class="col col-sm-8 col-lg-8">
                                                        <h2 class="name"><a href="<c:url value='/details?id=${goods.id}'/> ">${goods.name}</a>
                                                        </h2>
                                                        <div class="rating rateit-small"></div>
                                                        <div class="product-price">Price: <b><span
                                                                class="price">$${goods.price}</span></b>
                                                        </div>
                                                        <!-- /.product-price -->
                                                        <div class="description m-t-10">
                                                            Description: <b>${goods.description}</b>
                                                            <br>
                                                        </div>


                                                        <div class="description m-t-10">

                                                            <%--<c:forEach items="${goods.goodsParameterList}"--%>
                                                                       <%--var="params">--%>
                                                                <%--<span class="value">${params.parameter.name}: </span>--%>


                                                            <%--</c:forEach>--%>

                                                            <div class="description m-t-10">
                                                                Items in stock: <b> ${goods.leftCount}</b>
                                                                <br>
                                                            </div>
                                                        </div>
                                                        <c:choose>
                                                            <c:when test="${goods.leftCount > 0}">
                                                                <div class="action">
                                                                    <a href="addtocart?id=${goods.id}"
                                                                       class="btn btn-primary">Add to
                                                                        cart</a>
                                                                </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <div class="action">
                                                                    <a href=""
                                                                       class="btn btn-primary" disabled="true">Out of
                                                                        stock</a>
                                                                </div>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <br/>

                                                        <!-- /.cart -->

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
</div>
</body>
</html>