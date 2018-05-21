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
                                        <h4 class='cart-product-description'><a href="order?id=${orders.id}">${orders.order_date}</a>
                                        </h4>
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="rating rateit-small"></div>
                                            </div>

                                        </div>
                                    </td>

                                    <td class="cart-product-sub-total">
                                        <span class="cart-sub-total-price">$${orders.sum}</span>
                                    </td>

                                    <td>
                                        <c:choose>
                                            <c:when test="${orders.status == 'PENDING_PAYMENT'}">
                                                <font color="red"><span class="cart-product-info center-block">${orders.status}</span></font>
                                            </c:when>
                                            <c:when test="${orders.status == 'SHIPPED'}">
                                                <font color="green"><span class="cart-product-info center-block">${orders.status}</span></font>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="cart-product-info center-block">${orders.status}</span>
                                            </c:otherwise>
                                        </c:choose>

                                    </td>


                                    <td>
                                        <a href="<c:url value='/order?id=${orders.id}'/>"
                                           class="btn  btn-primary ">Order Page</a>
                                        <a href="<c:url value='#'/>"
                                           class="btn  btn-primary " disabled="true">Reorder</a>

                                    </td>

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
