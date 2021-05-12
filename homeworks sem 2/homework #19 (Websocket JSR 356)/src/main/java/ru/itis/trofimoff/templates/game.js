const HOST = "ws://localhost:8099/game";

let gameStatus = "ok";

let field = [
    [false, false, false],
    [false, false, false],
    [false, false, false]
];

let websocket;

let items = document.querySelectorAll(".item");

let gameOverMessage = document.getElementById("message");

items.forEach(item => {
   item.addEventListener("click", check.bind(item));
});

window.onload = connect;

function connect() {
    webSocket = new WebSocket(HOST);
    webSocket.onmessage = receiveMessage;
}

function receiveMessage(response) {
    console.log(response);
    let json = JSON.parse(response.data);
    if (json.gameStatus === "gameOver") {
        gameStatus = json.gameStatus;
        gameOverMessage.style.opacity = "1";
        return;
    }
    let targetItem = document.getElementById(convertToId(json));
    changeInnerServer.call(targetItem);
    field[json.x][json.y] = true;
}

function changeInnerPlayer() {
    this.innerText = "O";
}

function changeInnerServer() {
    this.innerText = "X";
}

function sendRequest(data) {
    webSocket.send(JSON.stringify(data));
}

function check() {
    let coordinates = parseId(this.getAttribute("id"));
    if (!field[coordinates.y][coordinates.x] && gameStatus !== "gameOver") {
        changeInnerPlayer.call(this);
        field[coordinates.y][coordinates.x] = true;
        sendRequest(coordinates);
    }
}

function parseId(id) {
    return {
        y: id.charAt(0),
        x: id.charAt(1)
    }
}

function convertToId(response) {
    return "" + response.x + response.y
}