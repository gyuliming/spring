<%--
  Created by IntelliJ IDEA.
  User: songk
  Date: 2025-10-28
  Time: 오후 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ex04_1 view</title>
</head>
<body>
    <h1>${todoDTO}</h1>
    <h1><c:out value="${todoDTO}"></c:out></h1>
</body>
</html>
