<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<%@include file="header.jsp" %>


<!-- create a new account -->
<div class="body-content">
    <div class="container">
        <div class="sign-in-page col-md-4 col-sm-4">
            <%--<div class="col-md-2 col-sm-2 create-new-account">--%>
                <h4 class="checkout-subtitle">Create a new account</h4>
                <p class="text title-tag-line">Create your new account.</p>
                <form:form class="register-form outer-top-xs" role="form" modelAttribute="user" method="post">
                    <div class="form-group">
                        <label class="info-title">Email Address <span>*</span></label>
                        <form:input path="email" type="email" class="form-control unicase-form-control text-input"/>
                    </div>
                    <div class="form-group">
                        <label class="info-title">Name <span>*</span></label>
                        <form:input path="name" type="name" class="form-control unicase-form-control text-input"/>
                        <%--<input type="text" class="">--%>
                    </div>
                    <div class="form-group">
                        <label class="info-title">Password <span>*</span></label>
                        <form:input path="password" type="password" class="form-control unicase-form-control text-input"/>
                        <%--<input type="password" class="form-control unicase-form-control text-input">--%>
                    </div>
                    <div class="form-group">
                        <label class="info-title">Confirm Password <span>*</span></label>
                        <form:input path="confirmPassword" type="password" class="form-control unicase-form-control text-input"/>
                        <%--<input type="password" class="form-control unicase-form-control text-input">--%>
                    </div>
                    <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Register</button>
                </form:form>


            <%--</div>--%>
        </div>
    </div>
</div>
<!-- create a new account -->
<%--<form:form modelAttribute="user" class="form-horizontal" method="post">--%>

<%--<div class="row">--%>
<%--Name(Login): <form:input type="text" path="name" id="name"/>--%>
<%--</div>--%>
<%--<div class="row">--%>
<%--Last name: <form:input type="text" path="lastname" id="name"/>--%>
<%--</div>--%>
<%--<div class="row">--%>
<%--Email: <form:input type="text" path="email" id="name"/>--%>
<%--</div>--%>

<%--<div class="row">--%>
<%--Password: <form:input type="text" path="password" id="price"/>--%>
<%--</div>--%>

<%--<div class="row">--%>
<%--Confirm password: <form:input type="text" path="confirmPassword" id="price"/>--%>
<%--</div>--%>

<%--<div class="row">--%>
<%--<div class="form-actions floatRight">--%>
<%--<input type="submit" value="Register" class="btn btn-primary btn-sm">--%>
<%--</div>--%>
<%--</div>--%>
<%--</form:form>--%>
</body>
</html>
