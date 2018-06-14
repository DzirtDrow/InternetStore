
<div class="col-xs-12 col-sm-12 col-md-3 sidebar">
    <div class="side-menu outer-bottom-xs">
        <div class="head">Categories</div>
        <nav class="yamm megamenu-horizontal">
            <ul class="nav">
                <c:forEach items="${categories}" var="categories">
                <li class="dropdown menu-item"><a href="<c:url value='/store?id=${categories.id}'/> " class="dropdown-toggle">${categories.name}</a>
                </li>
                </c:forEach>

            </ul>
            <!-- /.nav -->
        </nav>
        <!-- /.megamenu-horizontal -->
    </div>
    <!-- /.side-menu -->
</div>