<html>
<%@ include file="/../include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="/../include/menucash.jsp" %>
    <p>CashCurrency ${message}</p>
    <table style="width:100%; height:80%">
       <tr>
          <td colspan="8" style="text-align:center;border: 1px solid black;width: 30%;">
           <ul class="nav flex-column">
             <li class="nav-item">
               <a class="nav-link" href="do?command=AllCurrency">AllCurrency</a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="do?command=RateNB">RateNB</a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="do?command=RateCB">RateCB</a>
             </li>
           </ul>
          </td>
          <td style="border: 1px solid black;  text-align: center ;width:70%" data-toggle="dropdown">
             111111111111
          </td>
       </tr>
    </table>
</div>
</body>
</html>
