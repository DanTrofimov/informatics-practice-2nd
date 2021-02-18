<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>form</title>
    <meta charset="UTF-8">
</head>
<body>
    <form action="${s:mvcUrl('FC#formPostRequest').build()}" method="post" style="display: flex; flex-direction: column; gap: 10px; width: 200px">
        <input type="text" placeholder="name" name="name">
        <input type="number" placeholder="age" name="age">
        <input type="submit" value="Submit">
    </form>
    <div>
        ${userName}
        ${userAge}
    </div>
    <div>
        ${error}
    </div>
</body>
</html>
