<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 19.05.2018
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>
<%--User orders list--%>
<%--<br>--%>
<%--<c:forEach items="${orders}" var="orders">--%>
<%--<tr>--%>
<%--<td>${orders.id}</td>--%>
<%--&lt;%&ndash;<td>${orders.user}</td>&ndash;%&gt;--%>
<%--<td>${orders.sum}</td>--%>
<%--<td>${orders.order_date}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>


<div class="body-content outer-top-xs">
    <div class="container">
        <div class="row ">
            <div class="shopping-cart">
                <div class="shopping-cart-table ">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <%--<th class="cart-description item">Image</th>--%>
                                <th class="cart-product-name item">Order Date</th>
                                <%--<th class="cart-edit item">Edit</th>--%>
                                <th class="cart-qty item">Order Price</th>
                                <th class="cart-sub-total item">Order Status</th>
                                <th class="cart-romove item">Action</th>
                            </tr>
                            </thead><!-- /thead -->
                            <tbody>
                            <c:forEach items="${orders}" var="orders">
                                <tr>
                                    <td class="cart-product-name-info">
                                        <h4 class='cart-product-description'><a href="#">${orders.order_date}</a>
                                        </h4>
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="rating rateit-small"></div>
                                            </div>

                                        </div><!-- /.row -->
                                            <%--<div class="cart-product-info">--%>
                                            <%--<span class="product-color">COLOR:<span>Blue</span></span>--%>
                                            <%--</div>--%>
                                    </td>

                                    <td class="cart-product-sub-total"><span
                                            class="cart-sub-total-price">$${orders.sum}</span>
                                    </td>

                                    <td>Тут должен быть статус</td>


                                    <td>
                                        <a href="<c:url value='#'/>"
                                           class="btn btn-upper btn-primary center-block">Reorder</a>
                                    </td>
                                    <
                                </tr>
                            </c:forEach>
                            </tbody><!-- /tbody -->
                        </table><!-- /table -->
                    </div>
                </div><!-- /.shopping-cart-table -->


            </div><!-- /.shopping-cart -->
        </div> <!-- /.row -->
    </div><!-- /.container -->
</div><!-- /.body-content -->
</body>
</html>
