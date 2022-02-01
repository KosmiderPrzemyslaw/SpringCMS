<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 28.01.22
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addCategory" method="post">
    <label for="name">Category name</label>
    <input id="name" type="text" name="name">
    <label for="description">Description</label>
    <input id="description" type="text" name="description">
    <input type="submit">
</form>
</body>
</html>
