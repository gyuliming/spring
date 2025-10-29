<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Member Register</h1>

<%--@elvariable id="member" type=""--%>
<form:form method="post" modelAttribute="member" action="${pageContext.request.contextPath}/members">
    <div>
        <label>아이디</label>
        <form:input path="userId"/>
        <form:errors path="userId" cssStyle="color:red"/>
    </div>
    <div>
        <label>비밀번호</label>
        <form:password path="userPwd"/>
        <form:errors path="userPwd" cssStyle="color:red"/>
    </div>
    <div>
        <label>이름</label>
        <form:input path="userName"/>
        <form:errors path="userName" cssStyle="color:red"/>
    </div>
    <div>
        <label>이메일</label>
        <form:input path="userEmail"/>
        <form:errors path="userEmail" cssStyle="color:red"/>
    </div>
    <div>
        <label>가입일자</label>
        <form:input path="joinDate" type="date"/>
    </div>
    <div>
        <button type="submit">저장</button>
    </div>
</form:form>
