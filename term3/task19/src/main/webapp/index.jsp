<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Authorization</title>
    </head>

    <body>

    <%--<h1>Введи логин и пароль:</h1>--%>
        <%--<form action="login" method="post">--%>

            <%--<h2></h2>--%>
            <%--<input type="text" name="username" ><br/>--%>
            <%--<h2></h2>--%>
            <%--<input type="password" name="password" ><br/>--%>
            <%--<button type="submite">OK</button>--%>
            <%--<c:if test="error">--%>
                <%--<p>Your username or password is not right. Please, try again.</p>--%>
            <%--</c:if>--%>
        <%--</form>--%>

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

    </body>
</html>
