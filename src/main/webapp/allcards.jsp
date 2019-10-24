<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 11.10.2019
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Все карточки</title>

</head>
<body>

<h2>Список всех карточек.</h2>
<table style=" width: 50%; border: 4px double black;">
    <tr>
    </tr>
    <c:forEach items="${requestScope.list}" var="card">
        <tr>

            <td style="border: 1px solid black; text-align: left"><a href="/card?id=${card.id}">${card.tema}.${card.title}.</a></td>
        </tr>
    </c:forEach>
</table>


<form action="/addcard" method="GET">
    <input type="submit" value="Добавить карточку"/>
</form>

</body>
</html>
