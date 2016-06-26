<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<template:administrationPageTemplate pageTitle="Administration - news">
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <form:form method="POST" action="add" class="contact-us-form" modelAttribute="newsData">
        <form:input path="title" placeholder="Title"/>
        <form:textarea path="text" placeholder="Text"/>

        <form:button type="submit">Add news</form:button>
    </form:form>

    <c:choose>
        <c:when test="${empty newsList}">
            <p>There are no news.</p>
        </c:when>
        <c:otherwise>
            <table class="administration-table">
                <tr>
                    <th>Title</th>
                    <th>Text</th>
                    <th>Date</th>
                    <th></th>
                </tr>
                <c:forEach items="${newsList}" var="newsItem">
                    <tr>
                        <td>${newsItem.title}</td>
                        <td>${newsItem.text}</td>
                        <td>${newsItem.date}</td>
                        <td><a href="<c:url value="/administration/news/delete"/>?news-id=${newsItem.id}">delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</template:administrationPageTemplate>
