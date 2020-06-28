<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 29.05.2020
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>RECSKI.pl FORM</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<h1><spring:message code="app.title"/></h1> <br>
<br>
<br>


<a href="/user/addUserForm/"> +++ Add new User +++ </a> <br>
<a href="/user/all"> Go to Users List --->> </a> <br>
<br>


<a href="/parent/addParentForm/"> +++ Add new Parent +++ </a> <br>
<a href="/parent/all"> Go to Parents List --- >> </a><br>
<br>


<a href="/child/addChildForm/"> +++ Add new Child +++ </a> <br>
<a href="/child/all"> Go to Childs List --- >> </a><br>
<br>


<a href="/style/addStyleForm/"> +++ Add new Style +++ </a> <br>
<a href="/style/all"> Go to Styles List --- >> </a><br>
<br>


<a href="/skill/addSkillForm/"> +++ Add new Skill +++ </a> <br>
<a href="/skill/all"> Go to Skills List --- >> </a><br>
<br>


<a href="/level/addLevelForm/"> +++ Add new Level +++ </a> <br>
<a href="/level/all"> Go to Levels List --- >> </a><br>
<br>

<h3> Last 5 added childs:</h3>
<table>
    <tbody>
    <tr>
        <th>Last Name</th>
        <th>First Name</th>
        <th>Birth Date</th>
        <th>Ski / Snowboard</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${childIndexList}" var="child">
        <tr>
            <td><c:out value="${child.lastName}"/></td>
            <td><c:out value="${child.firstName}"/></td>
            <td><fmt:formatDate value="${child.birthDate}" pattern="yyyy-MM-dd"/></td>
            <td><c:out value="${child.style.styleName}"/></td>
            <td><a href="/child/editChildForm/${child.id}">Update</a></td>
            <td><a href="/child/delete/${child.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<br>





<br>
<br>
<h5><spring:message code="app.footer"/></h5>

</body>
</html>
