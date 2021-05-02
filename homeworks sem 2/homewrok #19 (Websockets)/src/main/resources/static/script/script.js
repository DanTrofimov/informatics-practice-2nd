const HOST = "ws://localhost:8080/chat";

let webSocket;

function connect() {
    webSocket = new WebSocket(HOST);

    // handshake cookie
    document.cookie = 'AUTH=' + '1234' + ';path=/';

    webSocket.onmessage = function receiveMessage(response) {
        let json = JSON.parse(response['data']);
        $('#messagesList').first().append("<li class='message'>" + json['from'] + ': ' + json['text'] + "</li>")
    }
}

function sendMessage(text, pageId) {

    let message = {
        "text" : text,
        "from": pageId
    };

    $("#message").val("");

    webSocket.send(JSON.stringify(message));
}