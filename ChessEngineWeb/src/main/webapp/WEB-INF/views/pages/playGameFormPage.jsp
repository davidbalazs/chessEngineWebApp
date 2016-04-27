<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<template:mainPageTemplate pageTitle="Not found - 404">
    <form:form method="POST" action="strt-game" class="contact-us-form" modelAttribute="playGameForm">
        <form:input path="virtualPlayerLevel" placeholder="Virtual player level"/>

        <form:input path="playerColor" placeholder="player color"/>

        <form:button type="submit">Send message</form:button>
    </form:form>
</template:mainPageTemplate>

