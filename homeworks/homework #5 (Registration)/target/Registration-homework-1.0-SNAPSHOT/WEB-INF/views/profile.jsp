<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<style>
    <%@include file="/WEB-INF/style/style.css" %>
</style>
<div class="message">
    <h1>Hello, ${sessionScope.get('name')}</h1>
    <a href="/">Back to registration</a>
</div>
</body>
</html>
