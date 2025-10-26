<%--
  Created by IntelliJ IDEA.
  User: songk
  Date: 2025-10-23
  Time: 오후 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" name="tno" value="${dto.tno}" readonly/><br>
<input type="text" name="title" value="${dto.title}" readonly/><br>
<input type="date" name="dueDate" value="${dto.dueDate}"/><br>
<input type="checkbox" name="finished" value=1
       <c:if test="${dto.finished}">checked</c:if>/><br>
<a href="/todo/modify?tno=${dto.tno}">Modify</a>/<a href="">Remove</a>&nbsp<a href="">List</a>

</body>
</html>
