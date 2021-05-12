const HOST = "ws://localhost:8099/game";

let gameStatus = "ok";

let field = [
    [0, 0, 0],
    [0, 0, 0],
    [0, 0, 0],
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
    if (json.gameStatus !== "ok") {
        gameStatus = json.gameStatus;

        switch (gameStatus) {
            case "clientWin":
                gameOverMessage.innerText = "YOU WIN";
                break;
            case "serverWin":
                gameOverMessage.innerText = "COMPUTER WIN";
                break;
            default:
                gameOverMessage.innerText = "DRAW";
        }

        gameOverMessage.style.opacity = "1";
    }
    let targetItem = document.getElementById(convertToId(json));
    changeInnerServer.call(targetItem);
    field[json.x][json.y] = -1; // server
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
    if (field[coordinates.y][coordinates.x] === 0 && gameStatus === "ok") {
        changeInnerPlayer.call(this);
        field[coordinates.y][coordinates.x] = 1; // client
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

// logs
setInterval(() => {
    if (gameStatus === "ok") console.log(field)
}, 5000);