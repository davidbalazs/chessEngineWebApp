<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="circles-section">
    <a href="chess-problem-item.html">
        <img src="<c:url value="/resources/img/circles/circle1.png"/>"
             onmouseover="this.src='<c:url value="/resources/img/circles/circle1hover.png"/>'"
             onmouseout="this.src='<c:url value="/resources/img/circles/circle1.png"/>'"/>
    </a>
    <a href="<c:url value="/playgame/"/>">
        <img src="<c:url value="/resources/img/circles/circle2.png"/>"
             onmouseover="this.src='<c:url value="/resources/img/circles/circle2hover.png"/>'"
             onmouseout="this.src='<c:url value="/resources/img/circles/circle2.png"/>'"/>
    </a>
    <a href="#">
        <img src="<c:url value="/resources/img/circles/circle3.png"/>"
             onmouseover="this.src='<c:url value="/resources/img/circles/circle3hover.png"/>'"
             onmouseout="this.src='<c:url value="/resources/img/circles/circle3.png"/>'"/>
    </a>
</div>
