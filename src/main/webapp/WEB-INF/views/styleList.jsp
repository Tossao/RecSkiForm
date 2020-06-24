<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 22.06.2020
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Style List</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h1><spring:message code="app.title"/></h1> <br>
    <h2>Style List:</h2>
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <th>STYLE</th>
            <th>DESCRIPTION</th>
            <th>EDIT</th>
            <th>DELETE</th>
        </tr>
        <c:forEach items="${styles}" var="style">
            <tr>
                <td><c:out value="${style.id}"/></td>
                <td><c:out value="${style.styleName}"/></td>
                <td><c:out value="${style.styleDescription}"/></td>
                <td><a href="/style/editStyleForm/${style.id}">Update</a></td>
                <td><a href="/style/delete/${style.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <br>
    <a href="/style/addStyleForm/"> +++ Add new Style +++ </a> <br>
    <br>
    <a href="/"> <<<--- Back to HomePage </a><br>

    <br>
    <br>
    <h5><spring:message code="app.footer"/></h5>



</body>
</html>
