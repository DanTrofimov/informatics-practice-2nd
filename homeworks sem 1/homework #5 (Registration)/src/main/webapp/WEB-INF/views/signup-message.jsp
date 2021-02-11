<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Message</title>
    <link rel="stylesheet" href='<c:url value="/style/style.css"/>' type="text/css">
</head>
<body class="sign-up-page">
    <t:header>
        <jsp:attribute name="content">
            <p>
                lorem ipsum dolor sit amet
            </p>
        </jsp:attribute>
    </t:header>
    <div class="page-content">
        <div class="message">
            <h1>${requestScope.get('inputStatus')}</h1>
            <a href='<c:url value="/"/>'>Back to registration</a>
        </div>
    </div>
    <t:footer>
        <jsp:attribute name="content">
            <p>
                consectetur adipisicing elit
            </p>
        </jsp:attribute>
    </t:footer>
</body>
</html>
