<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>

<template:mainPageTemplate pageTitle="About us">
    <p>
        Virtual chess engine is a challenge for you to win a matches against the virtual chess player. We are
        continuously update the virtual chess player to offer you the best experience and
        a good opponent.
    </p>

    <h2>What you can do on this site</h2>

    <p>
        You have the chance to <a href="<c:url value="/user/register-form"/>">register</a> and play chess games against the virtual chess player
        as a registered user. You will have a set o statistics and you will be able to save your
        games and come back to them later.
    </p>

    <p>If you have any questions, don't hesitate to <a href="<c:url value="/contact-us/"/>">Contact us</a>!</p>
</template:mainPageTemplate>
