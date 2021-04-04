<#import "spring.ftl" as spring/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>lazy</title>
</head>
<body style="height: 90vh; width: 95vw; display: grid; place-items: center">
<form action="books-add" method="POST">
    <input type="text" placeholder="book-name" name="name">
    <select name="category">
        <option disabled>book-category</option>
        <#if categories??>
                <#list categories as category>
                    <option value="${ category.getId() }">${ category.getName() }</option>
                </#list>
        </#if>
    </select>
    <input type="submit" value="save">
</form>
<a href="<@spring.url "/books"/>">books</a>
</body>
</html>