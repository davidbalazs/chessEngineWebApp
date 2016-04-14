<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="aside-box">
    <div class="aside-box-header">
        <span>Moves</span>
    </div>
    <div class="aside-box-content">

        <script type="text/javascript" src="<c:url value="/resources/js/chess-strategy.js"/>"></script>
        <input type="button" name="nextMoveButton" class="nextMoveButton" value="Next move"/>
        <table class="chess-strategy-move-table">
            <tr>
                <td>1.</td>
                <td onClick="move('rnbqkbnr/pppppppp/8/8/3P4/8/PPP1PPPP/RNBQKBNR')">d4</td>
                <td onClick="move('rnbqkbnr/ppp1pppp/8/3p4/3P4/8/PPP1PPPP/RNBQKBNR')">d5</td>
            </tr>
            <tr>
                <td>2.</td>
                <td onClick="move('rnbqkbnr/ppp1pppp/8/3p4/3P4/5N2/PPP1PPPP/RNBQKB1R')">nF3</td>
                <td onClick="move('rnbqkb1r/ppp1pppp/5n2/3p4/3P4/5N2/PPP1PPPP/RNBQKB1R')">nF6</td>
            </tr>
            <tr>
                <td>3.</td>
                <td onClick="move('rnbqkb1r/ppp1pppp/5n2/3p4/2PP4/5N2/PP11PPPP/RNBQKB1R')">c4</td>
                <td onClick="move('rnbqkb1r/ppp11ppp/4pn2/3p4/2PP4/5N2/PP11PPPP/RNBQKB1R')">e6</td>
            </tr>
            <tr>
                <td>4.</td>
                <td onClick="move('rnbqkb1r/ppp11ppp/4pn2/3p4/2PP4/2N2N2/PP11PPPP/R1BQKB1R')">nC3</td>
                <td onClick="move('rnbqk2r/ppp11ppp/4pn2/3p4/1bPP4/2N2N2/PP11PPPP/R1BQKB1R')">bB4</td>
            </tr>
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
