<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=".">TIT Co Payment System </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <div class="navbar-nav">
            <mytag:menu command="ResetDB" text=" Reset Database"/>
            <c:choose>
                <c:when test="${user.roles_id==1}">
                    <mytag:menu command="EditUsers" text=" List of Clients"/>
                    <mytag:menu command="EditAcc" text="List of Accounts"/>
                </c:when>
                <c:when test="${user.roles_id==2}">
                    <mytag:menu command="CreateAcc" text=" Create Account"/>
                    <mytag:menu command="AccTrans" text="Account Transactions"/>
                    <mytag:menu command="AccInfo" text="Account Info"/>
                </c:when>
            </c:choose>
        </div>
        <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
            <c:choose>
                <c:when test="${user!=null}">
                    <mytag:menu command="Profile" text="Personal Cabinet"/>
                    <mytag:menu command="Logout" text="Logout"/>
                </c:when>
                <c:otherwise>
                    <mytag:menu command="SignUp" text="Sign up"/>
                    <mytag:menu command="Login" text="Sign in"/>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>





