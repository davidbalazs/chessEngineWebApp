<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sideBarItem" tagdir="/WEB-INF/tags/components/sidebar" %>
<!-- Sidebar -->
<aside id="sidebar">
    <sideBarItem:latestNewsSideBar/>

    <sideBarItem:quoteOfTheDaySideBar/>

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
                position: 'r1bqkbnr/ppQQ1ppp/2n5/1B2p3/4P3/5R2/PPPP1PPP/RNBQK2R',
                showNotation: false
            });</script>

        </div>
    </div>
</aside>