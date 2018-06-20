<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 20.06.2018
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Add promotion</title>
</head>
<body>
<%@include file="../header.jsp" %>
<div class="body-content">
    <div class="container">
        <div class="sign-in-page col-md-4 col-sm-4">
            <h4 class="checkout-subtitle">Add new Promo Action</h4>
            <form:form class="register-form outer-top-xs" role="form" modelAttribute="promotion" method="post">

                <div class="form-group">
                    <label class="info-title">Name </label>
                    <form:input path="name" type="name" class="form-control unicase-form-control text-input"/>
                </div>

                <div class="form-group">
                    <label class="info-title">Description</label>
                    <form:input path="description" type="text" class="form-control unicase-form-control text-input"/>
                </div>
                <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Add</button>

            </form:form>
        </div>
    </div>
</div>

</body>
</html>
