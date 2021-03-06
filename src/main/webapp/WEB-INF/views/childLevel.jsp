<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 29.06.2020
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Childs By Level</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<h1><spring:message code="app.title"/></h1> <br>
<h2>Childs List:</h2>
<table>
    <tbody>
    <tr>
        <th>RECSKI LEVEL</th>
        <th>LAST NAME</th>
        <th>FIRST NAME</th>
        <th>BIRTH DATE</th>
        <th>SKI / SNOWBOARD</th>
        <th>SKILLS</th>
        <th>PARENTS</th>
        <th>PARENT DESCRIPTION</th>
        <th>USER</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>

    <c:forEach items="${childLevel}" var="child">
        <tr>
            <td><c:out value="${child.level.levelColor}"/></td>
            <td><c:out value="${child.lastName}"/></td>
            <td><c:out value="${child.firstName}"/></td>

            <td><fmt:formatDate value="${child.birthDate}" pattern="yyyy-MM-dd"/></td>

            <td><c:out value="${child.style.styleName}"/></td>

            <td><c:forEach items="${child.skills}" var="skills">
                <c:out value="${skills.skillName}"/></c:forEach></td>

            <td><c:forEach items="${child.parents}" var="parents">
                <c:out value="${parents.firstName}"/></c:forEach></td>

            <td><c:out value="${child.childDescription}"/></td>

            <td><c:out value="${child.user.login}"/></td>

            <td><a href="/child/editChildForm/${child.id}">Update</a></td>
            <td><a href="/child/delete/${child.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>

    <br>
    <br>
    <a href="/"> <<<--- Back to HomePage </a><br>
    <br>
    <a href="/child/all"> To All Child List --->>> </a>

</table>
<p class="footer"><spring:message code="app.footer"/></p>
</body>
</html>
