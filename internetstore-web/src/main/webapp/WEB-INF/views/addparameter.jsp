<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 17.06.2018
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Add parameter</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="body-content">
    <div class="container">
        <div class="sign-in-page col-md-4 col-sm-4">
            <h4 class="checkout-subtitle">Add new Parameter</h4>

            <form:form class="register-form outer-top-xs" role="form" modelAttribute="newparameter" method="post">
                <%--<form:errors path="*" cssClass="error" element="div"/>--%>
                <div class="form-group">
                    <label class="info-title">Paremeter type: </label>
                    <%--<form:select cssClass="dropdown" path="parameterType">--%>
                        <%--&lt;%&ndash;<form:options items="${parametertypes}"  itemLabel="name"/>&ndash;%&gt;--%>
                    <%--</form:select>--%>
                    <form:select cssClass="form-control selection-handle"
                                 items="${parametertypes}" var="type" path="parameterType"/>

                </div>

                <div class="form-group">
                    <label class="info-title">Name </label>
                    <form:input path="name" type="name" class="form-control unicase-form-control text-input" />
                </div>


                <div class="form-group">
                    <label class="info-title">Description </label>
                    <form:input path="description" type="descriptiom"
                                class="form-control unicase-form-control text-area"/>
                </div>
                <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Add</button>

            </form:form>


        </div>
    </div>
</div>
</body>
</html>
