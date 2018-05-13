<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 02.05.2018
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index</title>
  </head>
  <body>
        <input type="button" class="button" value="Show Users List" onclick="location.href=' ${pageContext.request.contextPath}/list'" />
        <input type="button" class="button" value="Show Goods List" onclick="location.href=' ${pageContext.request.contextPath}/goodslist'" />
        <input type="button" class="button" value="Sign Up" onclick="location.href=' ${pageContext.request.contextPath}/signup'" />
  </body>
</html>
