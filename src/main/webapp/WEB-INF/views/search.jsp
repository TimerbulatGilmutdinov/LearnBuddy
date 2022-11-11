<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recommendations</title>
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
<a href="${pageContext.request.contextPath}/profile">
    <button>My profile</button>
</a>
<form method="post">
    <select name="subjectName" required>
        <option name="maths" value="maths">Maths</option>
        <option name="physics" value="physics">Physics</option>
        <option name="englishLanguage" value="english_language">English</option>
        <option name="programming" value="programming">Programming</option>
        <option name="history" value="history">History</option>
        <option name="economics" value="economics">Economics</option>
        <option name="law" value="law">Law</option>
    </select>
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
                    <c:forEach items="${foundUsersBySubjectName}" var="foundUser">
                        <t:foundProfile name="${foundUser.name}" surname="${foundUser.surname}" city="${foundUser.city}"
                                        country="${foundUser.country}"/>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</form>
<t:footer companyName="Learn Buddy"/>
</body>
</html>