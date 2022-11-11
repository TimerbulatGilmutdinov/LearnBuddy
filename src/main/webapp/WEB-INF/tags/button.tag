<%@tag description="Default button Tag" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="href" required="true" type="java.lang.String" %>
<%@attribute name="text" required="true" type="java.lang.String" %>
<%@attribute name="id" required="false" type="java.lang.String" %>


<a href="${href}">
    <button id="${id}">${text}</button>
</a>
