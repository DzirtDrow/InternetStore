<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 13.05.2018
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<div class="body-content">
    <div class="container">
        <div class="sign-in-page col-md-4 col-sm-4">
            <h4 class="">Login</h4>
            <p class="">Hello, Welcome to your account.</p>
            <div class="social-sign-in outer-top-xs">
            </div>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="text-danger">
                    <div class="error text-danger">${error}</div>
                    <%--<div class="error">${param.error}</div>--%>
                </div>
                <%--<table>--%>
                <%--<tr>--%>

                <div class="form-group">
                    <label class="info-title" for="username">Username: <span>*</span></label>
                    <input type='text' name='username' class="form-control unicase-form-control text-input"
                           id="username"/>
                </div>
                <%--</tr>--%>
                <%--<tr>--%>
                <div class="form-group">
                    <label class="info-title" for="password">Password: <span>*</span></label>
                    <input type='password' name='password' class="form-control unicase-form-control text-input"
                           id="password"/>
                    <%--<label class="info-title" for="password">Password <span>*</span></label>--%>
                    <%--<input type="password" name="password" class="form-control unicase-form-control text-input" id="password" >--%>
                    <%--</tr>--%>
                </div>
                <div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
                <div class="form-group outer-xs">
                    <%--<div><input name="submit" type="submit" value="Login" class="btn btn-black"></div>--%>
                    <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Login</button>
                    <a href="<c:url value='/signup'/>" class="btn-link pull-right"> Registration</a>
                </div>

                <%--</table>--%>

                <%--<div class="form-group">--%>
                <%--<label class="info-title" for="name">Name <span>*</span></label>--%>
                <%--<input type="text" name="name" class="form-control unicase-form-control text-input" id="name" >--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                <%--<label class="info-title" for="password">Password <span>*</span></label>--%>
                <%--<input type="password" name="password" class="form-control unicase-form-control text-input" id="password" >--%>
                <%--</div>--%>
                <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
                <%--<div ><input name="submit" type="submit" value="Login" class="btn btn-black"></div>--%>
                <%--<div colspan="2"><a href="<c:url value='/signup'/>" class="btn-link  pull-right"> Registration</a></div>--%>
            </form>
        </div>
    </div>
</div>
</body>
</html>
