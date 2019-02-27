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
             <legend>Select Operation</legend>
             <div class="form-group">
               <label class="col-md-4 control-label" for="selectbasic"> </label>
               <div class="col-md-4">
                 <select id="id" name="id" class="form-control">
                   <option value="10">Pokupka valuti</option>
                   <option value="20">Prodaga valuti</option>
                   <option value="998">Komunalniy plateg</option>
                   <option value="1000">Podkreplenie</option>
                   <option value="1100">Incasaciya</option>
                 </select>
               </div>
             </div>
                       <!-- Button -->
                         <div class="form-group">
                             <label class="col-md-4 control-label" for="SelectPayment"></label>
                             <div class="col-md-4">
                                 <button id="selectpayment" name="selectpayment" class="btn btn-primary">SelectPayment</button>
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
