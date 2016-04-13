<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sideBarItem" tagdir="/WEB-INF/tags/components/sidebar" %>
<!-- Sidebar -->
<aside id="sidebar">
    <div class="aside-box">
        <div class="aside-box-header">
            <span>Chess game</span>
        </div>
        <div class="aside-box-content">
            <ul>
                <li><a href="<c:url value="/chessStrategy/display-all"/>">Strategies</a></li>
                <li><a href="<c:url value="/playgame/"/>">Play game</a></li>
            </ul>
        </div>
    </div>

    <div class="aside-box">
        <div class="aside-box-header">
            <span>Moves</span>
        </div>
        <div class="aside-box-content">
            <%--TODO highlight the current move, by using this example: http://jsfiddle.net/65JPw/2/--%>
            <script type="text/javascript" src="<c:url value="/resources/js/chess-strategy.js"/>"></script>
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
        </div>
    </div>
</aside>
