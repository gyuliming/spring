<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>게시판 목록</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .container { width: 80%; margin: 20px auto; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: center; }
        th { background-color: #f4f4f4; }
        .table-hover tr:hover { background-color: #f1f1f1; }
        .btn {
            display: inline-block; padding: 8px 12px; background-color: #007bff;
            color: white; text-decoration: none; border-radius: 4px;
        }
        .btn-new { float: right; margin-bottom: 10px; }
        .title-link { text-decoration: none; color: #333; }
        .title-link:hover { text-decoration: underline; }
    </style>
</head>
<body>
<div class="container">
    <h2>게시판 목록</h2>

    <a href="${pageContext.request.contextPath}/posts/new" class="btn btn-new">글쓰기</a>

    <table class="table-hover">
        <thead>
        <tr>
            <th style="width:10%;">번호</th>
            <th style="width:50%;">제목</th>
            <th style="width:15%;">작성자</th>
            <th style="width:25%;">작성일</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${empty postList}">
                <tr>
                    <td colspan="4">등록된 게시글이 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="post" items="${postList}">
                    <tr>
                        <td><c:out value="${post.postId}" /></td>
                        <td style="text-align: left;">
                            <a href="${pageContext.request.contextPath}/posts/view?id=${post.postId}" class="title-link">
                                <c:out value="${post.title}" />
                            </a>
                        </td>
                        <td><c:out value="${post.writer}" /></td>
                        <td>
                            <fmt:formatDate value="${post.createdAt}" pattern="yyyy-MM-dd" />
                        </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</div>
</body>
</html>