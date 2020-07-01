<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Teams List</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>

<h1><spring:message code="app.title"/></h1> <br>
<h2>Teams List:</h2>
<table>
    <tbody>
    <tr>
        <th>ID</th>
        <th>TEAM NAME</th>
        <th>TEAM INSTRUCTOR</th>
        <th>CHILDS</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${teams}" var="team">
        <tr>
            <td><c:out value="${team.id}"/></td>
            <td><c:out value="${team.teamName}"/></td>
            <td><c:out value="${team.instructor}"/></td>




            <td><a href="/team/editTeamForm/${team.id}">Update</a></td>
            <td><a href="/team/delete/${team.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<br>
<a href="/team/addTeamForm/"> +++ Add new Team +++ </a> <br>
<br>
<a href="/"> <<<--- Back to HomePage </a><br>

<br>
<br>
<p class="footer"><spring:message code="app.footer"/></p>



</body>
</html>
