<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Sign in</title>
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
        <div>
            <%@include file="/WEB-INF/components/sign-up-form.jsp" %>
            <p class="link-container">
                <a href='<c:url value="/"/>'>Back to registration</a>
            </p>
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
