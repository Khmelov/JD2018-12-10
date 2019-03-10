<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">

<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=Login" method="POST">
<fieldset>

<!-- Form Name -->
<legend>SignUp</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Login</label>
  <div class="col-md-4">
  <input id="Login" name="Login" value = "TestUser" type="text" placeholder="min 6 symbols" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" value = "TestPassword" type="password" placeholder="" class="form-control input-md" required="">

  </div>
</div>



<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singupbutton"></label>
  <div class="col-md-4">
    <button id="login" name="login" class="btn btn-success">Login</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>

