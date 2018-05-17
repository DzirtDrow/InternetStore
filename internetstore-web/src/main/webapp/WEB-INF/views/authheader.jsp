<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>

<span><a href="<c:url value="/store" />" class="btn">Go to Store</a></span>
<span><a href="<c:url value="/index" />" class="btn">Go to Home</a></span>


<div class="authbar">
    <c:choose>
        <c:when test="${loggedinuser == 'anonymousUser'}">
            <span class="bar"><a href="<c:url value="/login" />" class="btn">Login</a></span>
        </c:when>
        <c:otherwise>
            <span>Dear <strong>${loggedinuser}</strong>, Welcome!</span>
            <span><a href="<c:url value="/logout" />" class="btn">Logout</a></span>
        </c:otherwise>
    </c:choose>
    <input type="button" class="btn" value="Cart"
           onclick="location.href=' ${pageContext.request.contextPath}/cart'"/>
<br>

</div>

