<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="component" tagdir="/WEB-INF/tags/components" %>

<%@ attribute name="pageTitle" type="java.lang.String" required="true" %>
<%@ attribute name="includeChessScripts" type="java.lang.Boolean" %>
<!DOCTYPE html>
<html>
<head>
    <title>
        ChessEngine
        <c:if test="${not empty pageTitle}">
            - ${pageTitle}
        </c:if>
    </title>

    <link rel="shortcut icon" type="image/png" href="<c:url value="/resources/img/favicon.png" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/reset.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

    <c:if test="${includeChessScripts}">
        <!-- chess table related -->
        <link rel="stylesheet" href="<c:url value="/resources/css/chessboard.css" />"/>

        <script src="<c:url value="/resources/js/json3.min.js" />"></script>
        <script src="<c:url value="/resources/js/jquery-1.10.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/chessboard.js" />"></script>
        <script src="<c:url value="/resources/js/mainJavaScript.js" />"></script>
        <!-- end chess table related -->
    </c:if>
</head>
<body>

<component:header/>
<jsp:doBody/>
<component:footer/>

</body>
</html>
