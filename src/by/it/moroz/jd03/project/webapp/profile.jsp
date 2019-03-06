<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
     <p>User: ${user}</p>
        <p>История заказов:</>
         <p>${orders}</p>
     <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" class="btn btn-primary">Log out</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
