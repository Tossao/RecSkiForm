<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 19.06.2020
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Parent</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h1><spring:message code="app.title"/></h1> <br>
    <h2>Add Parent</h2>
    <form:form method="POST" modelAttribute="parent">

        Last Name:
        <form:input path="lastName" value="Last Name" onfocus="this.value=''"/>
        <form:errors path="lastName"/><br>

        First Name: <form:input path="firstName" value="First Name" onfocus="this.value=''"/>
        <form:errors path="firstName"/><br>

        Phone Number: <form:input path="phone" value="+48600123456" onfocus="this.value=''"/>
        <form:errors path="phone"/><br>

        e-mail: <form:input path="email" value="example@example.pl" onfocus="this.value=''"/>
        <form:errors path="email"/><br>

<%--        User: <form:select path="user" itemLabel="login" itemValue="id" items="${user}"/> <br>--%>
        User:<form:select path="user">
        <form:option value="-" label="--Please Select One--"/>
        <form:options itemLabel="login" itemValue="id" items="${user}"/>
        </form:select>
        <form:errors path="user"/><br>

        <input type="submit"> <br>
        <br>

    </form:form>
    <a href="/parent/all"> <<--- Back to Parents List </a>
    <br>
    <a href="/"> <<<--- Back to HomePage </a><br>
    <br>
    <br>
    <p class="footer"><spring:message code="app.footer"/></p>

</body>
</html>
