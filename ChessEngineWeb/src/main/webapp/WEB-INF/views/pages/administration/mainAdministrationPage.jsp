<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Admin page</h1>
<c:url value="/logout" var="logoutUrl"/>
<a href="${logoutUrl}">Logout</a>
</form>
</body>
</html>
