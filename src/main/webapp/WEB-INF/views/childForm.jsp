<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 21.06.2020
  Time: 09:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Child</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h1><spring:message code="app.title"/></h1> <br>
    <h2>Add Child</h2>

    <form:form method="POST" modelAttribute="child">
        Last Name: <form:input path="lastName"/>
        <form:errors path="lastName"/><br>

        First Name: <form:input path="firstName"/>
        <form:errors path="firstName"/><br>

        Birth Date: <form:input path="birthDate"/>
        <form:errors path="birthDate"/><br>

<%--        Group:(radio button) <form:input path="groups"/>--%>
<%--        <form:errors path="groups"/><br>--%>

<%--        RecSki Color Level: <form:input path="levels"/>--%>
<%--        <form:errors path="levels"/><br>--%>

<%--        Skills:(multiple choice) <form:input path="skills"/>--%>
<%--        <form:errors path="skills"/><br>--%>

<%--        Parent:(multiple choice) <form:input path="parents"/>--%>
<%--        <form:errors path="parents"/><br>--%>

        Description: <form:input path="childDescription"/>
        <form:errors path="childDescription"/><br>

        User: <form:input path="user"/>
        <form:errors path="user"/><br>

        <input type="submit"> <br>
        <br>
    </form:form>

    <a href="/child/all"> <<--- Back to Childs List </a>
    <br>
    <a href="/"> <<<--- Back to HomePage </a><br>
    <br>
    <br>
    <h5><spring:message code="app.footer"/></h5>
</body>
</html>
