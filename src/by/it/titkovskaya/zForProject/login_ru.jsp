<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
    <div class="container">
    <%@ include file="include/menu.jsp" %>
    <c:choose>
        <c:when test="${user.roles_id==1}">
            <h5>${user.name} (администратор)</h5>
        </c:when>
        <c:otherwise>
            <h5>${user.name}</h5>
        </c:otherwise>
    </c:choose>

    <h3>ДОБРО ПОЖАЛОВАТЬ!</h3>

    <form class="form-horizontal" action="do?command=Login" method="post">
        <fieldset>

            <!-- Text input-->
            <div class="row">
                <label class="col-md-4 control-label" for="login">Логин</label>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <input id="login" name="login" value="clientLOGIN" type="text" placeholder="YourLogin" class="form-control input-md" required="">
                </div>
            </div>

            <!-- Password input-->
            <div class="row">
                <label class="col-md-4 control-label" for="password">Пароль</label>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <input id="password" name="password" value="12345" type="password"
                    placeholder="*****" class="form-control input-md" required="">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="loginButton"></label>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <button id="loginButton" name="loginButton" class="btn btn-success">ВОЙТИ</button>
                </div>
            </div>

        </fieldset>
    </form>

    <div class="row">
        <label class="col-md-4 control-label" for="message">${message}</label>
    </div>

</div>
</body>
</html>

