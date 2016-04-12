<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:mainPageTemplate pageTitle="Chess strategies">
    <c:choose>
        <c:when test="${empty chessStrategies}">
            <p>There are no chess strategies available.</p>
        </c:when>
        <c:otherwise>
            <ul class="container-list">
                <c:forEach items="${chessStrategies}" var="chessStrategy" varStatus="loopStatus">
                    <li><a href="<c:url value="/chessStrategy/display-strategy?id=${chessStrategy.id}"/>">${chessStrategy.name}
                        (${chessStrategy.category})</a></li>

                    <c:if test="${!loopStatus.last}">
                        <hr/>
                    </c:if>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</template:mainPageTemplate>
