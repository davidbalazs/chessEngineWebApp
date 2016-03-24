<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<%@taglib prefix="component" tagdir="/WEB-INF/tags/components" %>
<template:genericPageTemplate>

    <div id="container">

        <!-- Main Content area -->
        <section id="content">

            <component:circlesMenu/>

            <jsp:doBody/>

        </section>

            <component:sideBar/>
    </div>
</template:genericPageTemplate>