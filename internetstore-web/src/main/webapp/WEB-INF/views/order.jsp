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
            <form:form modelAttribute="order" method="post">
                <div class="row">
                    Date: <h4>${order.order_date}</h4>
                </div>
                <div class="row">
                    Price: <h4>$${order.sum}</h4>
                </div>
                <div class="row">
                    Status: <h4>${order.status}</h4>
                </div>
                <c:choose>
                    <c:when test="${order.status == 'PENDING_PAYMENT'}">
                        <div class="row">
                            <a href="<c:url value='/orderPay?id=${order.id}'/> "> PAY </a>
                            <%--<div class="form-actions floatRight">--%>
                                <%--<input type="submit" value="Pay" class="btn btn-primary btn-sm">--%>
                            <%--</div>--%>
                        </div>
                    </c:when>
                </c:choose>


            </form:form>
        </div>
    </div>
</div>
</body>
</html>
