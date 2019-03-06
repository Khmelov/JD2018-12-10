<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p>User ${user}</p>
    <p>Объявления пользователя: ${ads}</p>

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

