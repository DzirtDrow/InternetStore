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
    <title>Login</title>
</head>
<body>
<%@include file="header.jsp" %>

<div class="body-content">
    <div class="container">
        <div class="sign-in-page col-md-4 col-sm-4">
            <%--<div class="row">--%>
                <%--<div class="col-md-6 col-sm-6 sign-in">--%>
                    <h4 class="">Login</h4>
                    <p class="">Hello, Welcome to your account.</p>
                    <div class="social-sign-in outer-top-xs">
                    </div>
                    <form action="${pageContext.request.contextPath}/login" method="post">
                        <table>
                            <tr>
                                <td>Username:</td>
                                <td><input type='text' name='username'class="form-control unicase-form-control text-input"/></td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td><input type='password' name='password' class="form-control unicase-form-control text-input"></td>
                            </tr>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <tr>
                                <td colspan='2'><input name="submit" type="submit" value="Login" class="btn btn-black">
                                    <a href="<c:url value='/signup'/>" class="btn-link  ">   Registration</a> </td>
                            </tr>
                        </table>
                    </form>

                <%--</div>--%>
            <%--</div>--%>
        </div>
    </div>
</div>
</body>
</html>
