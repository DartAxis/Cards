<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавление пользователя.</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">Добавить пользователя:</div>
    <table style="border: 4px double black;">

        <form action="/addcard
" method="POST">

            <tr>
                <td>
                    <label for="title"><span>Вопрос:</span><input type="text" class="input-field" name="title" required
                                                                  id="title"
                                                                  value=""/></label>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="text"><span>Ответ:</span><textarea rows="10" cols="45" name="text" id="text"></textarea></label>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="tema"><span>Тема:</span>
                        <select name="tema" id="tema" class="select-field">
                            <option value="Core">Core</option>
                            <option value="Web">Web</option>
                            <option value="DB">DB</option>
                            <option value="Spring">Spring</option>
                        </select>
                    </label>
                </td>
            </tr>


            <tr align="center">
                <td>
                    <input type="submit" value="Добавить">
                </td>
            </tr>
        </form>

    </table>
</div>
</body>
</html>