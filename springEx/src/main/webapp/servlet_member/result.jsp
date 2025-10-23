<%--
  Created by IntelliJ IDEA.
  User: songk
  Date: 2025-10-22
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 결과</title>
</head>
<body>
<%
    String memberName = (String) request.getAttribute("memberName");
    boolean success = (boolean) request.getAttribute("success");
%>

<h1>회원가입 결과</h1>
<p>
    <% if (success) { %>
    <%= memberName %> 님 회원가입 성공하였습니다.
    <% } else { %>
    다시 시도해주세요.
    <% } %>
</p>

<a href="memberRegister.html">첫화면으로</a>
</body>
</html>
