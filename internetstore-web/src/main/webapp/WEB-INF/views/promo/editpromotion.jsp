<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 20.06.2018
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Edit promotion</title>
</head>
<body>
<%@include file="../header.jsp" %>

<%--</form:form>--%>

<form:form id="promoform" class="register-form outer-top-xs" role="form" modelAttribute="promotion" method="post">

    <div class="body-content">
        <div class="container">
            <div class="sign-in-page col-md-4 col-sm-4 ">

                <h4 class="checkout-subtitle">Edit promo</h4>

                <div class="form-group">
                    <label class="info-title">Name </label>
                    <form:input path="name" type="name" class="form-control unicase-form-control text-input"/>
                </div>
                <div class="form-group">
                    <label class="info-title">Price </label>
                    <form:input path="description" type="text" class="form-control unicase-form-control text-input"/>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Save Changes</button>
                </div>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>
