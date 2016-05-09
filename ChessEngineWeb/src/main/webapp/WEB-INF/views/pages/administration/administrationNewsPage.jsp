<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:administrationPageTemplate pageTitle="Administration - news">
    <c:choose>
        <c:when test="${empty news}">
            <p>There are no news.</p>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Text</th>
                    <th>Date</th>
                    <th></th>
                </tr>
                <c:forEach items="${news}" var="newsItem">
                    <tr>
                        <td>${newsItem.title}</td>
                        <td>${newsItem.text}</td>
                        <td>${newsItem.date}</td>
                        <td><a href="<c:url value="/administration/news/delete"/>?news-id=${newsItem.id}">delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</template:administrationPageTemplate>
