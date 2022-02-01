<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 29.01.22
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Update author</title>
</head>
<body>
<form:form method="post" modelAttribute="authorToUpdate">
    <spring:bind path="firstName">
        <label for="firstName">
            Set new first name for ${authorToUpdate.firstName}
            <input name="firstName" type="text" id="firstName">
        </label>
    </spring:bind>

    <spring:bind path="lastName">
        <label for="lastName">
            Set last name for ${authorToUpdate.lastName}
            <input name="lastName" type="text" id="lastName">
        </label>
    </spring:bind>
    <input type="submit" value="update">
</form:form>
</body>
</html>
