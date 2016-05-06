<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:mainPageTemplate pageTitle="User profile page">

    <table class="user-profile-table">
        <tr>
            <td>Username:</td>
            <td> ${loggedInUser.username}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td> ${loggedInUser.email}</td>
        </tr>
        <tr>
            <td>Name:</td>
            <td> ${loggedInUser.firstName} ${loggedInUser.lastName}</td>
        </tr>
        <tr>
            <td>Account state:</td>
            <td> ${loggedInUser.state}</td>
        </tr>
    </table>
</template:mainPageTemplate>
