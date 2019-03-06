<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h2>Профиль пользователя: ${user.login}</h2>
    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Обновление данных</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>
                <div class="col-md-4">
                    <input id="email" name="email" value="${user.email}" type="text" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="${user.password}" type="password" placeholder=""
                           class="form-control input-md" required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="update"></label>
                <div class="col-md-4">
                    <button id="update" name="update" class="btn btn-primary">Обновить</button>
                </div>
            </div>
        </fieldset>
    </form>
    <h2>Объявления пользователя: ${user.login}</h2>
    <div class="row">
        <div class="col-md-1">Фото</div>
        <div class="col-md-1">Цена</div>
        <div class="col-md-2">Адрес</div>
        <div class="col-md-2">Описание</div>
        <div class="col-md-1">Число комнат</div>
        <div class="col-md-1">Площадь</div>
        <div class="col-md-1">Этаж</div>
        <div class="col-md-1">Этажность</div>
        <div class="col-md-2">Дата</div>
    </div>

    <c:forEach items="${ads}" var="ad">
        <br>
        <div class="row">
            <div class="col-md-1">
                <a href="images/ad${ad.id}" target="_blank">
                    <img src="images/ad${ad.id}" height="40px">
                </a>
            </div>
            <div class="col-md-1">${ad.price}</div>
            <div class="col-md-2">${ad.address}</div>
            <div class="col-md-2">${ad.description}</div>
            <div class="col-md-1">${ad.rooms}</div>
            <div class="col-md-1">${ad.area}</div>
            <div class="col-md-1">${ad.floor}</div>
            <div class="col-md-1">${ad.floors}</div>
            <div class="col-md-2">${ad.data}</div>
        </div>
    </c:forEach>

    <hr>
    <mytag:paginator count="${adsCount}" step="5" urlprefix="do?command=Profile&start="/>

    <hr>
    <form class="form-horizontal" action="do?command=Logout" method="post">
        <fieldset>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logoutButton"></label>
                <div class="col-md-4">
                    <button id="logoutButton" name="logoutButton" class="btn btn-danger">Завершить работу (выйти)</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>

