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
    <title>Parents List</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<h1><spring:message code="app.title"/></h1> <br>
<h2>Parent List:</h2>
<table>
    <tbody>
    <tr>
        <th>ID</th>
        <th>LAST NAME</th>
        <th>FIRST NAME</th>
        <th>PHONE NUMBER</th>
        <th>E-MAIL</th>
        <th>LOGIN</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>

    <c:forEach items="${parents}" var="parent">
        <tr>
            <td><c:out value="${parent.id}"/></td>
            <td><c:out value="${parent.lastName}"/></td>
            <td><c:out value="${parent.firstName}"/></td>
            <td><c:out value="${parent.phone}"/></td>
            <td><c:out value="${parent.email}"/></td>
            <td><c:out value="${parent.user.login}"/></td>
            <td><a href="/parent/editParentForm/${parent.id}">Update</a></td>
            <td><a href="/parent/delete/${parent.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<br>
<a href="/parent/addParentForm/"> +++ Add new Parent +++ </a> <br>
<br>
<a href="/"> <<<--- Back to HomePage </a><br>
<br>
<br>
<h5><spring:message code="app.footer"/></h5>
</body>
</html>
