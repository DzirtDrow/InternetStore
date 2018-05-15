<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form modelAttribute="user" class="form-horizontal" method="post">

    <div class="row">
        Name(Login): <form:input type="text" path="name" id="name"/>
    </div>
    <div class="row">
        Last name: <form:input type="text" path="lastname" id="name"/>
    </div>
    <div class="row">
        Email: <form:input type="text" path="email" id="name"/>
    </div>

    <div class="row">
        Password: <form:input type="text" path="password" id="price"/>
    </div>

    <div class="row">
        Confirm password: <form:input type="text" path="confirmPassword" id="price"/>
    </div>

    <div class="row">
        <div class="form-actions floatRight">
            <input type="submit" value="Register" class="btn btn-primary btn-sm">
        </div>
    </div>
</form:form>
</body>
</html>
