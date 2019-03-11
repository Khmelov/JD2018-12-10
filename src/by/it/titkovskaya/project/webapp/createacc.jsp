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

    <h3>ACCOUNT CREATION</h3>

    <form class="form-horizontal-${account.id}" action="do?command=CreateAcc" method="post">
        <div class="row">
            <label class="col-md-4 control-label" for="currency">Choose account CURRENCY</label>
        </div>

        <div class="row">
            <div class="col-md-3">
                <select id="currency" name="currency" class="form-control">
                    <option value="BYN">BYN</option>
                    <option value="USD">USD</option>
                    <option value="EUR">EUR</option>
                    <option value="RUB">RUB</option>
                    <option value="UAH">UAH</option>
                    <option value="KZT">KZT</option>
                    <option value="PLN">PLN</option>
                    <option value="CNY">CNY</option>
                    <option value="JPY">JPY</option>
                </select>
            </div>
            <!-- Button -->
            <div class="col-md-6">
                 <button id="accountButton" name="accountButton" class="btn btn-success">CREATE ACCOUNT</button>
            </div>
        </div>
    </form>

        <div class="row">
            <label class="col-md-5 control-label" for="currency">${message}</label>
        </div>


    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>
            <!-- Button -->
            <div class="row">
                <div class="col-md-4">
                     <button id="profileButton" name="profileButton" class="btn btn-info">Back to PERSONAL CABINET</button>
                </div>
            </div>
        </fieldset>
    </form>

</div>
</body>
</html>


