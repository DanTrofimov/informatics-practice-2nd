<#import "tags/header.ftl" as m />
<#import "spring.ftl" as spring/>

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
    <@m.htmlHeader title="HEADER" description="hello im description"/>
    <@spring.bind "formExample"></@spring.bind>
    <form action="<@spring.url'/form'/>" method="post" style="display: flex; flex-direction: column; gap: 10px; width: 200px">
        <input type="email" placeholder="name" name="email">
        <input type="number" placeholder="age" name="age">
        <input type="submit" value="Submit">
    </form>
    <div>
        <#if user??>
            ${user.name}
            ${user.age}
        <#else>
            <p>user is null</p>
        </#if>
        <#if exampleList??>
            <#list exampleList as example>
                ${example}
            <#else>
                <p>empty</p>
            </#list>
        </#if>
    </div>
</body>
</html>