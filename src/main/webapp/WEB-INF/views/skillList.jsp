<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 20.06.2020
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Skill List</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h1><spring:message code="app.title"/></h1> <br>
    <h2>Skills List:</h2>
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <th>SKILL NAME</th>
            <th>DESCRIPTION</th>
            <th>EDIT</th>
            <th>DELETE</th>
        </tr>
        <c:forEach items="${skills}" var="skill">
            <tr>
                <td><c:out value="${skill.id}"/></td>
                <td><c:out value="${skill.skillName}"/></td>
                <td><c:out value="${skill.skillDescription}"/></td>
                <td><a href="/skill/editSkillForm/${skill.id}">Update</a></td>
                <td><a href="/skill/delete/${skill.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <br>
    <a href="/skill/addSkillForm/"> +++ Add new Skill +++ </a> <br>
    <br>
    <a href="/"> <<<--- Back to HomePage </a><br>

    <br>
    <br>
    <p class="footer"><spring:message code="app.footer"/></p>
</body>
</html>
