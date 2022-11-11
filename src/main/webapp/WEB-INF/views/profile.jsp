<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="<c:url value="/static/css/profile.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/css/footer.css"/>">
    <script src="<c:url value="/js/delete.js"/>"></script>
</head>
<body>
<div class="container emp-profile">
    <t:button href="${pageContext.request.contextPath}/logout" text="Log out"/>
    <t:button href="${pageContext.request.contextPath}/update" text="Edit my profile"/>
    <t:button id="delete" href="${pageContext.request.contextPath}/delete" text="Delete my account"/>
    <t:button href="${pageContext.request.contextPath}/feed" text="See recommendations"/>

    <c:if test="${isAdmin == true}">
        <a href="${pageContext.request.contextPath}/adminPanel">
            <button>Go to Admin Panel</button>
        </a>
    </c:if>


    <form method="post">
        <div class="row">
            <div class="col-md-4">
                <div class="profile-img">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/User_font_awesome.svg/1200px-User_font_awesome.svg.png"
                         alt=""/>
                </div>
            </div>
            <div class="col-md-6">
                <div class="profile-head">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <t:navItem activity="active" href="${pageContext.request.contextPath}/profile" name="About"/>
                        <t:navItem activity="" href="${pageContext.request.contextPath}/profile/subjects"
                                   name="Subjects"/>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <t:row labelName="Name" value="${user.name}"/>
                        <t:row labelName="Surname" value="${user.surname}"/>
                        <t:row labelName="Email" value="${user.email}"/>
                        <t:row labelName="Gender" value="${user.gender}"/>
                        <t:row labelName="Country" value="${user.country}"/>
                        <t:row labelName="City" value="${user.city}"/>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<t:footer companyName="Learn Buddy"/>
</body>
</html>
