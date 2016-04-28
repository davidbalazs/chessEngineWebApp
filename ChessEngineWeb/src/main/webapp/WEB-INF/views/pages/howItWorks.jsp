<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:mainPageTemplate pageTitle="How it works?">
    <p>
        ChessEngine is the platform where you can:
    <ul>
        <li><a href="#">Play chess against a virtual chess player using different difficulty levels</a></li>
        <li><a href="#">Study chess strategies</a></li>
        <li><a href="#">Solve chess problems</a></li>
    </ul>

    You can use this platform both as anonymous player or authenticated player. To create your own account, have a
    loog at the <a href="#">Register page</a>.

    Features available for authenticated players are:
    <ul>
        <li>Save a match an continue it later</li>
        <li>Manage the list of saved matches</li>
        <li>See statistics (number of won, drawn or lost matches)</li>
    </ul>
    </p>
</template:mainPageTemplate>
