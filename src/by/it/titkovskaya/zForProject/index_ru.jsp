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

    <p>_______________________________________________________________________________</p>

    <form class="form-horizontal">
        <fieldset>
            <h1> Платежная система TIT Co </h1>
        </fieldset>
    </form>

    <p>_______________________________________________________________________________</p>

    <form class="form-horizontal">
        <fieldset>
            <h5> >>> Мнгновенный круглосуточный доступ к Вашим денежным средствам </h5>
        </fieldset>
    </form>

    <form class="form-horizontal">
        <fieldset>
            <h5> >>> Безопасные покупки онлайн и по всему свету </h5>
        </fieldset>
    </form>

    <form class="form-horizontal">
        <fieldset>
            <h5> >>> Моментальные денежные переводы в любую точку планеты </h5>
        </fieldset>
    </form>

    <form class="form-horizontal">
        <fieldset>
            <h5> >>> Конфиденциальность и безопасность Вашей финансовой информации </h5>
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
                     <button id="signup" name="signup" class="btn btn-success">РЕГИСТРИРУЙТЕСЬ и присоединяйтесь к TIT Co</button>
                     <button id="login" name="login" class="btn btn-info">ВХОДИТЕ и управляйте своими счетами</button>
                </div>
            </div>
        </fieldset>
    </form>

</div>
</body>
</html>