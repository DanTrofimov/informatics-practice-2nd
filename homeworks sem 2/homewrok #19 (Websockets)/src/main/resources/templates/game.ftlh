<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Game</title>
</head>
<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }

    :root {
        --main-bg-color: #0a141e;
        --main-text-color: #e8e8e8;
        --hover: #162c42;
    }

    body {
        height: 100vh;
        background-color: var(--main-bg-color);
        color: var(--main-text-color);
        display: grid;
        place-items: center;
        font-family: Consolas, sans-serif;
        transition: all 0.5s;
    }

    .content {
        width: 450px;
        height: 445px;
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        flex-wrap: wrap;
    }

    .item {
        height: 148px;
        width: 148px;
        border: 1px solid var(--main-text-color);
        cursor: pointer;
        display: grid;
        place-items: center;
        font-size: 70px;
    }

    .item:hover {
        background-color: var(--hover);
        transition: all 0.2s;
    }
</style>
<body>
    <div class="content">
        <div id="00" class="item" style="border-radius: 20px 0 0 0"> </div> <div id="01" class="item"></div> <div id="02" class="item" style="border-radius: 0 20px 0 0"></div>
        <div id="10" class="item"> </div> <div id="11" class="item"></div> <div id="12" class="item"></div>
        <div id="20" class="item" style="border-radius: 0 0 0 20px"> </div> <div id="21" class="item"></div> <div id="22" class="item" style="border-radius: 0 0 20px 0"></div>
    </div>
</body>
<script src="script/game.js"></script>
</html>