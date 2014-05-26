<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Profile</title>
    <style type="text/css">

        .title{
            float: left;
            left: 10px;
            font: italic 15pt/12pt ;
        }

        .profile {
            float: left;
            position: relative;
            top: 150px;
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
<div class="title"> <h1>
    StudentBook ITIS
</h1>
</div>

<div class="profile" >
    <dl><dt><c:out value="${fio}"/></dt>
        <dd> Дата Рождения: <c:out value="${date}"/></dd>
        <dd> Группа: <c:out value="${group}"/> </dd>
        <dd>Лаборатория : <c:out value="${lab}"/></dd>
        <dd>Активность: <c:out value="${activity}"/></dd> </dl>
    <dl><dt>Дополнительная информация:</dt>
        <dd>Участник СтудВесны 2012</dd>
        <dd>Призер олимпиады по программированию, 3 место</dd>
        <dd>Окончил художественную школу</dd>  </dl>
</div>




</body>
</html>