<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<template:administrationPageTemplate pageTitle="Administration- problem of the day">
    <c:choose>
        <c:when test="${empty chessProblems}">
            <p>There are no chess problems available.</p>
        </c:when>
        <c:otherwise>
            <c:forEach items="${chessProblems}" var="chessProblem">
                <div class="chess-problem-item">
                    <a href="<c:url value="/chess-problem/problem?problem-id=${chessProblem.id}"/>" class="center">
                        <div id="chessProblem${chessProblem.id}" style="width: 150px;"></div>
                        <span>${chessProblem.description}</span>
                    </a>
                    <span>Is problem of the day: ${chessProblem.problemOfTheDay}</span>
                    <span>
                        <a href="<c:url value="/administration/problem/mark-as-problem-of-the-day"/>?problem-id=${chessProblem.id}">mark
                            as problem of the day</a></span>
                    <span>
                        <a href="<c:url value="/administration/problem/delete"/>?problem-id=${chessProblem.id}">delete</a></span>
                    <span>${chessProblem.difficultyLevel}</span>
                    <script>  var chessProblem${chessProblem.id} = ChessBoard('chessProblem${chessProblem.id}', {
                        position: '${chessProblem.initialPositionFen}',
                        showNotation: false
                    });</script>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</template:administrationPageTemplate>
