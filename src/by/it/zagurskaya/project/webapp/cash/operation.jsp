<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
             111111111111
          </td>
       </tr>
    </table>
</div>
</body>
</html>
