<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 21.05.2018
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<table border="1">
    <thead>
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
</body>
</html>
