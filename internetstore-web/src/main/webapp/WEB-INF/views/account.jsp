<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 20.05.2018
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<%@include file="header.jsp"%>
<form:form modelAttribute="user" class="form-horizontal" method="post">

    ${user.name}<br>
    ${user.email}

    <div class="row">
        <div class="form-actions floatRight">
            <input type="submit" value="Save changes" class="btn btn-primary btn-sm">
        </div>
    </div>

</form:form>

</body>
</html>
