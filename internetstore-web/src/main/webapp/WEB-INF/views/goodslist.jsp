<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>--%>
<%--<%@ page isELIgnored="false" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>--%>
<%--&lt;%&ndash;<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>&ndash;%&gt;--%>

<html>

<head>
    <title>Goods List</title>

    <%--<link href="<c:url value='/static/css2/bootstrap.css' />" rel="stylesheet"/>--%>
    <%--<link href="<c:url value='/static/css2/app.css' />" rel="stylesheet"/>--%>
</head>

<body>
<%@include file="header.jsp" %>

<div class="panel-heading">
    <span class="lead">List of Goods </span>
</div>


<div>
    <c:set var="pageListHolder" value="${goods}" scope="session"/>
    <div class="body-content outer-top-xs">
        <div class="container">
            <div class="row ">
                <div class="shopping-cart">
                    <div class="shopping-cart-table ">
                        <div class="table-responsive">
                            <div>
                                <span style="float:right;">
                                  Page ${pageListHolder.page + 1} of ${pageListHolder.pageCount};<br/>  Goods on page: 10.
                                </span>


                                <div>
                                <span style="float:left;">
                                <c:choose>
                                    <c:when test="${pageListHolder.firstPage}">Prev</c:when>
                                    <c:otherwise><a href="/internet-store/goodslist/prev">Prev</a></c:otherwise>
                                </c:choose>
                                </span>
                                    <span>
                                    <c:forEach begin="0" end="${pageListHolder.pageCount-1}" varStatus="loop">
                                        &nbsp;&nbsp;
                                        <c:choose>
                                            <c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
                                            <c:otherwise><a
                                                    href="/internet-store/goodslist/${loop.index}">${loop.index+1}</a></c:otherwise>
                                        </c:choose>
                                        &nbsp;&nbsp;
                                    </c:forEach>
                                    </span>
                                    <span>
                                <c:choose>
                                    <c:when test="${pageListHolder.lastPage}">Next</c:when>
                                    <c:otherwise><a href="/internet-store/goodslist/next">Next</a></c:otherwise>
                                </c:choose>
                                </span>
                                </div>
                            </div>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <%--<th>Category</th>--%>
                                    <th>Left count</th>
                                    <th>Sold</th>
                                    <th>Actions</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="ph" items="${pageListHolder.pageList}">
                                    <%--<tr><td>${ph.id}</td><td>${ph.name}</td></tr>--%>

                                    <tr>
                                        <td>${ph.id}</td>
                                        <td class="text-center"><b>${ph.name}</b></td>
                                        <td class="text-center">$${ph.price}</td>
                                        <%--<td class="text-center">${ph.category.name}</td>--%>
                                        <td class="text-center">${ph.leftCount}</td>
                                        <td class="text-center">${ph.salesCount}</td>
                                        <td>
                                            <a href="deleteGoods?id=${ph.id}"
                                               class="btn btn-success custom-width">Delete</a>

                                            <a href="<c:url value='/editgoods?id=${ph.id}'/>"
                                               class="btn btn-success custom-width">Edit</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                            <div>
                                <span style="float:left;">
                                <c:choose>
                                    <c:when test="${pageListHolder.firstPage}">Prev</c:when>
                                    <c:otherwise><a href="/internet-store/goodslist/prev">Prev</a></c:otherwise>
                                </c:choose>
                                </span>
                                <span>
                                <c:forEach begin="0" end="${pageListHolder.pageCount-1}" varStatus="loop">
                                    &nbsp;&nbsp;
                                    <c:choose>
                                        <c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
                                        <c:otherwise><a
                                                href="/internet-store/goodslist/${loop.index}">${loop.index+1}</a></c:otherwise>
                                    </c:choose>
                                    &nbsp;&nbsp;
                                </c:forEach>
                                </span>
                                <span>
                                <c:choose>
                                    <c:when test="${pageListHolder.lastPage}">Next</c:when>
                                    <c:otherwise><a href="/internet-store/goodslist/next">Next</a></c:otherwise>
                                </c:choose>
                                </span>
                            </div>
                            <div id="add">
                                <br/> <input type="button" class="btn btn-success" value="Add New Goods"
                                             onclick="location.href='${pageContext.request.contextPath}/addgoods'"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


<%--<div class="body-content outer-top-xs">--%>
<%--<div class="container">--%>
<%--<div class="row ">--%>
<%--<div class="shopping-cart">--%>
<%--<div class="shopping-cart-table ">--%>
<%--<div class="table-responsive">--%>
<%--<table class="table">--%>

<%--<thead>--%>
<%--<tr>--%>
<%--<th>Name</th>--%>
<%--<th>Price</th>--%>
<%--<th>Category</th>--%>
<%--<th>Left count</th>--%>
<%--<th>Actions</th>--%>

<%--</tr>--%>
<%--</thead>--%>
<%--<tbody>--%>
<%--<c:forEach items="${goods}" var="goods">--%>
<%--<tr>--%>
<%--<td class="text-center">${goods.name}</td>--%>
<%--<td class="text-center">${goods.price}</td>--%>
<%--<td class="text-center">${goods.category.name}</td>--%>
<%--<td class="text-center">${goods.leftCount}</td>--%>
<%--<td>--%>
<%--<a href="deleteGoods?id=${goods.id}"--%>
<%--class="btn btn-success custom-width">Delete</a>--%>

<%--<a href="<c:url value='editgoods?id=${goods.id}'/>"--%>
<%--class="btn btn-success custom-width">Edit</a>--%>
<%--&lt;%&ndash;<a class="button">Edit</a>&ndash;%&gt;--%>
<%--</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</tbody>--%>
<%--</table>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>


</body>
</html>