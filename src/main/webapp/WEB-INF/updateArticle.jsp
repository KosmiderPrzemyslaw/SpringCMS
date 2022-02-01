<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 31.01.22
  Time: 23:13
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
<form:form modelAttribute="article" method="post">
    <label for="content">
        Set content
        <input name="content" type="text" id="content">
    </label>
    Set new title for ${article.title}
    <label for="title">
        <input name="title" type="text" id="title">
    </label>
    <form:select itemValue="id" path="author.id" items="${authors}"/>


    <form:select  itemValue="id" itemLabel="name" path="categories" items="${categories}" multiple="true"/>

    <input type="submit" value="update">
</form:form>
</body>
</html>
