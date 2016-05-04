<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<template:mainPageTemplate pageTitle="Register">
    <c:choose>
        <c:when test="${not empty userRegisteredSuccessfully}">
            <h2>Thank you!</h2>

            <p>Thank you for registering! You can <a href="<c:url value="/login"/>">login here</a>.</p>

            <p><a href="<c:url value="/"/>">Go to home page</a></p>
        </c:when>
        <c:otherwise>
            <c:if test="${errorMessages}">
                <c:forEach items="${errorMessages}" var="errorMessage">
                    <p>${errorMessage}</p>
                </c:forEach>
            </c:if>
            <form:form method="POST" action="register-user" class="contact-us-form" modelAttribute="user">
                <form:input path="username" placeholder="username"/>
                <form:errors path="username" cssClass="formValidationErrorMessage"/>

                <form:password path="password" placeholder="password"/>
                <form:errors path="password" cssClass="formValidationErrorMessage"/>

                <form:password path="reTypedPassword" placeholder="retype password"/>
                <form:errors path="reTypedPassword" cssClass="formValidationErrorMessage"/>

                <form:input path="email" placeholder="email"/>
                <form:errors path="email" cssClass="formValidationErrorMessage"/>

                <form:input path="firstName" placeholder="first name"/>
                <form:errors path="firstName" cssClass="formValidationErrorMessage"/>

                <form:input path="lastName" placeholder="last name"/>
                <form:errors path="lastName" cssClass="formValidationErrorMessage"/>

                <form:button type="submit">Register</form:button>
            </form:form>
        </c:otherwise>
    </c:choose>
</template:mainPageTemplate>
