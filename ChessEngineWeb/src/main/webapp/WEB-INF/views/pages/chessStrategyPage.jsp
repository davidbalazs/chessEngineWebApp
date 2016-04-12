<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:mainPageTemplate pageTitle="Chess strategy">
    <c:choose>
        <c:when test="${empty chessStrategy}">
            <p>The chess strategy you have requested is unavailable.</p>
        </c:when>
        <c:otherwise>
            ${chessStrategy.name}
            <script src="js/chess.js"></script>
            <div id="board" style="width:650px;" class="play-chess-table"></div>
            <script type="text/javascript" src="js/custom.js"></script>
        </c:otherwise>
    </c:choose>
</template:mainPageTemplate>
