<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Log in</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="<c:url value="/static/css/login.css"/>">
</head>
<body>

<div class="form-bg">
    <div class="container justify-content-center">
        <div class="row mt-5">
            <div class="col-md-offset-3 col-md-6">
                <form class="form-horizontal" method="post">
                    <span class="heading">Log In</span>
                    <div class="form-group">
                        <input type="email" name="email" value="${email}" class="form-control" id="inputEmail3" placeholder="Email" required>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" value="${password}" class="form-control" id="inputPassword3" placeholder="Password" required>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">log in</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
