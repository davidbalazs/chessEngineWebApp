<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="aside-box">
    <div class="aside-box-header">
        <span>Side bars</span>
    </div>
    <div class="aside-box-content">
        <ul>
            <li><a href="<c:url value="/administration/news/show-all"/>">Add news</a></li>
            <li><a href="<c:url value="/administration/quote/show-all"/>">Add quote of the day</a></li>
            <li><a href="<c:url value="/administration/problem/show-all"/>" >Select problem of the day</a></li>
        </ul>
    </div>
</div>
