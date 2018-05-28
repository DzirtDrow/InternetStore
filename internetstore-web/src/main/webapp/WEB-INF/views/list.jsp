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

</head>

<body>
<%@include file="header.jsp" %>
<div class="panel-heading"><span class="lead">List of Users </span></div>

<div class="body-content outer-top-xs">
    <div class="container">
        <div class="row ">
            <div class="shopping-cart">
                <div class="shopping-cart-table ">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Firstname</th>
                                <th>Lastname</th>
                                <th>Email</th>
                                <th>Role</th>
                                <th>Action</th>
                            </tr>
                            </thead><!-- /thead -->
                            <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td class="center">${user.name}</td>
                                    <td>${user.lastname}</td>
                                    <td>${user.email}</td>
                                    <td>${user.role}</td>
                                    <td><a href="<c:url value='/edituserbyadmin?id=${user.id}'/>" class="btn btn-success custom-width">Edit User</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table><!-- /table -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>