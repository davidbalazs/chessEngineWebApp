<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>

<template:chessGamePageTemplate pageTitle="Play">
    <p align=" center" id="status"></p>
    <script src="<c:url value="/resources/js/chess.js" />"></script>
    <div id="board" style="width:650px;" class="play-chess-table"></div>

    <script type="text/javascript">
        var playerColor = "${playerColor}";
        var virtualPlayerLevel = "${virtualPlayerLevel}";
        var tableOrientation = '${tableOrientation}';
        var virtualPlayerColor = "${virtualPlayerColor}";
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/customPlayChessGame.js" />"></script>
</template:chessGamePageTemplate>
