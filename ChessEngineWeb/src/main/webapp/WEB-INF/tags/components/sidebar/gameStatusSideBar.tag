<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="aside-box">
    <div class="aside-box-header">
        <span>Status</span>
    </div>
    <div class="aside-box-content">
        <p>Number of moves made: <span id="number-of-moves-made">0</span></p>
        <script>
            $(document).ready(function () {
                $(document).ajaxStart(function () {
                    $("#loading-image").css("display", "block");
                });
                $(document).ajaxComplete(function () {
                    $("#loading-image").css("display", "none");
                });
            });
        </script>

        <p id="loading-image" style="display: none;">
            <img src="<c:url value="/resources/img/loading_image.gif"/>" style="width:20px;"/>
            Virtual Player is thinking
        </p>
    </div>
</div>
