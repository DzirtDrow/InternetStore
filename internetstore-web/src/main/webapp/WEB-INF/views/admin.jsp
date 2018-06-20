<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 21.05.2018
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<div class="body-content">
    <div class="container">
        <div class="sign-in-page col-md-4 col-sm-4">

            <%--<div class="checkout-progress-sidebar ">--%>
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="unicase-checkout-title">Admin and manager actions</h4>
                        </div>
                        <div class="">
                            <ul class="nav nav-checkout-progress">
                                <li><a class="btn-link" href="${pageContext.request.contextPath}/manageorders">Orders Managment</a></li>
                                <li><a class="btn-link" href="${pageContext.request.contextPath}/managecategories">Categories Managment</a></li>
                                <li><a class="btn-link" href="${pageContext.request.contextPath}/goodslist">Goods Managment</a></li>
                                <li><a class="btn-link" href="${pageContext.request.contextPath}/list">Users Managment</a></li>
                                <li><a class="btn-link" href="${pageContext.request.contextPath}/promo/promotionlist">Promotions Managment</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            <%--</div>--%>

                <%--<input type="button" class="btn-primary " value="Orders Managment"--%>
                <%--onclick="location.href=' ${pageContext.request.contextPath}/manageorders'"/>--%>
                <%--<br><br>--%>
                <%--<input type="button" class="btn-primary" value="Show Users List"--%>
                <%--onclick="location.href=' ${pageContext.request.contextPath}/list'"/>--%>
                <%--<br><br>--%>
                <%--<input type="button" class="btn-primary" value="Show Goods List"--%>
                <%--onclick="location.href=' ${pageContext.request.contextPath}/goodslist'"/>--%>

                <%--<br><br>--%>

        </div>
    </div>
</div>

</body>
</html>
