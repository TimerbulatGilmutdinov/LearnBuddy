<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="<c:url value="/static/css/profile.css"/>">
    <link rel ="stylesheet" href="<c:url value="/static/css/footer.css"/>">
</head>
<body>
<div class="container emp-profile">
    <t:button href="${pageContext.request.contextPath}/logout" text="Log out"/>
    <t:button href="${pageContext.request.contextPath}/update" text="Edit my profile"/>
    <t:button href="${pageContext.request.contextPath}/delete" text="Delete my account"/>
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
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/User_font_awesome.svg/1200px-User_font_awesome.svg.png" alt=""/>
                </div>
            </div>
            <div class="col-md-6">
                <div class="profile-head">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link" id="home-tab" data-toggle="tab" href="${pageContext.request.contextPath}/profile" role="tab" aria-controls="home" aria-selected="true">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" id="profile-tab" data-toggle="tab" href="${pageContext.request.contextPath}/profile/subjects" role="tab" aria-controls="profile" aria-selected="false">Subjects</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Maths</label>
                            </div>
                            <div class="col-md-6">
                                <c:choose>
                                    <c:when test="${userSubject.maths == true}">
                                        <input type="checkbox" id="maths" name="maths" value="true" checked disabled/>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" id="maths" name="maths" value="true" disabled/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Physics</label>
                            </div>
                            <div class="col-md-6">
                                <c:choose>
                                    <c:when test="${userSubject.physics == true}">
                                        <input type="checkbox" id="maths" name="maths" value="true" checked disabled/>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" id="maths" name="maths" value="true" disabled/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Programming</label>
                            </div>
                            <div class="col-md-6">
                                <c:choose>
                                    <c:when test="${userSubject.programming == true}">
                                        <input type="checkbox" id="maths" name="maths" value="true" checked disabled/>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" id="maths" name="maths" value="true" disabled/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>English Language</label>
                            </div>
                            <div class="col-md-6">
                                <c:choose>
                                    <c:when test="${userSubject.englishLanguage == true}">
                                        <input type="checkbox" id="maths" name="maths" value="true" checked disabled/>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" id="maths" name="maths" value="true" disabled/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>History</label>
                            </div>
                            <div class="col-md-6">
                                <c:choose>
                                    <c:when test="${userSubject.history == true}">
                                        <input type="checkbox" checked disabled/>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" disabled/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Economics</label>
                            </div>
                            <div class="col-md-6">
                                <c:choose>
                                    <c:when test="${userSubject.economics == true}">
                                        <input type="checkbox" checked disabled/>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" disabled/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Law</label>
                            </div>
                            <div class="col-md-6">
                                <c:choose>
                                    <c:when test="${userSubject.law == true}">
                                        <input type="checkbox" checked disabled/>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" disabled/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<t:footer companyName="Learn Buddy"/>
</body>
</html>
