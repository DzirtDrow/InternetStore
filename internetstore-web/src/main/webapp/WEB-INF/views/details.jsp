<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 21.05.2018
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Goods Details</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="products">
    <div class="product-list product">
        <div class="row product-list-row">
            <div class="col col-sm-4 col-lg-2">
                <div class="product-image">
                    <img src="<c:url value='/static/images/products/p1.jpg'/>" height="110">
                </div>
            </div>
            <!-- /.col -->
            <div class="col col-sm-8 col-lg-8">
                <div class="product-info">
                    <h3 class="name">${goods.name}
                    </h3>
                    <div class="rating rateit-small"></div>
                    <div class="product-price"><span
                            class="price">Price:  $${goods.price}</span>
                    </div>
                    <!-- /.product-price -->
                    <div class="description m-t-10">
                        ${goods.description}
                        <br>
                    </div>
                    <div class="action">
                        <a href="addtocart?id=${goods.id}" class="btn btn-primary btn-black">Add to cart</a>
                    </div>
                    <!-- /.cart -->

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
