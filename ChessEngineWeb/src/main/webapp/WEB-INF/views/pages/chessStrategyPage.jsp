<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:chessTablePageTemplate pageTitle="Chess strategy - ${chessStrategy.name}">
    <c:choose>
        <c:when test="${empty chessStrategy}">
            <p>The chess strategy you have requested is unavailable.</p>
        </c:when>
        <c:otherwise>
            <script src="<c:url value="/resources/js/chess.js"/>"></script>
            <div id="board" style="width:650px;" class="play-chess-table"></div>
            <script type="text/javascript" src="<c:url value="/resources/js/custom.js"/>"></script>
        </c:otherwise>
    </c:choose>
</template:chessTablePageTemplate>
