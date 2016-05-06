<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="aside-box">
    <div class="aside-box-header">
        <span>Chess game</span>
    </div>
    <div class="aside-box-content">
        <ul>
            <li><a href="<c:url value="/chessStrategy/display-all"/>">Chess strategies</a></li>
            <li><a href="<c:url value="/playgame/"/>">Play game</a></li>
            <li><a href="<c:url value="/chess-problem/display-all"/>">Chess problems</a></li>
        </ul>
    </div>
</div>
