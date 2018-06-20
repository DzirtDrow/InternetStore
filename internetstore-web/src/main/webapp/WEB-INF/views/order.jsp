<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 19.05.2018
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Order</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="body-content outer-top-xl">
    <div class="container">
        <div class="row">
            <h2>Order Info</h2>
            <form:form modelAttribute="order" method="post">
            <div class="body-content outer-top-xs">
                <div class="container">
                    <div class="row ">
                        <div class="shopping-cart">
                            <div class="shopping-cart-table ">
                                <h5>Order id: ${order.id}</h5>
                                <div class="table-responsive">
                                    <table class="table">
                                            <%--<table class="table table-hover">--%>
                                        <thead>
                                        <tr>
                                            <th>Goods name</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Total price</th>

                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${items}" var="items">
                                            <tr>
                                                <td class="text-center">${items.goods.name}</td>
                                                <td class="text-center">$${items.goods.price}</td>
                                                <td class="text-center">${items.count}</td>
                                                <td class="text-center">$${items.count * items.goods.price}</td>

                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br/>
            <div class='col-lg-offset-4 col-lg-5'>
                <div class="detail-block">
                    <div class="table">
                        <h4>Order date:
                            <a><fmt:formatDate value="${order.order_date}" pattern="dd.MM.yyyy"/>
                            </a>
                        </h4>
                    </div>

                    <div class="table"><h4>Total price: <a>$${order.sum}</a></h4></div>
                    <div class="table"><h4>Status: <a>
                        <c:choose>
                            <c:when test="${order.status == 'PROCESSING'}">
                                <font color="blue"><span class="cart-product-info center-block">Processing</span></font>
                            </c:when>
                            <c:when test="${order.status == 'PENDING_PAYMENT'}">
                                <font color="red"><span
                                        class="cart-product-info center-block">Waiting for payment</span></font>
                            </c:when>
                            <c:when test="${order.status == 'PENDING_SHIPPING'}">
                                <font color="#483d8b"><span
                                        class="cart-product-info center-block">Waiting for shipping</span></font>
                            </c:when>

                            <c:when test="${order.status == 'SHIPPED'}">
                                <font color="green"><span class="cart-product-info center-block">Shipped</span></font>
                            </c:when>
                            <c:when test="${order.status == 'DELIVERED'}">
                                <font color="blue"><span
                                        class="cart-product-info center-block">Issued to Consumer</span></font>
                            </c:when>
                            <c:otherwise>
                                <span class="cart-product-info center-block">${order.status}</span>
                            </c:otherwise>
                        </c:choose>
                    </a></h4></div>


                    <c:choose>
                        <c:when test="${order.status == 'PENDING_PAYMENT' && order.paymentMethod == 'CASH'}">
                            <div class="form-group">

                                <label class="info-title">Payment method: </label>
                                <form:select cssClass="form-control selection-handle" items="${paymentmethods}"
                                             path="paymentMethod"/>
                            </div>
                            <div class="form-group">
                                <label class="info-title">Delivery type: </label>
                                <form:select cssClass="form-control selection-handle" items="${deliverytypes}"
                                             path="deliveryType"/>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">Continue Order</button>
                            </div>
                        </c:when>
                        <c:when test="${order.status == 'PENDING_PAYMENT' && order.paymentMethod == 'CARD'}">
                            <div class="form-group">
                                <label class="info-title">Payment method: <b>${order.paymentMethod}</b></label>

                            </div>
                            <div class="form-group">
                                <label class="info-title">Delivery type: <b>${order.deliveryType}</b></label>

                            </div>
                            <a class="btn  btn-primary " href="<c:url value='/orderPay?id=${order.id}'/> "> PAY WITH CARD </a>
                        </c:when>
                        <c:otherwise>
                            <div class="form-group">
                                <label class="info-title">Payment method: <b>${order.paymentMethod}</b></label>

                            </div>
                            <div class="form-group">
                                <label class="info-title">Delivery type: <b>${order.deliveryType}</b></label>

                            </div>
                        </c:otherwise>
                    </c:choose>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
