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
                                <input type="text" id="pricemin" size="4" value="${pricefilter.min}"/> -
                                <input type="text" id="pricemax" size="4" value="${pricefilter.max}"/>
                                    <script>
                                        function someFunc(){

                                            var minb = document.getElementById("pricemin").value;
                                            var maxb = document.getElementById("pricemax").value;
                                            if(minb){
                                                document.getElementById("pricemin").value = 0;
                                                var min = 0;
                                            }
                                            if(maxb){
                                                document.getElementById("pricemax").value = ${pricefilter.max};
                                                var max = ${pricefilter.max};
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
                                <%--<form:form  role="form" modelAttribute="pricefilter" action="${pageContext.request.contextPath}/store" method="get">--%>
                                <%--<form:input path="min" size="1" type="number"/> ---%>
                                <%--<form:input path="max" type="number"/>--%>
                                <%--<button type="submit" class="btn btn-primary" >Set</button>--%>
                                <%--</form:form>--%>

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
                                                        <h2 class="name"><a href="#">${goods.name}</a>
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
                                                                <%--<table border="1">--%>

                                                                <%--<c:forEach items="${currentCategory.parameters}" var="catpar">--%>
                                                                <%--<tr>--%>
                                                                <%--${catpar.name}--%>
                                                                <%--</tr>--%>
                                                                <%--</c:forEach>--%>
                                                                <%--</table>--%>
                                                            <c:forEach items="${goods.goodsParameterList}"
                                                                       var="params">
                                                                <span class="value">${params.parameter.name}: </span>


                                                                <%--<c:when test="${params.parameter.parameterType == 'param_num'}">--%>
                                                                <b><span
                                                                        class="value">${params.numValue}</span></b><br/>
                                                                <%--</c:when>--%>
                                                                <%--<c:otherwise>--%>
                                                                <%--<span class="value">${params.stringValue}</span>--%>
                                                                <%--</c:otherwise>--%>
                                                            </c:forEach>

                                                            <div class="description m-t-10">
                                                                Items in stock: <b> ${goods.leftCount}</b>
                                                                <br>
                                                            </div>
                                                        </div>
                                                            <%--<c:choose>--%>
                                                            <%--<c:when test="${goods.leftCount == 0}">sd'libha;rubh</c:when>--%>
                                                            <%--</c:choose>--%>
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