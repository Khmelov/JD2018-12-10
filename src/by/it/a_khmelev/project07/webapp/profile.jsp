<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p>User ${user}</p>
    <h2>Объявления пользователя: </h2>
    ${ads}
    <div class="row">
        <div class="col-md-1">Цена</div>
        <div class="col-md-2">Адрес</div>
        <div class="col-md-3">Описание</div>
        <div class="col-md-1">Число комнат</div>
        <div class="col-md-1">Площадь</div>
        <div class="col-md-1">Этаж</div>
        <div class="col-md-1">Этажность</div>
        <div class="col-md-2">Дата</div>
    </div>

    <c:forEach items="${ads}" var="ad">
        <div class="row">
            <div class="col-md-1">${ad.price}</div>
            <div class="col-md-2">${ad.address}</div>
            <div class="col-md-2">${ad.description}</div>
            <div class="col-md-1">${ad.rooms}</div>
            <div class="col-md-1">${ad.area}</div>
            <div class="col-md-1">${ad.floor}</div>
            <div class="col-md-1">${ad.floors}</div>
            <div class="col-md-3">${ad.data}</div>
        </div>
    </c:forEach>



    <form class="form-horizontal" action="do?command=Logout" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Logout</legend>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logoutButton"></label>
                <div class="col-md-4">
                    <button id="logoutButton" name="logoutButton" class="btn btn-primary">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>

