<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 01.07.2020
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Team</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>

<h1><spring:message code="app.title"/></h1> <br>
<h2>Add Team</h2>

<form:form method="POST" modelAttribute="team">
    Team Name: <form:input path="teamName" value="Enter Team Name" onfocus="this.value=''"/>
    <form:errors path="teamName"/><br>

    Team Instructor: <form:input path="instructor" value="Enter Instructor Name" onfocus="this.value=''"/>
    <form:errors path="instructor"/><br>

    <input type="submit"> <br>
    <br>
</form:form>
<a href="/team/all"> <<--- Back to Teams List </a>
<br>
<a href="/"> <<<--- Back to HomePage </a><br>
<br>
<br>
<p class="footer"><spring:message code="app.footer"/></p>

</body>
</html>
