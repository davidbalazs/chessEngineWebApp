<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty latestNews}">
    <div class="aside-box">
        <div class="aside-box-header">
            <span>Latest news</span>
        </div>
        <div class="aside-box-content">
            <c:forEach items="${latestNews}" var="latestNewsEntity" varStatus="loopStatus">
                <h5>${latestNewsEntity.title}</h5>

                <p>${latestNewsEntity.text}</p>
                <span class="latest-news-date">${latestNewsEntity.date}</span>
                <c:if test="${!loopStatus.last}">
                    <hr/>
                </c:if>
            </c:forEach>
        </div>
    </div>
</c:if>
