<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<nav id="menu" class="clearfix">
    <div id="container">
        <ul>
            <li><a href="<c:url value="/"/>">Home</a></li>
            <li><a href="<c:url value="/chessStrategy/display-all"/>">Strategies</a></li>
            <li><a href="<c:url value="/how-it-works/"/>">How it works</a></li>
            <li><a href="statistics.html">Statistics</a></li>
            <li><a href="<c:url value="/about-us/"/>">About us</a></li>
            <li><a href="<c:url value="/contact-us/"/>">Contact us</a></li>
        </ul>
    </div>
</nav>
