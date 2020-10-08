<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href='<c:url value="/style/style.css"/>' type="text/css">
</head>
<body>
    <div>
        <%@include file="/WEB-INF/components/registration-form.jsp" %>
        <c:if test="${not empty sessionScope.get('name')}">
            <p style="text-align: center">
                <a href="<c:url value="/profile"/>">Profile</a>
            </p>
        </c:if>
    </div>
</body>
</html>
