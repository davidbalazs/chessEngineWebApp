<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<template:administrationPageTemplate pageTitle="Administration - Quote of the day">
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <form:form method="POST" action="add" class="contact-us-form" modelAttribute="quoteData">
        <form:input path="author" placeholder="Author"/>
        <form:textarea path="quote" placeholder="Quote"/>

        <form:button type="submit">Add quote</form:button>
    </form:form>

    <c:choose>
        <c:when test="${empty quoteList}">
            <p>There are no quotes.</p>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>Quote</th>
                    <th>Author</th>
                    <th>is quote of the day</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${quoteList}" var="quote">
                    <tr>
                        <td>${quote.quote}</td>
                        <td>${quote.author}</td>
                        <td>${quote.quoteOfTheDay}</td>
                        <td><a href="<c:url value="/administration/quote/delete"/>?quote-id=${quote.id}">delete</a>
                        <td>
                            <c:choose>
                                <c:when test="${quote.quoteOfTheDay}">
                                    <a href="<c:url value="/administration/quote/unmark-as-quote-of-the-day"/>?quote-id=${quote.id}">Unmark
                                        as quote of the day.</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="<c:url value="/administration/quote/mark-as-quote-of-the-day"/>?quote-id=${quote.id}">Mark
                                        as quote of the day.</a>
                                </c:otherwise>
                            </c:choose>

                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</template:administrationPageTemplate>
