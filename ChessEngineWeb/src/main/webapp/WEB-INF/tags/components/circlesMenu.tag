<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="component" tagdir="/WEB-INF/tags/components" %>
<div id="circles-section">
    <a href="<c:url value="/chess-problem/display-all"/>">
        <img src="<c:url value="/resources/img/circles/circle1.png"/>"
             onmouseover="this.src='<c:url value="/resources/img/circles/circle1hover.png"/>'"
             onmouseout="this.src='<c:url value="/resources/img/circles/circle1.png"/>'"/>
    </a>
    <a class="btn" href="<c:url value="/playgame/"/>">
        <img src="<c:url value="/resources/img/circles/circle2.png"/>"
             onmouseover="this.src='<c:url value="/resources/img/circles/circle2hover.png"/>'"
             onmouseout="this.src='<c:url value="/resources/img/circles/circle2.png"/>'"/>
    </a>
    <a href="<c:url value="/chessStrategy/display-all"/>">
        <img src="<c:url value="/resources/img/circles/circle6.png"/>"
             onmouseover="this.src='<c:url value="/resources/img/circles/circle6hover.png"/>'"
             onmouseout="this.src='<c:url value="/resources/img/circles/circle6.png"/>'"/>
    </a>
</div>
