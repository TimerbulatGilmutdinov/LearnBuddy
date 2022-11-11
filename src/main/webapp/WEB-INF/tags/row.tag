<%@tag description="Default Head Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="labelName" required="true" type="java.lang.String"%>
<%@attribute name="value" required="true" type="java.lang.String"%>

<div class="row">
    <div class="col-md-6">
        <label>${labelName}</label>
    </div>
    <div class="col-md-6">
        <p>${value}</p>
    </div>
</div>