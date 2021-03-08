<#import "spring.ftl" as spring/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>cms</title>
    <script src="https://cdn.tiny.cloud/1/gl0bny55tldoes0nttuipeuzgbabpvs96roe6wcrbyr2mb7d/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
    <link rel="stylesheet" href="<@spring.url '/styles/edit.css' />" type="text/css">
</head>
<body>
    <div class="admin-header">
        <h2 class="title"><@spring.message "admin.title"/></h2>
        <div class="langs">
            <a href="?lang=en">EN</a>
            <a href="?lang=ru">RU</a>
        </div>
    </div>
    <form method="post" action="admin">
        <div class="nameInput">
            <label for="name"><@spring.message "admin.name.label"/></label>
            <input type="text" placeholder="Name of template" name="name" id="name">
        </div>
        <div class="nameInput">
            <label for="parent"><@spring.message "admin.parent.label"/></label>
            <input type="text" placeholder="Name of parent" name="parent" id="parent">
        </div>
        <textarea name="content">
            <@spring.message "admin.textarea.placeholder"/>
        </textarea>
        <div class="navigation">
            <input type="submit" value="<@spring.message "admin.button.save"/>">
            <a href="user"><@spring.message "admin.button.cancel"/></a>
        </div>
    </form>
    <script src="<@spring.url '/scripts/init.js' />"></script>
</body>
</html>