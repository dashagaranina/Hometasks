<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
    <meta charset="utf-8">
</head>
<body>

<h2>Submitted Information</h2>
<spring:url value="/" var="root"/>
<table>
    <tr><td >Name & Number</td></tr>
    <c:forEach var="id" items="${name}">
        <tr>
            <td><c:out value="${id}"/></td>
         </tr>
    </c:forEach>

    <%--<c:forEach var="id" items="${number}">--%>

            <%--<td><c:out value="${id}"/></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>


</table>
<a href="${root}">New contact</a>
</body>
</html>