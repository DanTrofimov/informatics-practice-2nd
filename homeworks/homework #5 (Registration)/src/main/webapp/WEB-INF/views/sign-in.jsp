<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" href='<c:url value="/style/style.css"/>' type="text/css">
</head>
<body>
    <div>
        <%@include file="/WEB-INF/components/sign-up-form.jsp" %>
        <p class="link-container">
            <a href='<c:url value="/"/>'>Back to registration</a>
        </p>
    </div>
</body>
</html>
