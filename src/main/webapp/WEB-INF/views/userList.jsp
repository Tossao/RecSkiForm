<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 01.06.2020
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h1><spring:message code="app.title"/></h1> <br>
    <h2>Users List:</h2>
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <th>LOGIN</th>
            <th>PASSWORD</th>
            <th>EDIT</th>
            <th>DELETE</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><a href="/user/editUserForm/${user.id}">Update</a></td>
                <td><a href="/user/delete/${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <br>
    <a href="/user/addUserForm/"> +++ Add new User +++ </a> <br>
    <br>
    <a href="/"> <<<--- Back to HomePage </a><br>

    <br>
    <br>
    <p class="footer"><spring:message code="app.footer"/></p>
</body>
</html>
