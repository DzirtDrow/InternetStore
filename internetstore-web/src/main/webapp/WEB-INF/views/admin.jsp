<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 21.05.2018
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<input type="button" class="button" value="Show Users List"
       onclick="location.href=' ${pageContext.request.contextPath}/list'"/>
<input type="button" class="button" value="Show Goods List"
       onclick="location.href=' ${pageContext.request.contextPath}/goodslist'"/>
<%--<input type="button" class="button" value="Show Store"--%>
<%--onclick="location.href=' ${pageContext.request.contextPath}/store'"/>--%>
<br>
<br>
<br>
<input type="button" class="button" value="Sign Up"
       onclick="location.href=' ${pageContext.request.contextPath}/signup'"/>
<input type="button" class="button" value="Login" onclick="location.href=' ${pageContext.request.contextPath}/login'"/>

<input type="button" class="button" value="Orders Managment" onclick="location.href=' ${pageContext.request.contextPath}/manageorders'"/>


</body>
</html>
