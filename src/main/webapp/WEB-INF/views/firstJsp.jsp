<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Chess</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/reset.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
<div id="container">
    <!-- header -->
    <header id="header">

        <div id="header-column-logo">
            <img src="img/logo.png">
        </div>

        <div id="header-image-center">
            <img src="img/header-center.png">
        </div>

        <div id="header-second-menu-right">
            <ul>
                <li><a href="login.html">Login</a></li>
                <li><a href="#">English</a></li>
            </ul>
        </div>

    </header>
</div>

<!-- Navigation -->
<nav id="menu" class="clearfix">
    <div id="container">
        <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="chess-strategies.html">Strategies</a></li>
            <li><a href="#">How it works</a></li>
            <li><a href="statistics.html">Statistics</a></li>
            <li><a href="about-us.html">About us</a></li>
            <li><a href="contact-us.html">Contact us</a></li>
        </ul>
    </div>
</nav>
<div id="container">

    <!-- Main Content area -->
    <section id="content">
        <div id="circles-section">
            <a href="chess-problem-item.html"><img src="img/circles/circle1.png" onmouseover="this.src='img/circles/circle1hover.png'" onmouseout="this.src='img/circles/circle1.png'" /></a>
            <a href="play-game.html"><img src="img/circles/circle2.png" onmouseover="this.src='img/circles/circle2hover.png'" onmouseout="this.src='img/circles/circle2.png'" /></a>
            <a href="login.html"><img src="img/circles/circle3.png" onmouseover="this.src='img/circles/circle3hover.png'" onmouseout="this.src='img/circles/circle3.png'" /></a>
        </div>

        <img src="pictures/chess-table.jpg" id="main-page-chess-table">

        <h2>Welcome to Virtual Chess Engine!</h2>
        <p>
            Virtual chess engine is the right place to improve your chess skills. Here you have the chance to play chess with a virtual chess player, or simply just solve chess problems. You can also
            learn new chess techniques or strategies.
        </p>
        <h2>What you can do on this site</h2>
        <p>
            You have the chance to <a href="login.html">register</a> and play chess games against the virtual chess player as a registered user. You will have a set o statistics and you will be able to save your
            games and come back to them later.
        </p>
    </section>

    <!-- Sidebar -->
    <aside  id="sidebar">
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
                    <img src="pictures/chess-problem.jpg">
                    <br/>
                    <h5>Solve it!</h5>
                </a>
            </div>
        </div>
    </aside>
</div>

<!-- Footer -->
<footer id="footer" class="clearfix">
    Copyright &copy Balazs David 2015
</footer>
</body>
</html>
