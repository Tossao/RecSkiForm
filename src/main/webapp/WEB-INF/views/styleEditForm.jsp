<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 22.06.2020
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Style</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h1><spring:message code="app.title"/></h1> <br>
    <h2>Edit Style</h2>
    <form:form method="POST" modelAttribute="style">
        Style Name: <form:input path="styleName"/>
        <form:errors path="styleName"/><br>

        Style Description: <br><form:textarea path="styleDescription" rows="10" cols="40"/>
        <form:errors path="styleDescription"/><br>

        <input type="submit"> <br>
        <br>

    </form:form>
    <a href="/style/all"> <<--- Back to Style List </a>
    <br>
    <a href="/"> <<<--- Back to HomePage </a><br>
    <br>
    <br>
    <p class="footer"><spring:message code="app.footer"/></p>
</body>
</html>
