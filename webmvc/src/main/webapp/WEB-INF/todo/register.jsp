<%--
  Created by IntelliJ IDEA.
  User: songk
  Date: 2025-10-23
  Time: 오후 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function fn_validate() {
            let register = document.register;
            let title = register.title.value;

            if (!title || title === "") {
                alert ("제목을 입력하세요.");
                return false;
            }
        }
    </script>
</head>
<body>
    <form action="/todo/register" name="register" method="post">
        <input type="text" name="title" id="title" placeholder="INSERT TITLE"><br>
        <input
                type="date"
                name="dueDate"
                id="dueDate"
                value="2025-10-24"
                min="2025-01-01"
                max="2025-12-31" /><br>
        <button type="reset">RESET</button>
        <button type="submit" onclick="fn_validate()">REGISTER</button>
    </form>
</body>
</html>
