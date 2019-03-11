<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h5><img src="images/user${user.id}" height="30px"> ${user.name} (администратор)</h5>

    <h3>СПИСОК КЛИЕНТОВ </h3>
    <hr>
    <div class="row">
        <div class=col-md-1>ID</div>
        <div class=col-md-2>Логин</div>
        <div class=col-md-1>Пароль</div>
        <div class=col-md-2>Email</div>
        <div class=col-md-2>ФИО</div>
        <div class=col-md-2>Роль</div>
    </div>
    <c:forEach items="${users}" var="user">
        <form class="form-horizontal-${user.id}" action="do?command=EditUsers" method="post">
            <div class="row">
                <div class="col-md-1">
                <input id="id" name="id" type="text" placeholder="" class="form-control input-md"
                       required="" value="${user.id}">
                </div>

                <div class="col-md-2">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
                           required="" value="${user.login}">
                </div>

                <div class="col-md-1">
                    <input id="password" name="password" type="password" placeholder="" class="form-control input-md"
                           required="" value="${user.password}">
                </div>

                <div class="col-md-2">
                    <input id="email" name="email" type="text" placeholder="" class="form-control input-md"
                           required="" value="${user.email}">
                </div>

                <div class="col-md-2">
                    <input id="name" name="name" type="text" placeholder="" class="form-control input-md"
                           required="" value="${user.name}">
                </div>

                <div class="col-md-2">
                    <select id="roles_id" name="roles_id" class="form-control">
                        <c:forEach items="${roles}" var="role">
                        <option value="${role.id}" ${user.roles_id==role.id?"selected":""}>${role.role}</option>
                        </c:forEach>
                    </select>
                </div>

                <!-- Button (Double) -->
                <div class="col-md-2">
                    <button id="update" name="update" class="btn btn-success">Обновить</button>
                    <button id="delete" name="delete" class="btn btn-danger">Удалить</button>
                </div>
            </div>
        </form>
    </c:forEach>

    <hr>
    <div class="row">
        <label class="col-md-10 control-label" for="account">${message}</label>
    </div>

    <mytag:paginator count="${usersCount}" step="5" urlprefix="do?command=EditUsers&start="/>
    <p> </p>

    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>
            <!-- Button -->
            <div class="row">
                <div class="col-md-4">
                     <button id="profileButton" name="profileButton" class="btn btn-info">Вернуться в ЛИЧНЫЙ КАБИНЕТ</button>
                </div>
            </div>
        </fieldset>
    </form>

</div>
</body>
</html>