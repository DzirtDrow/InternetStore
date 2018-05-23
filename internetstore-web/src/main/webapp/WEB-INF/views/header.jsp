<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Meta -->
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="keywords" content="MediaCenter, Template, eCommerce">
<meta name="robots" content="all">

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

<header class="header-style-2">
    <div class="top-bar animate-dropdown ">
        <div class="container">
            <div class="header-top-inner">
                <div class="cnt-account">
                    <ul class="list-unstyled">

                        <li><a href="<c:url value='/account'/> ">My Account</a></li>
                        <li><a href="<c:url value='/orders-list'/> ">My Orders</a></li>
                        <li><a href="<c:url value='/cart'/> ">My Cart</a></li>
                        <c:choose>
                            <c:when test="${(loggedinuser == 'anonymousUser')}">
                                <li><a href="<c:url value='/login'/> ">Login</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="<c:url value='/logout'/> ">Logout</a></li>
                                <span>Dear <strong>${loggedinuser}</strong>, Welcome!</span>
                            </c:otherwise>
                        </c:choose>

                    </ul>
                </div><!-- /.cnt-account -->

            </div><!-- /.header-top-inner -->
        </div><!-- /.container -->
    </div><!-- /.header-top -->
    <!-- ============================================== TOP MENU : END ============================================== -->
    <div class="main-header">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-3 logo-holder">
                    <!-- ============================================================= LOGO ============================================================= -->
                    <div class="logo">
                        <a href="<c:url value='/index'/>">
                            <img src="<c:url value='/static/images/logo3.png'/>" alt="">
                        </a>
                    </div><!-- /.logo -->
                    <!-- ============================================================= LOGO : END ============================================================= -->
                </div><!-- /.logo-holder -->

                <div class="col-xs-12 col-sm-12 col-md-7 top-search-holder">
                    <!-- /.contact-row -->

                    <div class="col-xs-12 col-sm-12 col-md-2 animate-dropdown top-cart-row">
                    </div><!-- /.top-cart-row -->
                </div><!-- /.row -->
            </div><!-- /.container -->
        </div><!-- /.main-header -->
    </div>
</header>

