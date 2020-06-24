<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 20.06.2020
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Skill</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h1><spring:message code="app.title"/></h1> <br>
    <h2>Add Skill</h2>
    <form:form method="POST" modelAttribute="skill">
        Skill Name: <form:input path="skillName" value="Enter Skill Name" onfocus="this.value=''"/>
        <form:errors path="skillName"/><br>

        Skill Description: <br><form:textarea path="skillDescription" rows="10" cols="40"/>
        <form:errors path="skillDescription"/><br>

        <input type="submit"> <br>
        <br>
    </form:form>
    <a href="/skill/all"> <<--- Back to Skills List </a>
    <br>
    <a href="/"> <<<--- Back to HomePage </a><br>
    <br>
    <br>
    <h5><spring:message code="app.footer"/></h5>
</body>
</html>
