<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 20.05.2018
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Orders</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="body-content outer-top-xl">
    <div class="container">
        <div class="row ">
            <h2>Order Info</h2>
            <form:form modelAttribute="order" method="post">
                <div class="body-content outer-top-xs">
                    <div class="container">
                        <div class="row ">
                            <div class="shopping-cart">
                                <div class="shopping-cart-table ">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <h4>Goods in order:</h4>
                                            <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Price</th>
                                                <th>Quantity</th>
                                                <th>Sum</th>

                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${items}" var="items">
                                                <tr>
                                                    <td class="text-center">${items.goods.name}</td>
                                                    <td class="text-center">${items.goods.price}</td>
                                                    <td class="text-center">${items.count}</td>
                                                    <td class="text-center">${items.count * items.goods.price}</td>

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
                <div>
                    <div class="table">
                        <h4>Order date:
                            <a>
                                <fmt:formatDate value="${order.order_date}" pattern="dd.MM.yyyy"/>
                            </a>
                        </h4>
                    </div>
                    <div class="table"><h4>Total price: <a>$${order.sum}</a></h4></div>
                                        <div class="table">
                        <h4>Status:

                            <c:choose>
                                <c:when test="${order.status == 'PROCESSING'}">
                                    <font color="blue"><span class="cart-product-info center-block">Processing</span></font>
                                </c:when>
                                <c:when test="${order.status == 'PENDING_PAYMENT'}">
                                    <font color="red"><span class="cart-product-info center-block">Waiting for payment</span></font>
                                </c:when>
                                <c:when test="${order.status == 'PENDING_SHIPPING'}">
                                    <font color="#483d8b"><span class="cart-product-info center-block">Waiting for shipping</span></font>
                                </c:when>

                                <c:when test="${order.status == 'SHIPPED'}">
                                    <font color="green"><span class="cart-product-info center-block">Shipped</span></font>
                                </c:when>
                                <c:when test="${order.status == 'DELIVERED'}">
                                    <font color="blue"><span class="cart-product-info center-block">Issued to Consumer</span></font>
                                </c:when>
                                <c:otherwise>
                                    <span class="cart-product-info center-block">${order.status}</span>
                                </c:otherwise>
                            </c:choose>
                            <br>
                            <a href="<c:url value='/changeorderstatus?id=${order.id}'/>" class="btn btn-primary btn-sm">Push order Status</a>
                        </h4>
                    </div>

                </div>
                <i hidden>
                    <form:input path="user.id" type="user.id"/>
                </i>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
