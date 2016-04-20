<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="aside-box">
    <div class="aside-box-header">
        <span>Moves</span>
    </div>
    <div class="aside-box-content">

        <script type="text/javascript" src="<c:url value="/resources/js/chess-strategy.js"/>"></script>
        <input type="button" name="nextMoveButton" class="nextMoveButton" value="Next move"/>
        <table class="chess-strategy-move-table">
            <c:forEach items="${chessStrategy.movePairs}" var="movePair" varStatus="loopStatus">
                <tr>
                    <td>${loopStatus.index}.</td>
                    <td onClick="move('${movePair.whiteMove.move.fenPosition}')">${movePair.whiteMove.description}</td>
                    <td onClick="move('${movePair.blackMove.move.fenPosition}')">${movePair.blackMove.description}</td>
                </tr>
            </c:forEach>
        </table>
        <script>
            <%--TODO fix this script.
            Current version is http://jsfiddle.net/65JPw/1569/
             It was made using this tutorial: http://jsfiddle.net/65JPw/2/--%>


            $("#movesTable td").click(function () {
                var columnNumber = $(this).parent().children().index($(this));
                if (columnNumber != 0) {
                    $("#movesTable td").removeClass('selected');
                    $(this).addClass('selected');
                    var value = $(this);
                }
            });

            $('.nextMoveButton').on('click', function (e) {
                var currentSelectedTableCell = $("#movesTable td.selected");
                var columnNumber = currentSelectedTableCell.parent().children().index(currentSelectedTableCell);
                if (columnNumber == 1) {
                    var nextMoveTableRow = currentSelectedTableCell.next();

                    if (nextMoveTableRow == null) {
                        nextMoveTableRow = $("#movesTable tr:first");
                    }

                    nextMoveTableRow.addClass('selected').siblings().removeClass('selected');
                }
                else if (columnNumber == 2) {
                    var nextMoveTableRow = currentSelectedTableCell.parent().next().children().first().next();

                    if (nextMoveTableRow == null) {
                        nextMoveTableRow = $("#movesTable tr:first");
                    }

                    $("#movesTable td").removeClass('selected');
                    nextMoveTableRow.addClass('selected');
                }
            });
        </script>
    </div>
</div>
