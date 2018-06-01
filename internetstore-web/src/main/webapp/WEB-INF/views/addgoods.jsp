<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 08.05.2018
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Add Goods</title>
</head>
<body>
<%@include file="header.jsp" %>

<div class="body-content">
    <div class="container">
        <div class="sign-in-page col-md-4 col-sm-4">
            <h4 class="checkout-subtitle">Add new Goods</h4>
            <p class="text title-tag-line">Adding new Goods</p>

            <form:form class="register-form outer-top-xs" role="form" modelAttribute="goods" method="post">
                <div class="form-group">
                    <label class="info-title">Category </label>
                    <form:select cssClass="dropdown" path="category.id">
                        <form:options items="${categories}" itemValue="id" itemLabel="name"/>
                    </form:select>
                </div>

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
                    <form:input path="description" type="descriptiom"
                                class="form-control unicase-form-control text-area"/>
                </div>
                <div class="form-group">
                    <label class="info-title">Quantity </label>
                    <form:input path="leftCount" type="number" class="form-control unicase-form-control text-input"/>

                </div>

                <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Add</button>

            </form:form>


        </div>
    </div>
</div>
</body>
</html>
