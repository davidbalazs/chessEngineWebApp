<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<template:administrationPageTemplate pageTitle="Administration">
    <c:choose>
        <c:when test="${empty users}">
            <p>There are no users.</p>
        </c:when>
        <c:otherwise>
            <table class="administration-table">
                <tr>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Name</th>
                    <th>Account state</th>
                    <th>actions</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.firstName} ${user.lastName}</td>
                        <td>${user.state}</td>
                        <td>
                            <a href="<c:url value="/administration/users/delete"/>">delete</a>

                            <c:choose>
                                <c:when test="${user.state == 'BLOCKED'}">
                                    <a href="<c:url value="/administration/users/unblock"/>">unblock</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="<c:url value="/administration/users/block"/>">block</a>
                                </c:otherwise>
                            </c:choose>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</template:administrationPageTemplate>
