<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${not empty chessProblemOfTheDay}">
    <div class="aside-box">
        <div class="aside-box-header">
            <span>Problem of the day</span>
        </div>
        <div class="aside-box-content">
            <a href="#" class="center">
                <div id="problemOfTheDayBoard" style="width: 267px;"></div>
                <h5>Solve it!</h5>
            </a>

            <script>  var problemOfTheDayBoard = ChessBoard('problemOfTheDayBoard', {
                position: '${chessProblemOfTheDay.initialPositionFen}',
                showNotation: false
            });</script>

        </div>
    </div>
</c:if>
