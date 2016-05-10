<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<template:administrationPageTemplate pageTitle="Administration- add chess strategy">
    <form:form method="POST" action="add-strategy-details" class="contact-us-form" modelAttribute="chessStrategyDetails">
        <form:input path="name" placeholder="Name"/>
        <c:forEach items="${possibleChessStrategyCategories}" var="possibleChessStrategyCategory">
            <form:radiobutton path="category" value="${possibleChessStrategyCategory}"
                              label="${possibleChessStrategyCategory}"/>
        </c:forEach>

        <form:button type="submit">Send message</form:button>
    </form:form>
</template:administrationPageTemplate>
