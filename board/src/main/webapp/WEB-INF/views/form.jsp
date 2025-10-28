<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${isEdit ? '게시글 수정' : '새 글 작성'}</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .container { width: 70%; margin: 20px auto; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; font-weight: bold; }
        .form-control {
            width: 100%; padding: 10px; box-sizing: border-box; /* 패딩 포함 */
            border: 1px solid #ccc; border-radius: 4px;
        }
        .form-control[readonly] { background-color: #eee; }
        .btn {
            display: inline-block; padding: 10px 15px; background-color: #007bff;
            color: white; text-decoration: none; border-radius: 4px; border: none; cursor: pointer;
        }
        .btn-secondary { background-color: #6c757d; }
        .error-message {
            color: red; font-weight: bold; background-color: #ffe0e0;
            border: 1px solid red; padding: 10px; border-radius: 4px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>${isEdit ? '게시글 수정' : '새 글 작성'}</h2>

    <c:if test="${not empty errorMessage}">
        <div class="error-message">
            <p><c:out value="${errorMessage}" /></p>
        </div>
    </c:if>

    <c:url var="formAction" value="${isEdit ? '/posts/update' : '/posts/save'}" />

    <form action="${formAction}" method="POST">

        <c:if test="${isEdit}">
            <input type="hidden" name="postId" value="${post.postId}" />
        </c:if>

        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" value="${post.title}" class="form-control"
                   required minlength="2" maxlength="200">
        </div>

        <div class="form-group">
            <label for="writer">작성자</label>
            <input type="text" id="writer" name="writer" value="${post.writer}" class="form-control"
            ${isEdit ? 'readonly' : 'required minlength="1" maxlength="50"'} >
        </div>

        <div class="form-group">
            <label for="content">내용</label>
            <textarea id="content" name="content" rows="15" class="form-control"
                      required minlength="5">${post.content}</textarea>
        </div>

        <div class="form-group">
            <label for="passphrase">
                ${isEdit ? '비밀번호 (수정/삭제용)' : '비밀번호 (4~20자)'}
            </label>
            <input type="password" id="passphrase" name="passphrase" class="form-control"
                   required minlength="4" maxlength="20">
        </div>

        <div class="form-group">
            <button type="submit" class="btn">${isEdit ? '수정하기' : '등록하기'}</button>
            <a href="${pageContext.request.contextPath}/posts" class="btn btn-secondary">취소</a>
        </div>
    </form>
</div>
</body>
</html>