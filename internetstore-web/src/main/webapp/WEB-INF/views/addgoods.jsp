<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 08.05.2018
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Add Goods</title>
</head>
<body>

<form:form modelAttribute="goods" class="form-horizontal" method="post">
    <div class="row">
        Name: <form:input type="text" path="name" id="name"/>
    </div>

    <div class="row">
        Price(cent): <form:input type="text" path="price" id="price"/>
    </div>

    <div class="row">
        <div class="form-actions floatRight">
            <input type="submit" value="Add goods" class="btn btn-primary btn-sm">
        </div>
    </div>

</form:form>

</body>
</html>
