<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <script src="js/jquery-1.9.1.js" ></script>
    <script src="js/jquery.validate.min.js" ></script>
    <script src="js/edit-valid.js"></script>

    <title>Edit your profile</title>
    <style type="text/css">



        .profile {
            float: left;
            position: relative;
            top: 10px;
            left: 10px;
            font: 12pt/10pt sans-serif;
            line-height: 1.3;
            border: 3px double darkblue;
            background: fixed lightblue;
            padding: 15px;
            margin-bottom: 10px;
            border-radius: 50px 50px 50px 50px;
        }

    </style>

</head>
<body>
     <div class="profile" >
         <form action="edit" method="post" id="editform" >
            <h2>Редактирование профиля</h2>
            <p>Фамилия, Имя, Отчество: <input type="text" name="fio" id="fio" value="${current_user.fio}"></p>
             <p>Дата рождения: <input type="text" name="date" id="date" value="${current_user.date}"> </p>
             <p>Группа: <input type="text" name="group" id="group" value="${current_user.group}"></p>
             <p>Лаборатория: <input type="text" name="lab" id="lab" value="${current_user.lab}"></p>
             <p>Активность: <input type="text" name="activity" id="activity" value="${current_user.activity}"></p>
             <button type="submit">Сохранить</button>
         </form>
     </div>
</body>
</html>