<%@tag description="Default button Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="name" required="true" type="java.lang.String"%>
<%@attribute name="surname" required="true" type="java.lang.String"%>
<%@attribute name="city" required="true" type="java.lang.String"%>
<%@attribute name="country" required="true" type="java.lang.String"%>


<li class="list-group-item">
    <div class="media align-items-lg-center flex-column flex-lg-row p-3">
        <div class="media-body order-2 order-lg-1">
            <h5 class="mt-0 font-weight-bold mb-2">${name} ${surname}</h5>
            <h6>${city} ${country}</h6>
        </div>
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/User_font_awesome.svg/1200px-User_font_awesome.svg.png" alt="Generic placeholder image" width="100%"
             class="ml-lg-5 order-1 order-lg-2">
    </div>
</li>