<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="<c:url value="/static/css/profile.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/css/footer.css"/>">
</head>
<body>
<div class="container emp-profile">
    <form method="post">

        <button type="submit">Save</button>

        <t:button href="${pageContext.request.contextPath}/profile" text="Go back"/>
        <div class="row">
            <div class="col-md-4">
                <div class="profile-img">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/User_font_awesome.svg/1200px-User_font_awesome.svg.png"
                         alt=""/>
                    <div class="file btn btn-lg btn-primary">
                        Change Photo
                        <input type="file" name="file"/>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="profile-head">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link" id="home-tab" data-toggle="tab"
                               href="${pageContext.request.contextPath}/update" role="tab">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" id="profile-tab" data-toggle="tab"
                               href="${pageContext.request.contextPath}/update/subjects" role="tab">Subjects</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <t:input name="maths" value="true" type="checkbox" labelName="Maths"/>
                        <t:input name="physics" value="true" type="checkbox" labelName="Physics"/>
                        <t:input name="programming" value="true" type="checkbox" labelName="Programming"/>
                        <t:input name="englishLanguage" value="true" type="checkbox" labelName="English Language"/>
                        <t:input name="history" value="true" type="checkbox" labelName="History"/>
                        <t:input name="economics" value="true" type="checkbox" labelName="Economics"/>
                        <t:input name="law" value="true" type="checkbox" labelName="Law"/>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<t:footer companyName="Learn Buddy"/>
</body>
</html>
