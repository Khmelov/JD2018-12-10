<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=Checkout" method="post">
<fieldset>

<!-- Form Name -->
<legend>Chekout</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="namecheckout">Name</label>
  <div class="col-md-4">
  <input id="namecheckout" name="namecheckout" type="text" placeholder="Your name" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="tel">Telephone</label>
  <div class="col-md-4">
  <input id="tel" name="tel" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>
</div>
</body>
</html>