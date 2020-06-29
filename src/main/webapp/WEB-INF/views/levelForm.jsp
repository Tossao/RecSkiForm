<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 20.06.2020
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Level</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h1><spring:message code="app.title"/></h1> <br>
    <h2>Add Level</h2>

    <form:form method="POST" modelAttribute="level">
        Level Color: <form:input path="levelColor" value="Enter Level Color" onfocus="this.value=''"/>
        <form:errors path="levelColor"/><br>

        Level Description: <br><form:textarea path="levelDescription" rows="10" cols="40"/>
        <form:errors path="levelDescription"/><br>

        <input type="submit"> <br>
        <br>
    </form:form>
    <a href="/level/all"> <<--- Back to Levels List </a>
    <br>
    <a href="/"> <<<--- Back to HomePage </a><br>
    <br>
    <br>
    <p class="footer"><spring:message code="app.footer"/></p>
</body>
</html>
