<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 29.01.22
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${articles}" var="article">
    ${article}
    <a href="/deleteArticle/${article.id}">Delete</a>
    <a href="/updateArticle/${article.id}">Update</a>
    <br>
</c:forEach>
<a href="/addArticle">Add new article</a>
</body>
</html>
