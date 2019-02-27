<html>
<%@ include file="/../include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="/../include/menucash.jsp" %>
    <p>Cash Operation ${message}</p>
    <table style="width:100%; height:80%">
       <tr>
          <td colspan="8" style="text-align:center;border: 1px solid black;width: 30%;">
             <ul class="nav flex-column">
               <li class="nav-item">
                 <a class="nav-link active" href="do?command=Payment">Payment</a>
               </li>
               <li class="nav-item">
                 <a class="nav-link" href="do?command=Balance">Balance</a>
               </li>
               <li class="nav-item">
                 <a class="nav-link" href="do?command=UserOperations">User operations</a>
               </li>
             </ul>
          </td>
          <td style="border: 1px solid black;  text-align: center ;width:70%" data-toggle="dropdown">
          <form class="form-horizontal">
          <fieldset>
          <legend>Pokupka valuti</legend>
          <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasic">currency</label>
            <div class="col-md-4">
              <select id="selectbasic" name="selectbasic" class="form-control">
                <option value="643">Rossiya</option>
                <option value="840">USD</option>
                <option value="978">EUR</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-4 control-label" for="Summa">Summa</label>
            <div class="col-md-4">
            <input id="Summa" name="Summa" type="text" placeholder="summa" class="form-control input-md" required="">
            </div>
          </div>
          </fieldset>
          </form>
          </td>
       </tr>
    </table>
</div>
</body>
</html>
