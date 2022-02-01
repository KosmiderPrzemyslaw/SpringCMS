<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 30.01.22
  Time: 00:00
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
<form:form method="post" modelAttribute="article">
    <spring:bind path="content">
        <label for="content">
            Content of article:
            <input type="text" id="content" name="content">
        </label>
    </spring:bind>

    <spring:bind path="title">
        <label for="title">
            Title:
            <input type="text" id="title" name="title">
        </label>
    </spring:bind>

    <form:select itemValue="id" path="author.id" items="${authors}"/>

    <input type="submit" value="save">
</form:form>
</body>
</html>
