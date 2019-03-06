<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=Signup" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Sign Up</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="testLogin" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="testPassword" type="password" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="roleId">Role</label>
              <div class="col-md-4">
                <select id="roleId" name="roleId" class="form-control">
                  <option value="2">kassir</option>
                  <option value="1">admin</option>
                </select>
              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signup"></label>
                <div class="col-md-4">
                    <button id="signup" name="signup" class="btn btn-primary">Signup</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>




