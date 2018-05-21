<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>--%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
    <link href="<c:url value='/static/css2/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css2/app.css' />" rel="stylesheet"></link>
</head>

<body>
<%@include file="authheader.jsp" %>
<%--<div class="generic-container">--%>
    <%--<div class="panel panel-default">--%>
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
                <th>Role</th>
                <th>Birthdate</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>${user.date}</td>
                    <td><a href="" class="btn btn-success custom-width">Orders</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    <%--</div>--%>
<%--</div>--%>
<h5>User: ${loggedinuser}</h5>
<p>Time: ${time}</p>
</body>
</html>