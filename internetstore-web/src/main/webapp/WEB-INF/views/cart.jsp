<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>--%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Goods List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>

<body>
<%@include file="authheader.jsp" %>

<input type="button" class="button" value="Back" onclick="location.href=' ${pageContext.request.contextPath}/ '" />
<div class="panel-heading"><span class="lead">Cart</span></div>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Count</th>
        <th>Actions</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userCart}" var="cartItem">
        <tr>
            <td>${cartItem.goods.name}</td>
            <td>${cartItem.goods.price}</td>
            <td>${cartItem.count}</td>
                <%--<td>${goods.description}</td>--%>
            <td>
                <a href="deleteItemFromCart?id=${cartItem.id}" class="btn btn-success custom-width">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>