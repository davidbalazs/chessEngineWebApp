<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:administrationPageTemplate pageTitle="Administration - messages">
    <c:choose>
        <c:when test="${empty messages}">
            <p>There are no messages.</p>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Message</th>
                    <th>Date</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${messages}" var="message">
                    <tr>
                        <td>${message.username}</td>
                        <td>${message.email}</td>
                        <td>${message.text}</td>
                        <td>${message.date}</td>
                        <c:choose>
                            <c:when test="${message.read eq true}">
                                <td><a href="<c:url value="/administration/messages/mark-message-as-unread"/>?message-id=${message.id}">Mark as unread</a></td>
                            </c:when>
                            <c:otherwise>
                                <td><a href="<c:url value="/administration/messages/mark-message-as-read"/>?message-id=${message.id}">Mark as read</a></td>
                            </c:otherwise>
                        </c:choose>
                        <td><a href="">delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

</template:administrationPageTemplate>
