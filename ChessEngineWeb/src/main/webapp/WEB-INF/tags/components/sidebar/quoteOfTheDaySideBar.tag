<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty quoteOfTheDay}">
    <div class="aside-box">
        <div class="aside-box-header">
            <span>Quote of the day</span>
        </div>
        <div class="aside-box-content">
            <p>${quoteOfTheDay.quote} - ${quoteOfTheDay.author}</p>
        </div>
    </div>
</c:if>