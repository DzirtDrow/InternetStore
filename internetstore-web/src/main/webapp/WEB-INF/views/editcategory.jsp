<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 15.06.2018
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<%@include file="header.jsp" %>
<br/>
<div class='col-lg-offset-2 col-lg-5'>
    <div class="detail-block">
Category name: <h3>${category.name}</h3>
<a href="<c:url value='/managecategories'/>">Categories managment</a><br/><br/>
<b>Category parameters:</b>

<table border="1">
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Description</th>
    <th>Type</th>
    <th>Actions</th>
    </thead>
    <tbody>
    <c:forEach items="${parameters}" var="par">
        <tr>
            <td>${par.id}</td>
            <td>${par.name}</td>
            <td>${par.description}</td>
            <td>${par.parameterType}</td>
            <td>
                <a href="<c:url value='/deleteparamfromcategory?idparam=${par.id}&idcategory=${category.id}'/>">Delete</a>
            </td>
        </tr>

    </c:forEach>

    </tbody>
</table>
<br/>
<br/>
Possible parameters (you can add):
<table border="1">
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Description</th>
    <th>Type</th>
    <th>Actions</th>
    </thead>
    <tbody>
    <c:forEach items="${possibleParameters}" var="pospar">
        <tr>
            <td>${pospar.id}</td>
            <td>${pospar.name}</td>
            <td>${pospar.description}</td>
            <td>${pospar.parameterType}</td>
            <td>
                <a href="<c:url value='/addparamtocategory?idparam=${pospar.id}&idcategory=${category.id}'/>">Add to category</a>
            </td>
        </tr>

    </c:forEach>

    <tr>

        <td colspan="5"><a href="<c:url value='/addparamteter'/>">Add new parameter</a>
        </td>
    </tr>
    </tbody>
</table>
    </div></div>
</body>
</html>
