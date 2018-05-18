<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>--%>
<%--<%@ page isELIgnored="false" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>--%>
<%--&lt;%&ndash;<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>&ndash;%&gt;--%>
<!DOCTYPE html>
<html lang="en">
<head>
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


</head>
<body class="cnt-home">
<!-- ============================================== HEADER ============================================== -->
<%@include file="header.jsp" %>
<%--<header class="header-style-1">--%>

<%--<!-- ============================================== TOP MENU ============================================== -->--%>
<%--<div class="top-bar animate-dropdown">--%>
<%--<div class="container">--%>
<%--<div class="header-top-inner">--%>
<%--<div class="cnt-account">--%>
<%--<ul class="list-unstyled">--%>
<%--<li><a href="#">My Account</a></li>--%>
<%--<li><a href="<c:url value='/cart'/> ">My Cart</a></li>--%>
<%--<li><a href="#">Login</a></li>--%>
<%--</ul>--%>
<%--</div><!-- /.cnt-account -->--%>

<%--<div class="cnt-block">--%>
<%--<ul class="list-unstyled list-inline">--%>

<%--</ul><!-- /.list-unstyled -->--%>
<%--</div><!-- /.cnt-cart -->--%>
<%--<div class="clearfix"></div>--%>
<%--</div><!-- /.header-top-inner -->--%>
<%--</div><!-- /.container -->--%>
<%--</div><!-- /.header-top -->--%>
<%--<!-- ============================================== TOP MENU : END ============================================== -->--%>
<%--<div class="main-header">--%>
<%--<div class="container">--%>
<%--<div class="row">--%>
<%--<div class="col-xs-12 col-sm-12 col-md-3 logo-holder">--%>
<%--<!-- ============================================================= LOGO ============================================================= -->--%>
<%--<div class="logo">--%>
<%--<a href="<c:url value='/index'/>">--%>

<%--<img src="<c:url value='/static/images/logo.png'/>" alt="">--%>

<%--</a>--%>
<%--</div><!-- /.logo -->--%>
<%--<!-- ============================================================= LOGO : END ============================================================= -->--%>
<%--</div><!-- /.logo-holder -->--%>

<%--<div class="col-xs-12 col-sm-12 col-md-7 top-search-holder">--%>
<%--<!-- /.contact-row -->--%>

<%--<div class="col-xs-12 col-sm-12 col-md-2 animate-dropdown top-cart-row">--%>
<%--<!-- ============================================================= SHOPPING CART DROPDOWN ============================================================= -->--%>

<%--&lt;%&ndash;<div class="dropdown dropdown-cart">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href="#" class="dropdown-toggle lnk-cart" data-toggle="dropdown">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="items-cart-inner">&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;<div class="basket">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;<i class="glyphicon glyphicon-shopping-cart"></i>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;</div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;<div class="basket-item-count"><span class="count">2</span></div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="total-price-basket">&ndash;%&gt;--%>
<%--&lt;%&ndash;<span class="lbl">cart</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;<span class="total-price">&ndash;%&gt;--%>
<%--&lt;%&ndash;<span class="sign">$</span><span class="value">600.00</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>


<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;<ul class="dropdown-menu">&ndash;%&gt;--%>
<%--&lt;%&ndash;<li>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="cart-item product-summary">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-xs-4">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="image">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href="detail.html"><img&ndash;%&gt;--%>
<%--&lt;%&ndash;src="<c:url value='/static/images/cart.jpg'/>" alt=""></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-xs-7">&ndash;%&gt;--%>

<%--&lt;%&ndash;<h3 class="name"><a href="index.php?page-detail">Simple Product</a></h3>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="price">$600.00</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-xs-1 action">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href="#"><i class="fa fa-trash"></i></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div><!-- /.cart-item -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="clearfix"></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<hr>&ndash;%&gt;--%>

<%--&lt;%&ndash;<div class="clearfix cart-total">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="pull-right">&ndash;%&gt;--%>

<%--&lt;%&ndash;<span class="text">Sub Total :</span><span class='price'>$600.00</span>&ndash;%&gt;--%>

<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="clearfix"></div>&ndash;%&gt;--%>

<%--&lt;%&ndash;<a href="checkout.html" class="btn btn-upper btn-primary btn-block m-t-20">Checkout</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div><!-- /.cart-total-->&ndash;%&gt;--%>


<%--&lt;%&ndash;</li>&ndash;%&gt;--%>
<%--&lt;%&ndash;</ul><!-- /.dropdown-menu-->&ndash;%&gt;--%>
<%--&lt;%&ndash;</div><!-- /.dropdown-cart -->&ndash;%&gt;--%>

<%--<!-- ============================================================= SHOPPING CART DROPDOWN : END============================================================= -->--%>
<%--</div><!-- /.top-cart-row -->--%>
<%--</div><!-- /.row -->--%>

<%--</div><!-- /.container -->--%>

<%--</div><!-- /.main-header -->--%>

<%--<!-- ============================================== NAVBAR ============================================== -->--%>
<%--<div class="header-nav animate-dropdown">--%>
<%--<div class="container">--%>
<%--<div class="yamm navbar navbar-default" role="navigation">--%>
<%--<div class="navbar-header">--%>
<%--<button data-target="#mc-horizontal-menu-collapse" data-toggle="collapse"--%>
<%--class="navbar-toggle collapsed" type="button">--%>
<%--<span class="sr-only">Toggle navigation</span>--%>
<%--<span class="icon-bar"></span>--%>
<%--<span class="icon-bar"></span>--%>
<%--<span class="icon-bar"></span>--%>
<%--</button>--%>
<%--</div>--%>
<%--</div><!-- /.navbar-default -->--%>
<%--</div><!-- /.container-class -->--%>

<%--</div><!-- /.header-nav -->--%>
<%--<!-- ============================================== NAVBAR : END ============================================== -->--%>
<%--</div>--%>
<%--</header>--%>

<!-- ============================================== HEADER : END ============================================== -->
<div class="breadcrumb">
    <div class="container">
        <div class="breadcrumb-inner">
            <ul class="list-inline list-unstyled">
                <li><a href="<c:url value='/index'/> ">Home</a></li>
                <li class='active'>Shopping Cart</li>
            </ul>
        </div><!-- /.breadcrumb-inner -->
    </div><!-- /.container -->
</div><!-- /.breadcrumb -->

<div class="body-content outer-top-xs">
    <div class="container">
        <div class="row ">
            <div class="shopping-cart">
                <div class="shopping-cart-table ">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>

                                <%--<th class="cart-description item">Image</th>--%>
                                <th class="cart-product-name item">Product Name</th>
                                <%--<th class="cart-edit item">Edit</th>--%>
                                <th class="cart-qty item">Quantity</th>
                                <th class="cart-sub-total item">Price</th>
                                <th class="cart-total last-item">Total Price</th>
                                <th class="cart-romove item">Remove</th>
                            </tr>
                            </thead><!-- /thead -->
                            <tfoot>
                            <tr>
                                <td colspan="5">
                                    <i class="text outer-right-xs">Order Price: <i class="text">$1000</i> </i>
                                    <div class="shopping-cart-btn">
                                        <span class="">

                                            <a href="#" class="btn btn-upper btn-primary  outer-right-xs">Make Order</a>

                                            <a href="<c:url value='/index'/>"
                                               class="btn btn-upper btn-primary pull-right">Continue Shopping</a>


                                        </span>
                                    </div><!-- /.shopping-cart-btn -->
                                </td>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${userCart}" var="cartItem">
                                <tr>
                                    <td class="cart-product-name-info">
                                        <h4 class='cart-product-description'><a href="#">${cartItem.goods.name}</a>
                                        </h4>
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="rating rateit-small"></div>
                                            </div>

                                        </div><!-- /.row -->
                                            <%--<div class="cart-product-info">--%>
                                            <%--<span class="product-color">COLOR:<span>Blue</span></span>--%>
                                            <%--</div>--%>
                                    </td>

                                    <td class="cart-product-quantity">
                                        <%--<div class="quant-input">--%>
                                            <%--<div class="arrows">--%>
                                                <%--<div class="arrow plus gradient"><span class="ir"><i--%>
                                                        <%--class="icon fa fa-sort-asc"--%>
                                                        <%--href="increaseItemsCount?id=${cartItem.id}">+</i></span></div>--%>
                                                <%--<div class="arrow minus gradient"><span class="ir"><i--%>
                                                        <%--class="icon fa fa-sort-desc"--%>
                                                        <%--href="decreaseItemsCount?id=${cartItem.id}">-</i></span></div>--%>
                                            <%--</div>--%>
                                            <a href="increaseItemsCount?id=${cartItem.id}" class="btn btn-black ">+</a>
                                            <i>${cartItem.count}</i>
                                            <a href="decreaseItemsCount?id=${cartItem.id}" class="btn btn-black">-</a>


                                        <%--</div>--%>
                                    </td>
                                    <td class="cart-product-sub-total"><span
                                            class="cart-sub-total-price">$${cartItem.goods.price}</span>
                                    </td>
                                    <td class="cart-product-grand-total"><span
                                            class="cart-grand-total-price">${cartItem.goods.price * cartItem.count}</span>
                                    </td>

                                        <%--Remove Item button--%>
                                    <td class="romove-item"><a
                                            href="<c:url value='/deleteItemFromCart?id=${cartItem.id}'/> "
                                            title="Remove" class="icon"><i class="fa fa-trash-o"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody><!-- /tbody -->
                        </table><!-- /table -->
                    </div>
                </div><!-- /.shopping-cart-table -->


            </div><!-- /.shopping-cart -->
        </div> <!-- /.row -->
    </div><!-- /.container -->
</div><!-- /.body-content -->


</body>
</html>

<%--<html>--%>

<%--<head>--%>
<%--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
<%--<title>Goods List</title>--%>
<%--<link href="<c:url value='/static/css2/bootstrap.css' />" rel="stylesheet"/>--%>
<%--<link href="<c:url value='/static/css2/app.css' />" rel="stylesheet"/>--%>
<%--</head>--%>

<%--<body>--%>
<%--<%@include file="authheader.jsp" %>--%>

<%--<input type="button" class="button" value="Home" onclick="location.href=' ${pageContext.request.contextPath}/ '" />--%>
<%--<div class="panel-heading"><span class="lead">Cart</span></div>--%>
<%--<table class="table table-hover">--%>
<%--<thead>--%>
<%--<tr>--%>
<%--<th>Name</th>--%>
<%--<th>Price</th>--%>
<%--<th>Count</th>--%>
<%--<th>Actions</th>--%>

<%--</tr>--%>
<%--</thead>--%>
<%--<tbody>--%>
<%--<c:forEach items="${userCart}" var="cartItem">--%>
<%--<tr>--%>
<%--<td>${cartItem.goods.name}</td>--%>
<%--<td>${cartItem.goods.price}</td>--%>
<%--<td>--%>
<%--<a href="decreaseItemsCount?id=${cartItem.id}" class="btn btn-success">-</a>--%>
<%--${cartItem.count}--%>
<%--<a href="increaseItemsCount?id=${cartItem.id}" class="btn btn-success">+</a></td>--%>
<%--&lt;%&ndash;<td>${goods.description}</td>&ndash;%&gt;--%>
<%--<td>--%>
<%--<a href="deleteItemFromCart?id=${cartItem.id}" class="btn btn-success custom-width">Delete</a>--%>
<%--</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</tbody>--%>
<%--</table>--%>

<%--<a href="createOrder" class="btn btn-success">Create Order</a>--%>
<%--</body>--%>
<%--</html>--%>

