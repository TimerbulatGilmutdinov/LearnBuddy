<%@tag description="Default Input Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="name" required="true" type="java.lang.String"%>
<%@attribute name="type" required="true" type="java.lang.String"%>
<%@attribute name="placeholder" required="true" type="java.lang.String"%>

<div class="form-group">
    <input type="${type}" name="${name}" class="form-control item" placeholder="${placeholder}" required>
</div>