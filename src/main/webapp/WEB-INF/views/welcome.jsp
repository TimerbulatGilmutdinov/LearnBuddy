<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/static/css/welcome.css"/>">
    <link rel ="stylesheet" href="<c:url value="/static/css/footer.css"/>">
</head>
<body>
<div>
    <div class="header-blue">
        <nav class="navbar navbar-dark navbar-expand-md navigation-clean-search">
            <div class="container"><a class="navbar-brand" href="#">Learn Buddy</a>
                <button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                        class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse"
                     id="navcol-1">
                    <form class="form-inline mr-auto" target="_self">
                    </form>
                    <span class="navbar-text"> <a href="${pageContext.request.contextPath}/login" class="login">Log In</a></span><a
                        class="btn btn-light action-button" role="button" href="${pageContext.request.contextPath}/register">Sign Up</a></div>
            </div>
        </nav>
        <div class="container hero">
            <div class="row">
                <div class="col-12 col-lg-6 col-xl-5 offset-xl-1">
                    <h1>It's easier to learn together</h1>
                    <p>Unite and meet each other with our service</p>
                    <button class="btn btn-light btn-lg action-button" type="button">Learn More</button>
                </div>
            </div>
        </div>
    </div>
</div>
<t:footer companyName="Learn Buddy"/>
</body>
</html>
