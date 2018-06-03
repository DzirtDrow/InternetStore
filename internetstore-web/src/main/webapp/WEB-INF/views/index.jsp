<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 02.05.2018
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Index</title>
</head>
<body>
<%@include file="header.jsp" %>

<%@include file="categories-bar.jsp" %>

<div class="body-content">
    <div class="container">
        <div class="checkout-box faq-page">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="heading-title">Welcome to Internet Shop!</h2>
                    <span class="title-tag">To get started, select the product category!</span>
                    <a href="test">TEST</a>
                    <%--<c:forEach items="${catdtolist}" var="category">--%>
                        <%--<span>${category.name}</span>--%>
                    <%--</c:forEach>--%>

                </div>
            </div><!-- /.row -->
        </div><!-- /.checkout-box -->
    </div><!-- /.container -->
</div><!-- /.body-content -->

</body>
</html>
