const HOST = "ws://localhost:8080/chat";

let gameStatus = "ok";

let field = [
    [false, false, false],
    [false, false, false],
    [false, false, false]
];

let websocket;

let items = document.querySelectorAll(".item");

items.forEach(item => {
   item.addEventListener("click", check.bind(item));
});

window.onload = connect;

function connect() {
    webSocket = new WebSocket(HOST);
    webSocket.onmessage = receiveMessage;
}

function receiveMessage(response) {
    let json = JSON.parse(response.data);
    if (json.gameStatus === "gameOver") {
        gameStatus = json.gameStatus;
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