<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="<c:url value="/static/css/profile.css"/>">
    <link rel ="stylesheet" href="<c:url value="/static/css/footer.css"/>">
</head>
<body>
<div class="container emp-profile">
    <form method="post">
        <div class="save-button">
            <button type="submit">Save</button>
        </div>
        <div class="back-button">
            <a href="${pageContext.request.contextPath}/profile"><button type="button">Go back</button></a>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="profile-img">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/User_font_awesome.svg/1200px-User_font_awesome.svg.png" alt=""/>
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
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="${pageContext.request.contextPath}/update" role="tab" aria-controls="home" aria-selected="true">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="profile-tab" data-toggle="tab" href="${pageContext.request.contextPath}/update/subjects" role="tab" aria-controls="profile" aria-selected="false">Subjects</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <t:input name="name"  type="text" labelName="Name"/>
                        <t:input name="surname"  type="text" labelName="Surame"/>
                        <t:input name="password"  type="password" labelName="Password"/>
                        <t:input name="country"  type="text" labelName="Country"/>
                        <t:input name="city"  type="text" labelName="City"/>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<t:footer companyName="Learn Buddy"/>
</body>
</html>
