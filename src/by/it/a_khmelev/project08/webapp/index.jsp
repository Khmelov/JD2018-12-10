<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <h2>Все объявления</h2>

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

    <hr> <mytag:paginator count="${adsCount}" step="12" urlprefix="do?command=Index&start="/>

</div>
</body>
</html>
