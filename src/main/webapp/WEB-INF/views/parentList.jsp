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
    <title>Parents List</title>
    <style type="text/css">
        table, table * {
            border: 1px solid black
        }
    </style>
</head>
<body>
<h2>Parent List:</h2>
<table>
    <tbody>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone Number</th>
        <th>e-mail</th>
    </tr>

    <c:forEach items="${parents}" var="parent">
        <tr>
            <td><c:out value="${parent.firstName}"/></td>
            <td><c:out value="${parent.lastName}"/></td>
            <td><c:out value="${parent.phone}"/></td>
            <td><c:out value="${parent.email}"/></td>

<%--            <td><a href="/author/editAuthorForm/${author.id}">Update</a></td>--%>
<%--            <td><a href="/author/delete/${author.id}">Delete</a></td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/"> <<<--- Back to HomePage </a><br>
</body>
</html>
