<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:mainPageTemplate pageTitle="Chess problems">
    <c:choose>
        <c:when test="${empty chessProblems}">
            <p>There are no chess problems available.</p>
        </c:when>
        <c:otherwise>
            <c:forEach items="${chessProblems}" var="chessProblem">
                    <a href="#" class="center">
                        <div id="chessProblem${chessProblem.id}" style="width: 267px;"></div>
                        <p>${chessProblem.description}</p>
                    </a>

                <script>  var chessProblem${chessProblem.id} = ChessBoard('chessProblem${chessProblem.id}', {
                    position: '${chessProblem.initialPositionFen}',
                    showNotation: false
                });</script>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</template:mainPageTemplate>
