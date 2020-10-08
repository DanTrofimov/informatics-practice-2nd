<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href='<c:url value="/style/style.css"/>' type="text/css">
</head>
<body>
    <div class="message">
        <h2>Hello, ${sessionScope.get('name')}</h2>
        <h2>Your email: ${sessionScope.get('email')}</h2>
        <a href='<c:url value="/"/>'>Back to registration</a>
    </div>
</body>
</html>
