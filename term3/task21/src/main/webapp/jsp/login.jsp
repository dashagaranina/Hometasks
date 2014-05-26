<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">


    <title>Profile</title>
    <style type="text/css">



        .profile {
            float: left;
            position: relative;
            top: 1px;
            left: 10px;
            margin-top: 10px;
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
    <h1>
        StudentBook ITIS
    </h1>
    <dl><dt><c:out value="${credentials.fio}"/></dt>
        <dd> Дата Рождения: <c:out value="${credentials.date}"/></dd>
        <dd> Группа: <c:out value="${credentials.group}"/> </dd>
        <dd>Лаборатория : <c:out value="${credentials.lab}"/></dd>
        <dd>Активность: <c:out value="${credentials.activity}"/></dd> </dl>
    <dl><dt>Дополнительная информация:</dt>
        <dd>Участник СтудВесны 2012</dd>
        <dd>Призер олимпиады по программированию, 3 место</dd>
        <dd>Окончил художественную школу</dd>  </dl>





    <a href="edit" class="btn">Редактировать</a>



</div>




</body>
</html>