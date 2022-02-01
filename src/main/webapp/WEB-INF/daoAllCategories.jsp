<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 29.01.22
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${daoAllCategories}" var="category">
    ${category} <a href="/deleteCategory/${category.id}">Delete</a>
    <a href="/updateCategory/${category.id}">Update</a>

    <br>
</c:forEach>

<a href="/addCategory">Add new category</a>
</body>
</html>
