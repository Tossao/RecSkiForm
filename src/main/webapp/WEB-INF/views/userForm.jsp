<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 19.06.2020
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h1><spring:message code="app.title"/></h1> <br>
        <h2>Add User</h2>
        <form:form method="POST" modelAttribute="user">
            Login: <form:input path="login" value="Enter Login" onfocus="this.value=''"/>
            <form:errors path="login"/><br>

            Password: <form:password path="password"/>
            <form:errors path="password"/><br>

            <input type="submit"> <br>
            <br>
        </form:form>
    <a href="/user/all"> <<--- Back to Users List </a>
    <br>
    <a href="/"> <<<--- Back to HomePage </a><br>
    <br>
    <br>
    <p class="footer"><spring:message code="app.footer"/></p>
</body>
</html>
