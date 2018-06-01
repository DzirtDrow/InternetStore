<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Account</title>
</head>

<%@include file="header.jsp" %>
<!-- Show my account -->
<div class="body-content">
    <div class="container">
        <div class="sign-in-page col-md-4 col-sm-4">
            <h4 class="checkout-subtitle">My Account</h4>
            <p class="text title-tag-line">Change your personal data</p>
            <form:form class="register-form outer-top-xs" role="form" modelAttribute="user" method="post"
                       name="userform">
                <div class="form-group">
                    <label class="info-title">Name </label>
                    <form:input path="name" type="text" class="form-control unicase-form-control text-input"
                                readonly="true"/>
                        <%--<input type="text" class="">--%>
                </div>
                <div class="form-group">
                    <label class="info-title">Email Address </label>
                    <form:input path="email" type="email" class="form-control unicase-form-control text-input"
                                readonly="true"/>

                </div>

                <div class="form-group">
                    <label class="info-title">Last name </label>
                    <form:input path="lastname" type="text" class="form-control unicase-form-control text-input"/>
                        <%--<input type="text" class="">--%>
                </div>

                <div class="form-group">
                    <label class="info-title">Birth Date </label>

                    <form:input type="date" class="form-control" path="date"
                                autocomplete="true"/> <%--<form:input path="date" type="date" class="form-control unicase-form-control text-input"/>--%>

                </div>
                    <div class="form-group">
                        <label class="info-title">Address </label>
                        <input id="suggest" value="${useraddress.address}" name="address" class="form-control" placeholder="Put your addres here"/>
                        <script src="//api-maps.yandex.ru/2.1/?lang=ru_RU&amp;load=SuggestView&amp;onload=onLoad"></script>
                        <script>
                            function onLoad(ymaps) {
                                var suggestView = new ymaps.SuggestView('suggest');
                            }
                        </script>
                    </div>
                <%--<div class="form-group">--%>
                    <%--<label class="info-title">Address </label>--%>
                    <%--<form:input form="userForm" id="suggest" path="" type="text" class="form-control"/>--%>
                    <%--<script src="//api-maps.yandex.ru/2.1/?lang=ru_RU&amp;load=SuggestView&amp;onload=onLoad"></script>--%>
                    <%--<script>--%>
                        <%--function onLoad(ymaps) {--%>
                            <%--var suggestView = new ymaps.SuggestView('suggest');--%>
                        <%--}--%>
                    <%--</script>--%>
                <%--</div>--%>
                <i hidden>

                    <input value="${useraddress.id}"/>
                    <form:input path="password" type="password" readonly="true"/>
                    <form:input path="id" type="id"/>
                    <form:input path="role" type="role"/>

                </i>

                <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Edit</button>

            </form:form>


            <%--<form:input   path="${editdate}" type="test"/>--%>
        </div>
    </div>
</div>
</div>
</body>
</html>
