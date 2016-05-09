<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<nav id="menu" class="clearfix">
    <div id="container">
        <ul>
            <c:choose>
                <c:when test="${isUserLoggedIn and loggedInUserRole eq 'ROLE_ADMIN'}">
                    <li><a href="<c:url value="/administration/messages/show-messages"/>">Messages</a></li>
                    <li><a href="#">Users</a></li>
                    <li><a href="#">General statistics</a></li>
                    <li><a href="#">Add strategy</a></li>
                    <li><a href="#">Add problem</a></li>
                </c:when>
                <c:otherwise>

                    <li><a href="<c:url value="/"/>">Home</a></li>
                    <c:choose>
                        <c:when test="${isUserLoggedIn}">
                            <li><a href="<c:url value="/statistics/"/>">Statistics</a></li>
                            <li><a href="<c:url value="/user-profile/"/>">My Profile</a></li>
                            <li><a href="#">Load saved game</a></li>

                        </c:when>
                        <c:otherwise>
                            <li><a href="<c:url value="/login"/>">Login/Register</a></li>
                            <li><a href="<c:url value="/how-it-works"/>">How it works</a></li>
                        </c:otherwise>
                    </c:choose>

                    <li><a href="<c:url value="/about-us/"/>">About us</a></li>
                    <li><a href="<c:url value="/contact-us/"/>">Contact us</a></li>

                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
