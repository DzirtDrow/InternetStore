<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 20.05.2018
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Manage orders</title>
</head>
<body>
<%@include file="header.jsp" %>

<div class="body-content outer-top-xs">
    <div class="container">
        <div class="row ">
            <div class="shopping-cart">
                <div class="shopping-cart-table ">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>

                                <th class="cart-product-name item">Order Date</th>
                                <th class="cart-description item">User</th>
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
                                        <h4 class='cart-product-description'><a href="manageoneorder?id=${orders.id}">${orders.order_date}</a>
                                        </h4>
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="rating rateit-small"></div>
                                            </div>

                                        </div>
                                    </td>


                                    <td class="cart-product-name-info">
                                        <h4 class='cart-product-description'><a href="#">${orders.user.name}</a>
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
                                        <%--<span class="cart-product-info center-block">${orders.status}</span>--%>
                                            <c:choose>
                                                <c:when test="${orders.status == 'PROCESSING'}">
                                                    <font color="blue"><span class="cart-product-info center-block">Processing</span></font>
                                                </c:when>
                                                <c:when test="${orders.status == 'PENDING_PAYMENT'}">
                                                    <font color="red"><span class="cart-product-info center-block">Waiting for payment</span></font>
                                                </c:when>
                                                <c:when test="${orders.status == 'PENDING_SHIPPING'}">
                                                    <font color="#483d8b"><span class="cart-product-info center-block">Waiting for shipping</span></font>
                                                </c:when>

                                                <c:when test="${orders.status == 'SHIPPED'}">
                                                    <font color="green"><span class="cart-product-info center-block">Shipped</span></font>
                                                </c:when>
                                                <c:when test="${orders.status == 'DELIVERED'}">
                                                    <font color="blue"><span class="cart-product-info center-block">Issued to Consumer</span></font>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="cart-product-info center-block">${orders.status}</span>
                                                </c:otherwise>
                                            </c:choose>
                                    </td>


                                    <td>
                                        <a href="<c:url value='/manageoneorder?id=${orders.id}'/>"
                                           class="btn btn-upper btn-primary center-block">Manage Order</a>
                                    </td>

                                </tr>
                            </c:forEach>
                            </tbody><!-- /tbody -->
                        </table><!-- /table -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
