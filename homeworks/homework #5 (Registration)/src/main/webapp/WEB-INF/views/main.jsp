<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>

<html>
<head>
    <title>Registration</title>
<%--    main.jsp не видит стили--%>
<%--    <link rel="stylesheet" href='<c:url value="../style/style.css"/>' type="text/css">--%>
</head>
<style>
    <%@include file="/WEB-INF/style/style.css" %>
</style>
<body>
    <%@include file="/WEB-INF/components/registration-form.jsp" %>
</body>
</html>
