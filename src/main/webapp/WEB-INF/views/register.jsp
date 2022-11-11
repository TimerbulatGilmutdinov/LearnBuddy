<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/static/css/register.css"/>">
    <link rel ="stylesheet" href="<c:url value="/static/css/footer.css"/>">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<div class="registration-form">
    <form method="post">
        <h3>Registration</h3><br>
        <t:formGroup name="name" type="text" placeholder="Name"/>
        <t:formGroup name="surname" type="text" placeholder="Surname"/>
        <t:formGroup name="email" type="email" placeholder="Email"/>
        <t:formGroup name="password" type="password" placeholder="Password"/>
        <div class="form-group">
            <label for="birthdate">Birthdate</label>
            <input id="birthdate" type="date" name="birthdate" class="form-control item" id="gender" placeholder="Birthdate" required>
        </div>
        <div class="form-group">
            <label class="form-label">
                <label for="male">Male</label>
                <input id="male" type="radio" name="gender" class="form-control item" value="Male" required>
                <label for="female">Female</label>
                <input id="female" type="radio" name="gender" class="form-control item" value="Female" required>
            </label>
        </div>
        <div class="form-group">
            <label class="form-label">Country</label>
            <select name="country" required>
                <option value="Russia">Russia</option>
                <option value="USA">USA</option>
                <option value="Japan">Japan</option>
                <option value="Ukraine">Ukraine</option>
                <option value="Poland">Poland</option>
                <option value="Germany">Germany</option>
            </select><br>
        </div>
        <t:formGroup name="city" type="text" placeholder="City"/>
        <button type="submit" class="btn btn-block create-account">Create Account</button>
    </form>
</div>
<t:footer companyName="Learn Buddy"/>
</body>
</html>
