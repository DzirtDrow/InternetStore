<%--
  Created by IntelliJ IDEA.
  User: Dzirt
  Date: 21.06.2018
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Statistics page</title>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<div class="body-content">
    <div class="container">
        <div class="breadcrumb">
            <div class="container">
                <div class="breadcrumb-inner">
                    <ul class="list-inline list-unstyled">
                        <li><a href="<c:url value='/index'/> ">Home</a></li>
                        <li><a href="<c:url value='/admin'/> ">Admin</a></li>
                        <li class='active'>Statistics</li>
                    </ul>
                </div><!-- /.breadcrumb-inner -->
            </div><!-- /.container -->
        </div><!-- /.breadcrumb -->
        <div class="col-md-5 col-sm-2">
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="unicase-checkout-title">Top goods</h4>


                        <table class="table">
                            <thead>
                            <th>ID</th>
                            <th>NAME</th>
                            <th>PRICE</th>
                            <th>SOLD</th>
                            </thead>
                            <tbody>
                            <c:forEach items="${topgoods}" var="goods">
                                <tr>
                                    <td>${goods.id}</td>
                                    <td>${goods.name}</td>
                                    <td>$${goods.price}</td>
                                    <td>${goods.salesCount}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-md-5 col-sm-3">
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="unicase-checkout-title">Top users</h4>
                        <table class="table">
                            <thead>
                            <th>ID</th>
                            <th>NAME</th>
                            <th>LAST NAME</th>
                            <th>SPENT</th>
                            </thead>
                            <tbody>
                            <c:forEach items="${topusers}" var="users">
                                <tr>
                                    <td>${users.id}</td>
                                    <td>${users.name}</td>
                                    <td>${users.lastname}</td>
                                    <td>$${users.spentCount}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-2 col-sm-3   ">
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="unicase-checkout-title">Proceed:</h4><br/>
                        <h5>Week proceed: <br/><b>$${weekproceed}</b></h5><br/>
                        <h5>Month proceed: <br/><b>$${monthproceed}</b></h5>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
