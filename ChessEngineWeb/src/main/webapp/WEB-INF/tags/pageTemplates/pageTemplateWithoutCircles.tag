<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<%@taglib prefix="component" tagdir="/WEB-INF/tags/components" %>

<%@ attribute name="pageTitle" type="java.lang.String" required="true" %>

<template:genericPageTemplate pageTitle="${pageTitle}" includeChessScripts="true">

    <div id="container">
        <jsp:doBody/>
    </div>
</template:genericPageTemplate>
