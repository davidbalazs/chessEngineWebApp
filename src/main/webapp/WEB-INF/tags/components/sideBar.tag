<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Sidebar -->
<aside id="sidebar">
    <div class="aside-box">
        <div class="aside-box-header">
            <span>Latest news</span>
        </div>
        <div class="aside-box-content">
            <h5>Site is now online!</h5>
            <p>Browse the site and <a href="contact-us.html">send us feedback</a>.</p>
            <span class="latest-news-date">29/12/2015</span>
            <hr/>
            <h5>New design available!</h5>
            <p>The new design has been successfully installed on the site.</p>
            <span class="latest-news-date">29/12/2015</span>
        </div>
    </div>

    <div class="aside-box">
        <div class="aside-box-header">
            <span>Quote of the day</span>
        </div>
        <div class="aside-box-content">
            <p>First of all, chess teaches you to be objective!</p>
        </div>
    </div>

    <div class="aside-box">
        <div class="aside-box-header">
            <span>Problem of the day</span>
        </div>
        <div class="aside-box-content">
            <a href="#" class="center">
                <img src="<c:url value="/resources/pictures/chess-problem.jpg"/>">
                <br/>
                <h5>Solve it!</h5>
            </a>
        </div>
    </div>
</aside>