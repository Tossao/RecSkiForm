<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style type="text/css">
        table, table * {
            border: 1px solid black
        }
    </style>
</head>
<body>
<h2>Users List:</h2>
<table>
    <tbody>
    <tr>
        <th>ID</th>
        <th>LOGIN</th>
        <th>PASSWORD</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.password}"/></td>
<%--            <td><a href="/author/editAuthorForm/${author.id}">Update</a></td>--%>
<%--            <td><a href="/author/delete/${author.id}">Delete</a></td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/"> <<<--- Back to HomePage </a><br>
</body>
</html>
