<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 15.06.2018
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manage Categories</title>
</head>
<body>
<%@include file="header.jsp" %>
<br/>
<div class='col-lg-offset-2 col-lg-3'>
    <div class="detail-block">
        <table class="table-bordered">
            <h4>Categories</h4>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categories}" var="category">

                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td><a href="<c:url value='/editcategory?id=${category.id}'/>" class="btn-primary">Edit</a>
                        <a href="<c:url value='/deletecategory?id=${category.id}'/>" class="btn-primary">Delete</a></td>
                </tr>
                <%--<a href="#" class="btn btn-primary">Edit</a>--%>
            </c:forEach>
            </tbody>
        </table>
        <a href="<c:url value='/addcategory'/>" class="btn">Add new Category</a>
    </div>
</div>


</body>
</html>
