<%--
  Created by IntelliJ IDEA.
  User: songk
  Date: 2025-10-23
  Time: 오후 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo List Page</title>
</head>
<body>
    <h1>Todo List</h1>
<%--
    EL(Expression Language)
    ${list}
    <h3>${1+2+3}</h3>
    <h3>${"AAA" += "BBB"}</h3>
    <h3>${"AAA".equals("AAA")}</h3>
    <h4>${list[0].tno}</h4>
    <h4>${list[0].title}</h4>
    <h4>${list[0].dueDate}</h4>
    --%>
    <form action="/todo/read" method="get">
    <ul>
        <c:forEach var="dto" items="${dtoList}">
            <li><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a> ${dto.title} ${dto.dueDate} ${dto.finished}</li>
        </c:forEach>
    </ul>
    </form>
<%--    <ul>--%>
<%--        <c:forEach var="num" begin="1" end="10">--%>
<%--            <li>${num}</li>--%>
<%--        </c:forEach>--%>
<%--    </ul>--%>

<%--    <c:if test="${list.size() % 2 == 0}">--%>
<%--        짝수--%>
<%--    </c:if>--%>
<%--    <c:if test="${list.size() % 2 != 0}">--%>
<%--        홀수--%>
<%--    </c:if>--%>
<%--    <br>--%>

<%--    <c:choose>--%>
<%--        <c:when test="${list.size() % 2 == 0}">--%>
<%--            짝수--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            홀수--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
<%--    <br>--%>

<%--    <c:set var="target" value="5"></c:set>--%>
<%--        <c:forEach var="num" begin="1" end="10">--%>
<%--            <c:if test="${num == target}">--%>
<%--                num is target--%>
<%--            </c:if>--%>
<%--        </c:forEach>--%>

</body>
</html>
