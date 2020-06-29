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
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
</head>
<body>
<h1><spring:message code="app.title"/></h1> <br>
<h2>Add Child</h2>

<form:form method="POST" modelAttribute="child">
    Last Name: <form:input path="lastName" value="Enter Last Name" onfocus="this.value=''"/>
    <form:errors path="lastName"/><br>

    First Name: <form:input path="firstName" value="Enter First Name" onfocus="this.value=''"/>
    <form:errors path="firstName"/><br>

    Birth Date: <form:input path="birthDate" value="yyyy-MM-dd" onfocus="this.value=''"/>
    <form:errors path="birthDate"/><br>

    Style:<form:select path="style" itemLabel="styleName" itemValue="id" items="${style}"/>
        <form:errors path="style"/><br>

    RecSki.pl Color Level:<form:select path="level" itemLabel="levelColor" itemValue="id" items="${level}"/>
    <form:errors path="level"/><br>

    Skills: <form:checkboxes path="skills" items="${skill}" itemLabel="skillName" itemValue="id"/>
    <form:errors path="skills"/><br>

    Parents: <form:select path="parents" items="${parent}" itemLabel="lastName" itemValue="id" multiple="true" />
    <form:errors path="parents"/><br>

    Description: <br><form:textarea path="childDescription" rows="10" cols="40"/>
    <form:errors path="childDescription"/><br>

    User:<form:select path="user" itemLabel="login" itemValue="id" items="${user}"/>
    <form:errors path="user"/><br>

    <input type="submit"> <br>
    <br>
</form:form>

<a href="/child/all"> <<--- Back to Childs List </a>
<br>
<a href="/"> <<<--- Back to HomePage </a><br>
<br>
<br>
<p class="footer"><spring:message code="app.footer"/></p>
</body>
</html>
