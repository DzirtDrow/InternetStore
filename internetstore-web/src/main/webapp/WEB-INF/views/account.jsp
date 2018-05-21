<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Account</title>
</head>
<body>
<%--<%@include file="header.jsp"%>--%>
<%--<form:form modelAttribute="user" class="form-horizontal" method="post">--%>

<%--${user.name}<br>--%>
<%--${user.email}--%>

<%--<div class="row">--%>
<%--<div class="form-actions floatRight">--%>
<%--<input type="submit" value="Save changes" class="btn btn-primary btn-sm">--%>
<%--</div>--%>
<%--</div>--%>

<%--</form:form>--%>

<%--</body>--%>
<%--</html>--%>

<%--<html>--%>
<%--<head>--%>
<%--<title>Registration</title>--%>
<%--</head>--%>
<%--<body>--%>
<%@include file="header.jsp" %>


<!-- Show my account -->
<div class="body-content">
    <div class="container">
        <div class="sign-in-page col-md-4 col-sm-4">
            <%--<div class="col-md-2 col-sm-2 create-new-account">--%>
            <h4 class="checkout-subtitle">My Account</h4>
            <p class="text title-tag-line">Change your personal data</p>
            <form:form class="register-form outer-top-xs" role="form" modelAttribute="user" method="post">
                <div class="form-group">
                    <label class="info-title">Name </label>
                    <form:input path="name" type="name" class="form-control unicase-form-control text-input"
                                readonly="true"/>
                        <%--<input type="text" class="">--%>
                </div>
                <div class="form-group">
                    <label class="info-title">Email Address </label>
                    <form:input path="email" type="email" class="form-control unicase-form-control text-input"
                                readonly="true"/>

                </div>

                <div class="form-group">
                    <label class="info-title">Last name </label>
                    <form:input path="lastName" type="lastName" class="form-control unicase-form-control text-input"/>
                        <%--<input type="text" class="">--%>
                </div>


                <%--<div class="form-group">--%>
                <%--<label class="info-title">Address </label>--%>
                <%--<input type="text" name="addr" value="${user.address.address}"--%>
                <%--class="form-control unicase-form-control text-input"/>--%>
                <%--&lt;%&ndash;<form:input path="address.address" type="address" class="form-control unicase-form-control text-input"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<input type="text" class="">&ndash;%&gt;--%>
                <%--</div>--%>
                <i hidden>

                    <form:input path="password" type="password"/>
                    <form:input path="id" type="id"/>
                    <form:input path="role" type="role"/>
                </i>


                <%--<div class="form-group">--%>
                <%--<label class="info-title">Address </label>--%>
                <%--<form:input path="${address}" type="text"--%>
                <%--class="form-control unicase-form-control  text-input"/>--%>
                <%--&lt;%&ndash;<input type="text" class="">&ndash;%&gt;--%>
                <%--</div>--%>

                <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Edit</button>

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
