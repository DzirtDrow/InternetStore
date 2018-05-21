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
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<%--<div class="body-content outer-top-xl">--%>
    <%--<div class="container">--%>
        <%--<div class="row ">--%>
            <%--<form:form modelAttribute="order" method="post">--%>
                <%--<div class="row">--%>
                    <%--Date: <h4>${order.order_date}</h4>--%>
                <%--</div>--%>
                <%--<div class="row">--%>
                    <%--Price: <h4>$${order.sum}</h4>--%>
                <%--</div>--%>
                <%--<div class="row">--%>
                    <%--Status:--%>
                    <%--<select class="selectpicker" data-width="fit" data-id="${order.id}">--%>
                        <%--&lt;%&ndash;<option value="option1"> OPtion 1</option>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<option value="option2"> OPtion 2</option>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<option value="option3"> OPtion 3</option>&ndash;%&gt;--%>
                        <%--<c:forEach items="${orderStatuses}" var="orderStatus">--%>
                            <%--<option value="${orderStatus}" ${order.status.equals(orderStatus) ? 'selected' : ''}>${orderStatus}</option>--%>
                        <%--</c:forEach>--%>
                    <%--</select>--%>
                <%--</div>--%>
                <%--&lt;%&ndash;<c:choose>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<c:when test="${order.status == 'PENDING_PAYMENT'}">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<a href="<c:url value='/orderPay?id=${order.id}'/> "> PAY </a>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;&lt;%&ndash;<div class="form-actions floatRight">&ndash;%&gt;&ndash;%&gt;--%>
                                <%--&lt;%&ndash;&lt;%&ndash;<input type="submit" value="Pay" class="btn btn-primary btn-sm">&ndash;%&gt;&ndash;%&gt;--%>
                                <%--&lt;%&ndash;&lt;%&ndash;</div>&ndash;%&gt;&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</c:when>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</c:choose>&ndash;%&gt;--%>


            <%--</form:form>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

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
                <div class="table">
                    <h4>Status:
                    <select class="selectpicker" data-width="fit" data-id="${order.id}">
                            <%--<option value="option1"> OPtion 1</option>--%>
                            <%--<option value="option2"> OPtion 2</option>--%>
                            <%--<option value="option3"> OPtion 3</option>--%>
                        <c:forEach items="${orderStatuses}" var="orderStatus">
                            <option value="${orderStatus}" ${order.status.equals(orderStatus) ? 'selected' : ''}>${orderStatus}</option>
                        </c:forEach>
                    </select>
                    </h4>
                </div>
                <%--<div class="table"><h4>Status: <a>${order.status}</a></h4></div>--%>
                <%--<div class="row">--%>

            </div>
                <div class="form-actions floatRight">
                    <input type="submit" value="Save changes" class="btn btn-primary btn-sm">
                </div>
                <%--</div>--%>
                </form:form>
        </div>
    </div>
</div>

</body>
</html>
