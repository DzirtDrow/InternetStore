<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 13.05.2018
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<h2>Custom Form based Login Page</h2>

<form action="${pageContext.request.contextPath}/login" method="post">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type='text' name='username' /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'></td>
        </tr>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
