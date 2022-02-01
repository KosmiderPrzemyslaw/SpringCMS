<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 01.02.22
  Time: 22:45
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
<form:form method="post" modelAttribute="student">
    <form:input path="firstName"/>
    <form:input path="lastName"/>
    <form:textarea path="notes" rows="3" cols="20"/>
    <form:checkbox path="reciveMessages"/>

    Php: <form:checkbox path="skills" value="php"/>
    Java: <form:checkbox path="skills" value="java"/>
    Ruby: <form:checkbox path="skills" value="ruby"/>
    Python: <form:checkbox path="skills" value="python"/>

    <form:radiobuttons path="skills" items="${skills}" itemLabel="name" itemValue="id"/>
    <input type="submit" value="save">
</form:form>
</body>
</html>
