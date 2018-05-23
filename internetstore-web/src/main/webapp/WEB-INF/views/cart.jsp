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

    <title>Cart</title>

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
                                    <i class="text outer-right-xs">Order Price: <i class="text">$${totalPrice}</i> </i>
                                    <div class="shopping-cart-btn">
                                        <span class="">

                                            <a href="<c:url value='/createorderfromcart'/>" class="btn btn-upper btn-primary  outer-right-xs">Make Order</a>

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

                                    </td>

                                    <td class="cart-product-quantity">
                                        <%--<div class="quant-input">--%>
                                            <%--<div class="arrows">--%>
                                                <%--<div class="arrow plus gradient"><span class="ir" ><i class="icon fa fa-sort-asc" href="<c:url value='/increaseItemsCount?id=${cartItem.id}'/>"></i></span></div>--%>
                                                <%--<div class="arrow minus gradient"><span class="ir"><i class="icon fa fa-sort-desc" href="/decreaseItemsCount?id=${cartItem.id}"></i></span></div>--%>
                                            <%--</div>--%>
                                            <%--<input type="text" value="${cartItem.count}" />--%>
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

