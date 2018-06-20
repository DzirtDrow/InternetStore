<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 20.06.2018
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Promotions</title>
</head>
<body>
<%@include file="../header.jsp" %>

<div class="panel-heading">
    <span class="lead">Promotions</span>
</div>


<div>
    <div class="body-content outer-top-xs">
        <div class="container">
            <div class="row ">
                <div class="shopping-cart">
                    <div class="shopping-cart-table ">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Description</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="promo" items="${promotions}">
                                    <tr>
                                        <td>${promo.id}</td>
                                        <td class="text-center"><b>${promo.name}</b></td>
                                        <td class="text-center">${promo.description}</td>
                                        <td>
                                            <a href="<c:url value='/promo/deletepromotion?id=${promo.id}'/>"
                                               class="btn btn-success custom-width">Delete</a>

                                            <a href="<c:url value='/promo/editpromotion?id=${promo.id}'/>"
                                               class="btn btn-success custom-width">Edit</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                            <div id="add">
                                <br/> <input type="button" class="btn btn-success" value="Add New Promo"
                                             onclick="location.href='${pageContext.request.contextPath}/promo/addpromotion'"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


</body>
</html>
