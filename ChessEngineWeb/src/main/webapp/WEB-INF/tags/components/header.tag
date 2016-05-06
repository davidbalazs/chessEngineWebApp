<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="component" tagdir="/WEB-INF/tags/components" %>

<div id="container">
    <!-- header -->
    <header id="header">

        <div id="header-column-logo">
            <a href="/"><img src="<c:url value="/resources/img/logo.png"/>"/></a>
        </div>

        <div id="header-image-center">
            <img src="<c:url value="/resources/img/header-center.png"/>">
        </div>

        <div id="header-second-menu-right">
            <ul>
                <c:choose>
                    <c:when test="${isUserLoggedIn}">
                        <li><a href="<c:url value="/user-profile/"/>">Hi, ${loggedInUser.username}!</a></li>
                        <li><a href="<c:url value="/logout"/>">Logout</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="<c:url value="/login"/>">Login</a></li>
                        <li><a href="#">English</a></li>
                    </c:otherwise>
                </c:choose>


            </ul>
        </div>

    </header>
</div>

<component:firstMenu/>
