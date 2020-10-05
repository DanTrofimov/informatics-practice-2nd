<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Profile</title>
<%--    <link rel="stylesheet" href='<c:url value="/style/style.css"/>' type="text/css">--%>
</head>
<body>
<style>
    <%@include file="/style/style.css" %>
</style>
<div class="message">
    <h1>Hello, ${sessionScope.get('name')}</h1>
    <a href="/">Back to registration</a>
</div>
</body>
</html>
