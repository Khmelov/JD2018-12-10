<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <c:choose>
        <c:when test="${user.roles_id==1}">
            <h5>${user.name} (admin)</h5>
        </c:when>
        <c:otherwise>
            <h5>${user.name}</h5>
        </c:otherwise>
    </c:choose>

    <h3>ACCOUNT TRANSACTIONS </h3>
    <p>____________________________________________________________________________________________________</p>
    <div class="row">
        <div class="col-md-2">Number</div>
        <div class="col-md-2">Account Balance</div>
        <div class="col-md-2">Currency</div>
        <div class="col-md-1">Status</div>
    </div>
    <p>____________________________________________________________________________________________________</p>
    <c:forEach items="${accounts}" var="account">
        <form class="form-horizontal-${account.id}" action="do?command=AccTrans" method="post">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${account.id}">

                <div class="col-md-2">${account.number}</div>

                <c:forEach items="${balances}" var="entry">
                    <c:if test="${entry.key==account.id}">
                        <div class="col-md-2">${entry.value}</div>
                    </c:if>
                </c:forEach>

                <div class="col-md-2">${account.currency}</div>
                <c:forEach items="${accstatuses}" var="status">
                    <c:if test="${account.account_status_id==status.id}">
                        <div class="col-md-1">${status.status}</div>
                    </c:if>
                </c:forEach>

                <!-- Button (Double) -->
                <div class="col-md-5">
                    <button id="replenish" name="replenish" class="btn btn-success">REPLENISH account</button>
                    <button id="payment" name="payment" class="btn btn-danger">Make PAYMENT /money TRANSFER</button>
                </div>
            </div>
        </form>
    </c:forEach>

    <div class="row">
        <label class="col-md-7 control-label" for="account">${message1}</label>
    </div>

    <p>____________________________________________________________________________________________________</p>

    <div class="row">
        <label class="col-md-7 control-label" for="account">${message}</label>
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