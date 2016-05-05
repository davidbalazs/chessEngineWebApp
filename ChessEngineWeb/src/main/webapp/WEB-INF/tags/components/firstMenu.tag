<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<nav id="menu" class="clearfix">
    <div id="container">
        <ul>
            <li><a href="<c:url value="/"/>">Home</a></li>
            <li><a href="<c:url value="/chessStrategy/display-all"/>">Strategies</a></li>
            <c:choose>
                <c:when test="${isUserLoggedIn}">
                    <li><a href="<c:url value="/statistics"/>">Statistics</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="<c:url value="/login"/>">Login/Register</a></li>
                </c:otherwise>
            </c:choose>
            <li><a href="<c:url value="/how-it-works"/>">How it works</a></li>
            <li><a href="<c:url value="/about-us/"/>">About us</a></li>
            <li><a href="<c:url value="/contact-us/"/>">Contact us</a></li>
        </ul>
    </div>
</nav>
