<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css">
    <title>Чат</title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    <script>
    </script>
</head>
<body onload="connect()">
<script src="script/script.js"></script>
<div class="content">
    <div class="message-form">
        <label for="message">ur message is: </label>
        <input name="message" id="message" placeholder="type here...">
        <button onclick="sendMessage($('#message').val(), '${pageId}')">send</button>
    </div>
    <h3>Messages:</h3>
    <ul id="messagesList">
    </ul>
</div>
</body>
</html>
