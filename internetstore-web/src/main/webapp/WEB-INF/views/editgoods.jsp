<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 11.05.2018
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Goods</title>
</head>
<body>
<%@include file="header.jsp" %>

<%--</form:form>--%>

<form:form id="goodsform" class="register-form outer-top-xs" role="form" modelAttribute="goods" method="post">

    <div class="body-content">
        <div class="container">
            <div class="sign-in-page col-md-4 col-sm-4 ">

                <h4 class="checkout-subtitle">Goods Changing</h4>
                <p class="text title-tag-line">Change this goods

                </p>

                <div class="form-group">
                    <label class="info-title">Name </label>
                    <form:input path="name" type="name" class="form-control unicase-form-control text-input"/>
                        <%--<input type="text" class="">--%>
                </div>
                <div class="form-group">
                    <label class="info-title">Price </label>
                    <form:input path="price" type="number" class="form-control unicase-form-control text-input"/>

                </div>

                <div class="form-group">
                    <label class="info-title">Description </label>
                    <form:input path="description" type="text" class="form-control unicase-form-control text-input"/>
                        <%--<input type="text" class="">--%>
                </div>
                <div class="form-group">
                    <label class="info-title">Left Count </label>
                    <form:input path="leftCount" type="number" class="form-control unicase-form-control text-input"/>
                        <%--<input type="text" class="">--%>

                </div>

                <h5>Parameters: </h5>
                <%--<c:forEach items="${parameterss}" var="par">--%>
                <%--<div class="form-group">--%>
                    <%--<label class="info-title">${par.parameter.name}: </label>--%>

                    <%--<c:choose>--%>
                        <%--<c:when test="${par.parameter.parameterType == 'param_num'}">--%>
                            <%--<input type="number" id = "${par.parameter.name}" class="form-control unicase-form-control text-input"--%>
                                   <%--value="${par.numValue}"/>--%>
                        <%--</c:when>--%>
                        <%--<c:otherwise>--%>
                            <%--<input type="text" id = "${par.parameter.name}" class="form-control unicase-form-control text-input"--%>
                                   <%--value="${par.stringValue}"/>--%>
                        <%--</c:otherwise>--%>
                    <%--</c:choose>--%>

                <%--</div>--%>
                <%--</c:forEach>--%>

                <c:forEach items="${parameterss}" var="par">
                    <div class="form-group">
                        <label class="info-title">${par.parameter.name}: </label>

                        <c:choose>
                            <c:when test="${par.parameter.parameterType == 'param_num'}">
                                <input  type="number" id = "${par.parameter.name}" class="form-control unicase-form-control text-input"
                                       value="${par.numValue}"/>
                            </c:when>
                            <c:otherwise>
                                <input type="text" id = "${par.parameter.name}" class="form-control unicase-form-control text-input"
                                       value="${par.stringValue}" />
                            </c:otherwise>
                        </c:choose>

                    </div>
                </c:forEach>

                <script>
                    function addParameters(){
                       // alert("${parameterss}");
                    }
                </script>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary" onclick="addParameters()">Save Changes</button>
                </div>
                    <%--</div>--%>
            </div>

        </div>
    </div>
</form:form>
</body>
</html>
