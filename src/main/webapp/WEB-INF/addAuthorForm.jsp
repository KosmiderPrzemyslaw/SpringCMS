<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 29.01.22
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <spring:bind path="firstName">
        <label for="firstName">
            First name:
            <input id="firstName" type="text" name="firstName">
        </label>
    </spring:bind>
    <br>
    <spring:bind path="lastName">
        <label for="lastName">
            Last name:
            <input id="lastName" type="text" name="lastName">
        </label>
    </spring:bind>
<input type="submit" value="save">
</form:form>
</body>
</html>
