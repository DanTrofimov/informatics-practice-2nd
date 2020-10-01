<%--
  Created by IntelliJ IDEA.
  User: Honor
  Date: 02.10.2020
  Time: 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<style>
    <%@include file="/WEB-INF/style/style.css" %>
</style>
    <h1>Hello, ${requestScope.get('name')}</h1>
</body>
</html>
