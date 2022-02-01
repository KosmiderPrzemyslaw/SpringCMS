<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 28.01.22
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="categoryById">
    <spring:bind path="name">
        <label for="name">Category name</label>
        <input id="name" type="text" name="name">
    </spring:bind><br>
    <spring:bind path="description">
        <label for="descritpion">Set new description for category ${categoryById.name}</label>
        <input id="descritpion" type="text" name="description">
    </spring:bind>
    <input type="submit" value="Update">
</form:form>
</body>
</html>
