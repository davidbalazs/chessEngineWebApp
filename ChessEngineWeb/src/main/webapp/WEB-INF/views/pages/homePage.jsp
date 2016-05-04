<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:mainPageTemplate pageTitle="">

    <img src="<c:url value="/resources/pictures/chess-table.jpg"/>" id="main-page-chess-table">

    <h2>Welcome to Virtual Chess Engine!</h2>

    <p>
        Virtual chess engine is the right place to improve your chess skills. Here you have the chance to play chess
        with a virtual chess player, or simply just solve chess problems. You can also
        learn new chess techniques or strategies.
    </p>

    <h2>What you can do on this site</h2>

    <p>
        You have the chance to <a href="<c:url value="/user/register-form"/>">register</a> and play chess games against the virtual chess player
        as a registered user. You will have a set o statistics and you will be able to save your
        games and come back to them later.
    </p>

</template:mainPageTemplate>
