<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href='<c:url value="/style/style.css"/>' type="text/css">
</head>
<body>
    <t:header>
            <jsp:attribute name="content">
                <p>
                    lorem ipsum dolor sit amet
                </p>
            </jsp:attribute>
    </t:header>
    <div class="page-content">
        <div class="message">
            <h2>Hello, ${sessionScope.get('name')}</h2>
            <h2>Your email: ${sessionScope.get('email')}</h2>
            <a href='<c:url value="/"/>'>Back to registration</a>
            <c:if test="${not empty sessionScope.get('email')}">
                <a href="<c:url value="/sign-out"/>">Sign Out</a>
            </c:if>
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
