<%--
  Created by IntelliJ IDEA.
  User: axis
  Date: 24.10.2019
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> ${card.id}. ${card.title}</title>
</head>
<body>
<h1> ${card.tema}. ${card.title}</h1>
<p>
    <textarea readonly="readonly" rows="20" cols="100">
        ${card.text}</textarea>
</p>
<table>
    <tr>
        <td>
            <form action="/card" method="POST">
                <input type="submit" value="PREVIOUS"/>
                <input type="hidden" name="ind" value=${ind-1} />
            </form>
        </td>
        <td>
            <form action="/cardupdate" method="GET">
                <input type="submit" value="Изменить"/>
                <input type="hidden" name="id" value=${card.id} />
            </form>
        </td>
        <td>
            <form action="/carddelete" method="POST">
                <input type="submit" value="Удалить"/>
                <input type="hidden" name="id" value=${card.id} />
            </form>
        </td>
        <td>
            <form action="/card" method="POST">
                <input type="submit" value="NEXT"/>
                <input type="hidden" name="ind" value=${ind+1} />
            </form>
        </td>
    </tr>
</table>
</body>
</html>
