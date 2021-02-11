<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <title>captcha</title>
    <link rel="stylesheet" href='<c:url value="/styles/style.css"/>' type="text/css">
</head>
<body>
    <div class="wrapper">
        <div class="container">
            <h2>result:</h2>
            <div>
                <img src="${pageContext.request.contextPath}/captcha-servlet" alt="placeholder">
                <c:if test="${empty sessionScope.get('captcha')}">
                    <h2> previous answer: -</h2>
                </c:if>
                <c:if test="${not empty sessionScope.get('captcha')}">
                    <h2> previous answer: ${sessionScope.get('captcha')}</h2>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
