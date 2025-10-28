<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>게시글 상세</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .container { width: 70%; margin: 20px auto; }
        .post-box { border: 1px solid #ddd; border-radius: 5px; }
        .post-header { padding: 20px; border-bottom: 1px solid #ddd; }
        .post-meta { font-size: 0.9em; color: #666; margin-top: 10px; }
        .post-content { padding: 20px; min-height: 200px; }
        .post-content pre {
            white-space: pre-wrap;
            word-wrap: break-word;
            font-family: inherit;
        }
        .post-actions { padding: 20px; background-color: #f9f9f9; text-align: right; }
        .btn {
            display: inline-block; padding: 8px 12px; background-color: #007bff;
            color: white; text-decoration: none; border-radius: 4px; border: none; cursor: pointer;
        }
        .btn-secondary { background-color: #6c757d; }
        .btn-danger { background-color: #dc3545; }
        .delete-form { display: inline-block; margin-left: 10px; }
        .delete-form input[type="password"] { padding: 6px; }
        /* 삭제 실패 시 표시되는 오류 메시지 */
        .error-message {
            color: red; font-weight: bold; background-color: #ffe0e0;
            border: 1px solid red; padding: 10px; border-radius: 4px; margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>게시글 상세</h2>

    <c:if test="${not empty param.error}">
        <div class="error-message">
            <c:out value="${param.error}" />
        </div>
    </c:if>

    <div class="post-box">
        <div class="post-header">
            <h3><c:out value="${post.title}" /></h3>
            <div class="post-meta">
                <span>작성자: <c:out value="${post.writer}" /></span> |
                <span>작성일: <fmt:formatDate value="${post.createdAt}" pattern="yyyy-MM-dd HH:mm" /></span>
                <c:if test="${post.createdAt != post.updatedAt}">
                    | <span>(최종 수정: <fmt:formatDate value="${post.updatedAt}" pattern="yyyy-MM-dd HH:mm" />)</span>
                </c:if>
            </div>
        </div>

        <div class="post-content">
            <pre><c:out value="${post.content}" /></pre>
        </div>

        <div class="post-actions">
            <a href="${pageContext.request.contextPath}/posts" class="btn btn-secondary" style="float:left;">목록</a>

            <a href="${pageContext.request.contextPath}/posts/edit?id=${post.postId}" class="btn">수정</a>

            <form action="${pageContext.request.contextPath}/posts/delete" method="POST" class="delete-form">
                <input type="hidden" name="postId" value="${post.postId}" />
                <input type="password" name="passphrase" placeholder="비밀번호" required minlength="4" maxlength="20" />
                <button type="submit" class="btn btn-danger"
                        onclick="return confirm('정말 삭제하시겠습니까?');">삭제</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>