<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 19.06.2020
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<h1><spring:message code="app.title"/></h1> <br>
<h2> Edit Author</h2>
    <form:form method="POST" modelAttribute="user">
        Login: <form:input path="login"/>
        <form:errors path="login"/><br>

        Password: <form:input path="password"/>
        <form:errors path="password"/><br>

        <input type="submit"> <br>
        <br>
        <a href="/user/all"> <<--- Back to Users List </a>
    </form:form>
<br>
<br>
<h5><spring:message code="app.footer"/></h5>
</body>
</html>
