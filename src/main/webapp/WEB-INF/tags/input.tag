<%@tag description="Default Input Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="name" required="true" type="java.lang.String"%>
<%@attribute name="value" required="false" type="java.lang.String"%>
<%@attribute name="type" required="true" type="java.lang.String"%>
<%@attribute name="labelName" required="true" type="java.lang.String"%>

<jsp:doBody/>
<div class="row">
    <div class="col-md-6">
        <label>${labelName}</label>
    </div>
    <div class="col-md-6">
        <input type="${type}" name="${name}" value="${value}">
    </div>
</div>
<jsp:doBody/>