<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Admin Panel</title>
    <link rel="stylesheet" href="<c:url value="/static/css/footer.css"/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            background: -webkit-linear-gradient(left, #3931af, #00c6ff);
            min-height: 100vh
        }

        img {
            height: 30%;
            width: 30%
        }
    </style>
</head>
<body>
<form method="post">
    <input type="text" name="email">
    <button type="submit">Search</button>
    <div class="container py-5">
        <div class="row text-center text-white mb-5">
            <div class="col-lg-7 mx-auto">
                <h1 class="display-4">Found users list</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <ul class="list-group shadow">
                    <c:if test="${foundUser!=null}">
                        <t:foundProfile name="${foundUser.name}" surname="${foundUser.surname}" city="${foundUser.city}"
                                        country="${foundUser.country}"/>
                        <button type="submit" name="delete">Delete User</button>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</form>
<t:footer companyName="Learn Buddy"/>
</body>
</html>
