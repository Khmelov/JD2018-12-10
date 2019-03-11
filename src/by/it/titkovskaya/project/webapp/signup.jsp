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
    <h3>WELCOME! Fill in the form, please</h3>

    <form class="form-horizontal" action="do?command=Signup" method="post">
        <fieldset>

            <!-- Text input-->
            <div class="row">
              <label class="col-md-4 control-label" for="login">Login</label>
            </div>
            <div class="row">
              <div class="col-md-4">
              <input id="login" name="login" value="clientLOGIN" type="text" placeholder="YourLogin" class="form-control input-md" required="">
              </div>
            </div>

            <!-- Password input-->
            <div class="row">
              <label class="col-md-4 control-label" for="password">Password</label>
            </div>
            <div class="row">
              <div class="col-md-4">
                <input id="password" name="password" value="12345" type="password" placeholder="*****" class="form-control input-md" required="">
                <span class="help-block">at least 5 characters required</span>
              </div>
            </div>

            <!-- Text input-->
            <div class="row">
              <label class="col-md-4 control-label" for="name">Name</label>
            </div>
            <div class="row">
              <div class="col-md-4">
              <input id="name" name="name" value="Client NAME" type="text" placeholder="Your Name" class="form-control input-md">
              </div>
            </div>

            <!-- Text input-->
            <div class="row">
              <label class="col-md-4 control-label" for="email">Email</label>
            </div>
            <div class="row">
              <div class="col-md-4">
              <input id="email" name="email" value="client@email.com" type="text" placeholder="email@address.com" class="form-control input-md">
              </div>
            </div>

            <!-- Button -->
            <div class="row">
              <label class="col-md-4 control-label" for="signup"></label>
            </div>
            <div class="row">
              <div class="col-md-4">
                <button id="signup" name="signup" class="btn btn-success">SIGN UP</button>
              </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>




