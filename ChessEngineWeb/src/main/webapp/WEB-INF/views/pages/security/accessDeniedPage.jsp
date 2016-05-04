<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:mainPageTemplate pageTitle="Access denied page">
    <p>Access denied. You don't have permissions to access this page.</p>
    <c:url value="login" var="loginUrl"/>
    <a href="${loginUrl}">Login with an account that fits required permissions</a>
</template:mainPageTemplate>
