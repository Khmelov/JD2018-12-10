<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <c:choose>
        <c:when test="${user.roles_id==1}">
            <h5><img src="images/user${user.id}" height="30px"> ${user.name} (администратор)</h5>
        </c:when>
        <c:when test="${user.roles_id==2}">
            <h5><img src="images/user${user.id}" height="30px"> ${user.name}</h5>
        </c:when>
        <c:otherwise>
            <h5>${user.name}</h5>
        </c:otherwise>
    </c:choose>

    <h3>ЛИЧНЫЕ ДАННЫЕ</h3>
    <p>_____________________________________________________</p>

    <form class="form-horizontal" action="do?command=UserData" method="post" enctype="multipart/form-data">
        <fieldset>

            <div class="row">
              <label class="col-md-1 control-label" for="login">Логин</label>
              <div class="col-md-3">
              <input id="login" name="login" value="${user.login}" type="text"
              placeholder="" class="form-control input-md" required="">
              </div>
            </div>

            <div class="row">
              <label class="col-md-1 control-label" for="password">Пароль</label>
              <div class="col-md-3">
                <input id="password" name="password" value="${user.password}" type="password"
                placeholder="" class="form-control input-md" required="">
              </div>
            </div>

            <div class="row">
              <label class="col-md-1 control-label" for="email">Email</label>
              <div class="col-md-3">
              <input id="email" name="email" value="${user.email}" type="text"
              placeholder="" class="form-control input-md">
              </div>
            </div>

            <div class="row">
              <label class="col-md-1 control-label" for="name">Имя</label>
              <div class="col-md-3">
              <input id="name" name="name" value="${user.name}" type="text"
              placeholder="" class="form-control input-md">
              </div>
            </div>

            <!-- File Button -->
            <div class="row">
                <label class="col-md-1 control-label" for="fileimg"></label>
                <div class="col-md-3">
                    <input id="fileimg" name="fileimg" class="input-file" type="file">
              </div>
            </div>

    <p>_____________________________________________________</p>

    <p>${message}</p>

            <!-- Button -->
            <div class="row">
              <label class="col-md-4 control-label" for="update"></label>
            </div>
            <div class="row">
              <div class="col-md-4">
                <button id="update" name="update" class="btn btn-success">ОБНОВИТЬ данные</button>
                <button id="profileButton" name="profileButton" class="btn btn-info">Вернуться в ЛИЧНЫЙ КАБИНЕТ</button>
              </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>