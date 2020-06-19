<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 29.05.2020
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>RECSKI.pl FORM</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<h1><spring:message code="app.title"/></h1> <br>
<a href="/user/addUserForm/"> +++ Add new User +++ </a> <br>
<a href="/user/all"> Go to Users List --->> </a> <br>
<br>
<a href="/parent/addParentForm/"> +++ Add new Parent +++ </a> <br>
<a href="/parent/all"> Go to Parents List --- >> </a><br>

<br>
<br>
<h5><spring:message code="app.footer"/></h5>

</body>
</html>
