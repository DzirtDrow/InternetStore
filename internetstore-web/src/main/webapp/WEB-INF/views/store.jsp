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
<%--<table class="table table-bordered glyphicon-align-right">--%>
    <%--<thead>--%>
    <%--<tr>--%>
        <%--<th>Name</th>--%>

    <%--</tr>--%>
    <%--</thead>--%>
    <%--<tbody>--%>
    <%--<c:forEach items="${cartItems}" var="cartItems">--%>
        <%--<tr>--%>
            <%--<td>${cartItems.goods.name}</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</tbody>--%>
</table>
<%--<div class="generic-container">--%>
<%--<div class="panel panel-default">--%>
<!-- Default panel contents -->
<input type="button" class="button" value="Back" onclick="location.href=' ${pageContext.request.contextPath}/ '"/>
<div class="panel-heading"><span class="lead">List of Goods </span></div>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Actions</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${goods}" var="goods">
        <tr>
            <td>${goods.name}</td>
            <td>${goods.price}</td>
            <td>${goods.description}</td>
            <td>
                <a href="addtocart?id=${goods.id}" class="btn btn-success">Add to cart</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--</div>--%>
<%--</div>--%>
</body>
</html>