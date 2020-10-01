<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Message</title>
    <%--    main.jsp не видит стили--%>
    <%--    <link rel="stylesheet" href='<c:url value="../style/style.css"/>' type="text/css">--%>
</head>
<body class="sign-up-page">
<style>
    <%@include file="/WEB-INF/style/style.css" %>
</style>
    <div>
        <h1>${requestScope.get('inputStatus')}</h1>
<%--        <a href="/">Go back to registration</a>--%>
    </div>
</body>
</html>
