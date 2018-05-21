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


<header class="header-style-2">
    <div class="top-bar animate-dropdown">
        <%--<div class="container">--%>
        <%--<c:choose>--%>
        <%--<c:when test="${userRole} == 'manager'}">--%>
        <%--<a href="/">${userRole}  </a> MANAGERRRRRRRRR--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
        <%--${userRole} wgwrgw--%>
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>
        <%--</div>--%>
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

                <%--<div class="cnt-block">--%>
                <%--<ul class="list-unstyled list-inline">--%>

                <%--</ul><!-- /.list-unstyled -->--%>
                <%--</div><!-- /.cnt-cart -->--%>
                <%--<div class="clearfix"></div>--%>
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

                <img src="<c:url value='/static/images/logo.png'/>" alt="">

                </a>
                </div><!-- /.logo -->
                <!-- ============================================================= LOGO : END ============================================================= -->
                </div><!-- /.logo-holder -->

                <div class="col-xs-12 col-sm-12 col-md-7 top-search-holder">
                    <!-- /.contact-row -->

                    <div class="col-xs-12 col-sm-12 col-md-2 animate-dropdown top-cart-row">
                        <!-- ============================================================= SHOPPING CART DROPDOWN ============================================================= -->

                        <%--<div class="dropdown dropdown-cart">--%>
                        <%--<a href="#" class="dropdown-toggle lnk-cart" data-toggle="dropdown">--%>
                        <%--<div class="items-cart-inner">--%>
                        <%--&lt;%&ndash;<div class="basket">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<i class="glyphicon glyphicon-shopping-cart"></i>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div class="basket-item-count"><span class="count">2</span></div>&ndash;%&gt;--%>
                        <%--<div class="total-price-basket">--%>
                        <%--<span class="lbl">cart</span>--%>
                        <%--<span class="total-price">--%>
                        <%--<span class="sign">$</span><span class="value">600.00</span>--%>
                        <%--</span>--%>
                        <%--</div>--%>


                        <%--</div>--%>
                        <%--</a>--%>
                        <%--<ul class="dropdown-menu">--%>
                        <%--<li>--%>
                        <%--<div class="cart-item product-summary">--%>
                        <%--<div class="row">--%>
                        <%--<div class="col-xs-4">--%>
                        <%--<div class="image">--%>
                        <%--<a href="detail.html"><img--%>
                        <%--src="<c:url value='/static/images/cart.jpg'/>" alt=""></a>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-7">--%>

                        <%--<h3 class="name"><a href="index.php?page-detail">Simple Product</a></h3>--%>
                        <%--<div class="price">$600.00</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-xs-1 action">--%>
                        <%--<a href="#"><i class="fa fa-trash"></i></a>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--</div><!-- /.cart-item -->--%>
                        <%--<div class="clearfix"></div>--%>
                        <%--<hr>--%>

                        <%--<div class="clearfix cart-total">--%>
                        <%--<div class="pull-right">--%>

                        <%--<span class="text">Sub Total :</span><span class='price'>$600.00</span>--%>

                        <%--</div>--%>
                        <%--<div class="clearfix"></div>--%>

                        <%--<a href="checkout.html" class="btn btn-upper btn-primary btn-block m-t-20">Checkout</a>--%>
                        <%--</div><!-- /.cart-total-->--%>


                        <%--</li>--%>
                        <%--</ul><!-- /.dropdown-menu-->--%>
                        <%--</div><!-- /.dropdown-cart -->--%>

                        <!-- ============================================================= SHOPPING CART DROPDOWN : END============================================================= -->
                    </div><!-- /.top-cart-row -->
                </div><!-- /.row -->

            </div><!-- /.container -->

        </div><!-- /.main-header -->

    </div>



</header>


<%--<div class="authbar">--%>
<%--<c:choose>--%>
<%--<c:when test="${loggedinuser == 'anonymousUser'}">--%>
<%--<span class="bar"><a href="<c:url value="/login" />" class="btn">Login</a></span>--%>
<%--</c:when>--%>
<%--<c:otherwise>--%>
<%--<span>Dear <strong>${loggedinuser}</strong>, Welcome!</span>--%>
<%--<span><a href="<c:url value="/logout" />" class="btn">Logout</a></span>--%>
<%--</c:otherwise>--%>
<%--</c:choose>--%>
<%--</div>--%>