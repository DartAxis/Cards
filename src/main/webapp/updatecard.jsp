<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 24.10.2019
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Исправление карточки</title>
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">Добавить пользователя:</div>
    <table style="border: 4px double black;">

        <form action="/cardupdate" method="GET">

            <tr>
                <td>
                    <label for="title"><span>Вопрос:</span><input type="text" class="input-field" name="title" required
                                                                  id="title"
                                                                  value="${card.title}"/></label>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="text"><span>Ответ:</span><textarea rows="10" cols="45" name="text" id="text">${card.text}</textarea></label>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="tema"><span>Тема:</span>
                        <select name="tema" id="tema" class="select-field">
                            <option value=${card.tema}>${card.tema}</option>
                            <option value="Core">Core</option>
                            <option value="Web">Web</option>
                            <option value="DB">DB</option>
                            <option value="Spring">Spring</option>
                        </select>
                    </label>
                    <input type="hidden" name="id" value="${card.id}"/>
                </td>
            </tr>


            <tr align="center">
                <td>
                    <input type="submit" value="Изменить">
                </td>
            </tr>
        </form>

    </table>
</div>
</body>
</html>
