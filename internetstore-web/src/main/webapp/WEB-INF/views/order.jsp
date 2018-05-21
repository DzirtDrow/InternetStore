<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 19.05.2018
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
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
                                            <%--<table class="table table-hover">--%>
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
                                                <td>${items.goods.name}</td>
                                                <td>${items.goods.price}</td>
                                                <td>${items.count}</td>
                                                <td>${items.count * items.goods.price}</td>

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
                <div class="table"><h4>Order date: <a>${order.order_date}</a></h4>
                </div>

                <div class="table"><h4>Total price: <a>$${order.sum}</a></h4></div>

                <div class="table"><h4>Status: <a>${order.status}</a></h4></div>

                <c:choose>
                    <c:when test="${order.status == 'PENDING_PAYMENT'}">
                        <a class="btn  btn-primary " href="<c:url value='/orderPay?id=${order.id}'/> "> PAY </a>
                    </c:when>
                </c:choose>
                </form:form>
            </div>
        </div>
    </div>
</div>



</body>
</html>
