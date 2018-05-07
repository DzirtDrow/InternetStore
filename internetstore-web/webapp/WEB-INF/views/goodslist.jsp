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
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<%--<div class="generic-container">--%>
<%--<div class="panel panel-default">--%>
<!-- Default panel contents -->
<div class="panel-heading"><span class="lead">List of Goods </span></div>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Actions</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${goods}" var="goods">
        <tr>
            <td>${goods.name}</td>
            <td>${goods.price}</td>
            <td>
                <a href="deleteGoods?id=${goods.id}" class="button">Delete</a>

                <a class="button">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--</div>--%>
<%--</div>--%>
<div id="add">
    <h1> Add Goods </h1>

    <c:url var="addAction" value="/addGoods" />
    <form:form action="${addAction}" modelAttribute="newGoods">
        <table>
            <tr>
                <th colspan="2">Add goods</th>
            </tr>
            <tr>
                <td><form:label path="id">id</form:label></td>
                <td><form:input path="id" readonly="true" size="8"  disabled="true" />
                    <%--<form:hidden path="employeeId" />--%>
                </td>
            </tr>
            <tr>
                <td><form:label path="name">Goods Name:</form:label></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td><form:label path="price">Price:</form:label></td>
                <td><form:input path="price"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" class="blue-button" /></td>

            </tr>
        </table>
    </form:form>


    <%--<form action="AppController" method="POST" att>--%>
        <%--<table>--%>
            <%--<tr>--%>
                <%--<td> Goods Name:</td>--%>
                <%--<td><input type="text" name="name"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td> Goods Price:</td>--%>
                <%--<td><input type="text" name="price"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td><input type="submit" name="addGoods" value="Add"></td>--%>

            <%--</tr>--%>
        <%--</table>--%>
    <%--</form>--%>
</div>


</body>
</html>