<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:chessTablePageTemplate pageTitle="Chess problem">
    <c:choose>
        <c:when test="${empty chessProblem}">
            <p>The chess problem you have requested is unavailable.</p>
        </c:when>
        <c:otherwise>
            <div id="board" style="width:650px;"></div>
            <script>  var board = ChessBoard('board', {
                position: '${chessProblem.initialPositionFen}',
                showNotation: false
            });</script>
        </c:otherwise>
    </c:choose>
</template:chessTablePageTemplate>
