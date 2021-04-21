<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>categories:</h1>
    <#if categories??>
        <#list categories as category>
            <table border="1">
                <tr>
                    <td>${category.getName()}</td>
                    <td>items</td>
                </tr>
            </table>
        </#list>
    <#else>
        <p>no categories found</p>
    </#if>
</body>
</html>