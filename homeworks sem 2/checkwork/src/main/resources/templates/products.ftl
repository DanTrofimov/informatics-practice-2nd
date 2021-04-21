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
    <h1>products:</h1>
    <#if products??>
        <#list products as product>
            <table border="1">
                <tr>
                    <td>${product.getName()}</td>
                    <td>${product.getPrice()}</td>
                    <td><button>remove</button></td>
                </tr>
            </table>
        </#list>
    <#else>
        <p>no products found</p>
    </#if>
</body>
</html>