<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 20.06.2020
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Level List</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h1><spring:message code="app.title"/></h1> <br>
    <h2>Levels List:</h2>
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <th>COLOR</th>
            <th>DESCRIPTION</th>
            <th>EDIT</th>
            <th>DELETE</th>
        </tr>
        <c:forEach items="${levels}" var="level">
            <tr>
                <td><c:out value="${level.id}"/></td>
                <td><c:out value="${level.levelColor}"/></td>
                <td><c:out value="${level.levelDescription}"/></td>
                <td><a href="/level/editLevelForm/${level.id}">Update</a></td>
                <td><a href="/level/delete/${level.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <br>
    <a href="/level/addLevelForm/"> +++ Add new Level +++ </a> <br>
    <br>
    <a href="/"> <<<--- Back to HomePage </a><br>

    <br>
    <br>
    <h5><spring:message code="app.footer"/></h5>



</body>
</html>
