<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 08.05.2018
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Add Goods</title>
</head>
<body>
<%@include file="header.jsp"%>
<%--<form:form modelAttribute="goods" class="form-horizontal" method="post">--%>
    <%--<div class="row">--%>
        <%--Name: <form:input type="text" path="name" id="name"/>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
        <%--Price(cent): <form:input type="number" path="price" id="price"/>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
        <%--<div class="form-actions floatRight">--%>
            <%--<input type="submit" value="Add goods" class="btn btn-primary btn-sm">--%>
        <%--</div>--%>
    <%--</div>--%>

<%--</form:form>--%>


<div class="body-content">
    <div class="container">
        <div class="sign-in-page col-md-4 col-sm-4">
            <%--<div class="col-md-2 col-sm-2 create-new-account">--%>
            <h4 class="checkout-subtitle">Add new Goods</h4>
            <p class="text title-tag-line">Adding new Goods</p>
            <form:form class="register-form outer-top-xs" role="form" modelAttribute="goods" method="post">
                <div class="form-group">
                    <label class="info-title">Name </label>
                    <form:input path="name" type="name" class="form-control unicase-form-control text-input"/>
                </div>
                <div class="form-group">
                    <label class="info-title">Price </label>
                    <form:input path="price" type="number" class="form-control unicase-form-control text-input"/>

                </div>

                <div class="form-group">
                    <label class="info-title">Description </label>
                    <form:input path="description" type="descriptiom" class="form-control unicase-form-control text-area"/>
                        <%--<input type="text" class="">--%>
                </div>


                <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Add</button>

            </form:form>


            <%--</div>--%>
        </div>
    </div>
</div>
</body>
</html>
