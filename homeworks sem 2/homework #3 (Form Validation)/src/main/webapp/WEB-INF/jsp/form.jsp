<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>form</title>
</head>
<body>
    <form action="${s:mvcUrl('FC#formPostRequest').build()}" method="post">
        <input type="text" placeholder="name">
        <input type="text" placeholder="soname">
        <input type="submit" value="Submit">
    </form>
    <div>
        ${formData}
    </div>
</body>
</html>
