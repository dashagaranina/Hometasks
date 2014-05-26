<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Authorization</title>
        <style>
            dl.inline dt, dl.inline dd {
                display: inline;
            }
            dl.inline dt {
                font-weight: bold;
            }
        </style>
    </head>

    <body>



    <h1>Please, enter your username and password</h1>

    <form action="login" method="post">
        <h2>Username</h2>
        <input type="text" name="username"><br/>

        <h2>Password</h2>
        <input type="password" name="password">
        <button type="submit">OK</button>

        <c:if test="${error}">
            <p>Username or passwort are not rigth. Please try again</p>
        </c:if>
    </form>
    <div>
        <h4>Зарегистрированные пользователи:</h4>
        <dl class="inline">
            <dt>Lera</dt><dd>1234</dd>
        </dl>
    </div>

    </body>
</html>
