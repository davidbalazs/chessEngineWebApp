<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<%@taglib prefix="component" tagdir="/WEB-INF/tags/components" %>

<%@ attribute name="pageTitle" type="java.lang.String" required="true" %>

<template:genericPageTemplate pageTitle="${pageTitle}">

    <div id="container">

        <!-- Main Content area -->
        <section id="content">

            <component:circlesMenu/>

            <h1>${pageTitle}</h1>

            <jsp:doBody/>

        </section>

        <component:sideBar/>
    </div>
</template:genericPageTemplate>