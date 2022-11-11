<%@tag description="Default navItemTag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="href" required="true" type="java.lang.String"%>
<%@attribute name="name" required="true" type="java.lang.String"%>
<%@attribute name="activity" required="true" type="java.lang.String"%>

<li class="nav-item">
    <a class="nav-link ${activity}" id="home-tab" data-toggle="tab"
       href="${href}" role="tab" aria-controls="home"
       aria-selected="true">${name}</a>
</li>