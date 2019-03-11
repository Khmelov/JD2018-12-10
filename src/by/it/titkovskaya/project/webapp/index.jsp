<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <c:choose>
        <c:when test="${user.roles_id==1}">
            <h5><img src="images/user${user.id}" height="30px"> ${user.name} (admin)</h5>
        </c:when>
        <c:when test="${user.roles_id==2}">
            <h5><img src="images/user${user.id}" height="30px"> ${user.name}</h5>
        </c:when>
        <c:otherwise>
            <h5>${user.name}</h5>
        </c:otherwise>
    </c:choose>

    <p>_______________________________________________________________________________</p>

    <form class="form-horizontal">
        <fieldset>
            <h1> <img src="images/main.png" height="55px">  TIT Co Payment System </h1>
        </fieldset>
    </form>

    <p>_______________________________________________________________________________</p>

    <form class="form-horizontal">
        <fieldset>
            <h5> >>> Round-the-clock instant access to you cash assets </h5>
        </fieldset>
    </form>

    <form class="form-horizontal">
        <fieldset>
            <h5> >>> Immediate money transfers to any part of the world </h5>
        </fieldset>
    </form>

    <form class="form-horizontal">
        <fieldset>
            <h5> >>> Safe shopping online and around the hole planet </h5>
        </fieldset>
    </form>

    <form class="form-horizontal">
        <fieldset>
            <h5> >>> Privacy and security of your financial information </h5>
        </fieldset>
    </form>
    <p>_______________________________________________________________________________</p>


    <form class="form-horizontal" action="do" method="get">
        <fieldset>
            <!-- Button (Double) -->
            <div class="row">
                <input id="command" name="command" type="hidden" placeholder=""
                class="form-control input-md" required="" value="Index">
                <div class="col-md-6">
                     <button id="signup" name="signup" class="btn btn-success">SIGN UP and join TIT Co PaySys</button>
                     <button id="login" name="login" class="btn btn-info">SIGN IN and manage your account</button>
                </div>
            </div>
        </fieldset>
    </form>

</div>
</body>
</html>