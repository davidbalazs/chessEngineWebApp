<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="popup" data-popup="popup-1">
    <div class="popup-inner">
        <h2>Play chess game</h2>

        <p>Here you will need to add a form where user can select virtual player level and which color will he
            prefer.</p>

        <h1><a href="<c:url value="/playgame/"/>">play game</a></h1>

        <p><a data-popup-close="popup-1" href="#">Close</a></p>
        <a class="popup-close" data-popup-close="popup-1" href="#">x</a>
    </div>
</div>
