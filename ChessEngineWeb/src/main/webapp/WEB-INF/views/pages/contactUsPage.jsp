<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<template:mainPageTemplate pageTitle="Contact us">
    <form:form method="POST" action="send-message" class="contact-us-form" modelAttribute="contactUsForm">
        <form:input path="username" placeholder="Name"/>
        <form:errors path="username"/>

        <form:input path="email" placeholder="Email"/>
        <form:errors path="email"/>

        <form:textarea path="message" placeholder="Message"/>
        <form:errors path="message"/>

        <form:button type="submit">Send message</form:button>
    </form:form>

</template:mainPageTemplate>
