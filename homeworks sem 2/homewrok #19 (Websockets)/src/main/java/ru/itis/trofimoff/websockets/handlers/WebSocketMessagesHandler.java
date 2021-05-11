package ru.itis.trofimoff.websockets.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.itis.trofimoff.websockets.dto.Message;

@Component
public class WebSocketMessagesHandler extends TextWebSocketHandler {

    // replace by 0 & 1 & 2
    private static final boolean[][] field = {
            { false, false, false },
            { false, false, false },
            { false, false, false }
    };

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage jsonMessage) throws Exception {
        Message message = objectMapper.readValue(jsonMessage.getPayload(), Message.class);

        field[message.getY()][message.getX()] = true;

        int[] coordinates = generateCoordinates();
        Message response;

        if (coordinates[0] == -1) {
            response = new Message(coordinates[0], coordinates[1], "gameOver");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));
            session.close();
        } else {
            response = new Message(coordinates[0], coordinates[1], "ok");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

        System.out.println(session.isOpen());
    }

    public int[] generateCoordinates() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!field[i][j]) {
                    field[i][j] = true;
                    return new int[]{ i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
