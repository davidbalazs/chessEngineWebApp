<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:pageTemplateWithoutCircles pageTitle="Login">
    <c:if test="${not empty message}">
        ${message}
    </c:if>
    <c:url value="" var="loginUrl"/>
    <div class="login-block">
        <form action="${loginUrl}" method="post">
            <input type="text" value="" placeholder="Username" id="username" name="username"/>
            <input type="password" value="" placeholder="Password" id="password" name="password"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit">Login</button>
            <a href="#" class="login-block-recover-password">Lost password?</a>
            <a href="<c:url value="/user/register-form"/>" class="login-block-register">Register here</a>

            <div style="clear:both;"></div>
        </form>
    </div>
</template:pageTemplateWithoutCircles>
