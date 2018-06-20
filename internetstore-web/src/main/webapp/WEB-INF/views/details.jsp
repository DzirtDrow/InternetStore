<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 21.05.2018
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Goods Details</title>
</head>
<body>
<%@include file="header.jsp" %>

<div class="breadcrumb">
    <div class="container">
        <div class="breadcrumb-inner">
            <ul class="list-inline list-unstyled">
                <li><a href="<c:url value='/index'/> ">Home</a></li>
                <li><a href="<c:url value='/store?id=${goods.category.id}'/> ">${goods.category.name}</a></li>
                <li class='active'>${goods.name}</li>
            </ul>
        </div><!-- /.breadcrumb-inner -->
    </div><!-- /.container -->
</div><!-- /.breadcrumb -->
<br/>
<div class='col-lg-offset-4 col-lg-5'>
    <div class="detail-block">
        <div class="product-image">
            <img src="<c:url value='/static/images/products/p1.jpg'/>" height="310">
        </div>
        <div class='col-sm-5 col-md-7 product-info-block'>
            <div class="product-info">
                <h5>Category: <b>${goods.category.name}</b></h5>
                <h4 class="name">Name: <b>${goods.name}</b></h4>
                <div class="description-container m-t-20">
                    Description:<br/>
                    <b>${goods.description}</b>
                    <br/><br/>
                </div><!-- /.description-container -->

                Parameters:<br/>
                <c:forEach items="${goodsParameters}" var="goodsparam">
                    ${goodsparam.parameter.name} :
                    <c:choose>
                        <c:when test="${goodsparam.parameter.parameterType == 'param_num'}">
                            <b>${goodsparam.numValue}  ${goodsparam.parameter.unit}</b><br/>
                        </c:when>
                        <c:otherwise>
                            <b>${goodsparam.stringValue}</b><br/>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
                <div class="price-container info-container m-t-20">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="price-box">
                                <span class="price"><h4>Price: <b>$${goods.price}</b></h4></span>
                            </div>
                        </div>


                    </div><!-- /.row -->
                </div><!-- /.price-container -->

                <div class="quantity-container info-container">
                    <div class="row">

                        <div class="col-sm-2">
                            <span class="label">Qty :</span>
                        </div>


                        <div class="col-sm-7">
                            <a href="addtocart?id=${goods.id}" class="btn btn-primary"><i
                                    class="fa fa-shopping-cart inner-right-vs"></i>
                                ADD TO CART</a>
                        </div>


                    </div><!-- /.row -->
                </div><!-- /.quantity-container -->


            </div><!-- /.product-info -->
        </div><!-- /.col-sm-7 -->
    </div><!-- /.row -->
</div>
</div>
</body>
</html>
