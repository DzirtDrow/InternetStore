<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 13.05.2018
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="<a class="vglnk" href="http://java.sun.com/jsp/jstl/core"%" rel="nofollow"><span>http</span><span>://</span><span>java</span><span>.</span><span>sun</span><span>.</span><span>com</span><span>/</span><span>jsp</span><span>/</span><span>jstl</span><span>/</span><span>core</span><span>"%</span></a>>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AccessDenied page</title>
</head>
<body>
<div class="generic-container">
    <div class="authbar">
        <span>Dear <strong>${loggedinuser}</strong>, Access to this page Denied.</span>
        <span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>

    </div>
</div>
</body>
</html>