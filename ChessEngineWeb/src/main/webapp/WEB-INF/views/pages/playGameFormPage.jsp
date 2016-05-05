<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<template:mainPageTemplate pageTitle="Play game">
    <c:url value="/playgame/save-game-config" var="startGameUrl"/>
    <form:form method="POST" action="${startGameUrl}" class="" modelAttribute="playGameForm">

        <label>Select your color:</label>
        <c:forEach items="${possiblePlayerColorValues}" var="possiblePlayerColorValuesItem" varStatus="loopStatus">
            <form:radiobutton path="playerColor" value="${possiblePlayerColorValuesItem}"
                              label="${possiblePlayerColorValuesItem.name}"/>
        </c:forEach>
        <br/>
        <label>Select virtual player level:</label>
        <c:forEach items="${possibleVirtualPlayerLevels}" var="possibleVirtualPlayerLevelsItem" varStatus="loopStatus">
            <form:radiobutton path="virtualPlayerLevel" value="${possibleVirtualPlayerLevelsItem}"
                              label="${possibleVirtualPlayerLevelsItem.name}"/>
        </c:forEach>
        <form:button type="submit">Start game</form:button>
    </form:form>
</template:mainPageTemplate>
