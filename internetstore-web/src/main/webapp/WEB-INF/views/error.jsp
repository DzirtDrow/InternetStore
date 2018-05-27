<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Meta -->
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="keywords" content="MediaCenter, Template, eCommerce">
<meta name="robots" content="all">

<title>Internet Store</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css' />">

<!-- Customizable CSS -->
<link rel="stylesheet" href="<c:url value='/static/css/main.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/blue.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/owl.carousel.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/owl.transitions.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/animate.min.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/rateit.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/bootstrap-select.min.css' />">


<!-- Icons/Glyphs -->
<link rel="stylesheet" href="<c:url value='/static/css/font-awesome.css'/>">

<!-- Fonts -->
<link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,700' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,600italic,700,700italic,800'
      rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>

<html>
<head>
    <title>Error</title>
</head>
<body>
<div class="body-content outer-top-bd">
    <div class="container">
        <div class="x-page inner-bottom-sm">
            <div class="row">
                <div class="col-md-12 x-text text-center">
                    <h1>ERROR!</h1>
                    <%--<h2>${errorMsg}</h2>--%>
                    <a href="<c:url value='/index'/>"><i class="fa fa-home"></i> Go To Homepage</a>
                    <%--${exception}--%>
                </div>
            </div><!-- /.row -->
        </div><!-- /.sigin-in-->
    </div><!-- /.container -->
</div><!-- /.body-content -->
</body>
</html>