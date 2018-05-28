<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 22.05.2018
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>

<%@include file="header.jsp" %>
<!-- Show user -->
<div class="body-content">
    <div class="container">
        <div class="sign-in-page col-md-4 col-sm-4">
            <h4 class="checkout-subtitle">My Account</h4>
            <p class="text title-tag-line">Change your personal data</p>
            <form:form class="register-form outer-top-xs" role="form" modelAttribute="user" method="post">
                <div class="form-group">
                    <label class="info-title">Email Address </label>
                    <form:input path="email" type="email" class="form-control unicase-form-control text-input"
                                readonly="true"/>

                </div>
                <div class="form-group">
                    <label class="info-title">Name </label>
                    <form:input path="name" type="name" class="form-control unicase-form-control text-input"
                                readonly="true"/>
                        <%--<input type="text" class="">--%>
                </div>
                <div class="form-group">
                    <label class="info-title">Last name </label>
                    <form:input path="lastname" type="lastname" class="form-control unicase-form-control text-input"
                                readonly="true"/>
                        <%--<input type="text" class="">--%>
                </div>

                <div class="form-group">
                    <label class="info-title">Role </label>
                    <form:select cssClass="form-control selection-handle" items="${roles}" var="type" path="role"/>
                </div>

                <i hidden>

                    <form:input path="password" type="password"/>
                    <form:input path="id" type="id"/>
                </i>

                <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Edit</button>

            </form:form>

            <%--</div>--%>
        </div>
    </div>
</div>
</body>
</html>
