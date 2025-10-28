<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<html>
<head>
    <title>오류 발생</title>
    <style>
        .container { width: 70%; margin: 30px auto; padding: 20px; border: 1px solid #ddd; }
        .error-box { color: #D8000C; background-color: #FFBABA; padding: 15px; border-radius: 5px; }
        .links { margin-top: 20px; }
        .links a { margin-right: 10px; }
    </style>
</head>
<body>
<div class="container">
    <h2>처리 중 오류가 발생했습니다.</h2>
    <hr>
    <div class="error-box">
        <p>
            <b>[오류 메시지]</b>
        </p>
        <p>
            <c:if test="${not empty errorMessage}">
                <c:out value="${errorMessage}" />
            </c:if>

            <c:if test="${empty errorMessage && not empty exception}">
                <c:out value="${exception.message}" />
            </c:if>
        </p>
    </div>

    <div class="links">
        <a href="javascript:history.back()">[ 뒤로 가기 ]</a>
        <a href="${pageContext.request.contextPath}/posts">[ 목록으로 가기 ]</a>
    </div>
</div>
</body>
</html>