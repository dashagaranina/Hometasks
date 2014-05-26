<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index</title>
    <style type="text/css">
        .div {
            float: left;
            top: 150px;
            font: bold 12pt/10pt;
            left: 250px;
            border: 3px double darkblue;
            background: fixed lightblue;
        }
    </style>
</head>
<body>
<div class="div">
<h1>Please, logIn</h1>

<form action="profile" method="post">
    <h2>Username</h2>
    <input type="text" name="username"><br/>

    <h2>Password</h2>
    <input type="password" name="password">
    <button type="submit">OK</button>

    <c:if test="${error}">
        <p>Username or passwort are not rigth. Please try again</p>
    </c:if>
</form>  </div>
</body>
</html>