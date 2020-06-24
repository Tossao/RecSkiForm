<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 19.06.2020
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Parent</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h1><spring:message code="app.title"/></h1> <br>
    <h2> Edit Parent</h2>
    <form:form method="POST" modelAttribute="parent">
        Last Name: <form:input path="lastName"/>
        <form:errors path="lastName"/><br>

        First Name: <form:input path="firstName"/>
        <form:errors path="firstName"/><br>

        Phone Number: <form:input path="phone"/>
        <form:errors path="phone"/><br>

        e-mail: <form:input path="email"/>
        <form:errors path="email"/><br>

        User: <form:select path="user" itemLabel="login" itemValue="id" items="${user}"/> <br>

        <input type="submit"> <br>
        <br>

    </form:form>
    <a href="/parent/all"> <<--- Back to Users List </a>
    <br>
    <a href="/"> <<<--- Back to HomePage </a><br>
    <br>
    <br>
    <h5><spring:message code="app.footer"/></h5>
</body>
</html>
