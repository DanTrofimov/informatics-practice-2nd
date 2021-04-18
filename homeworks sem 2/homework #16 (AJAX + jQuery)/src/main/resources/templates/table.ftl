<#import "spring.ftl" as spring/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>table</title>
    <style>
        body {
            width: auto;
            height: auto;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }

        #users-table {
            transition: all 0.5s;
        }
    </style>
    <script src="https://yastatic.net/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
        <table border="1" id="users-table">
        </table>
    <script src="<@spring.url "/scripts/script.js"/>"></script>
</body>
</html>