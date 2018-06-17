<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 16.06.2018
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Add new category</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="body-content">
    <div class="container">
        <div class="sign-in-page col-md-4 col-sm-4">
            <h4 class="checkout-subtitle">Add new Category</h4>
            <p class="text title-tag-line">Adding new Category</p>

            <form:form class="register-form outer-top-xs" role="form" modelAttribute="newcategory" method="post">

                <div class="form-group">
                    <label class="info-title">Name </label>
                    <form:input path="name" type="name" class="form-control unicase-form-control text-input"/>

                </div>


                <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Add</button>

            </form:form>


        </div>
    </div>
</div>
</body>
</html>
