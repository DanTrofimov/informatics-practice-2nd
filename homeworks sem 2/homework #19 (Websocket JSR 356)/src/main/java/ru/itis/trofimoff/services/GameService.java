package ru.itis.trofimoff.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.trofimoff.model.Message;

public class GameService {
    // replace by 0 & 1 & 2
    private static final boolean[][] field = {
            { false, false, false },
            { false, false, false },
            { false, false, false }
    };

    private ObjectMapper objectMapper = new ObjectMapper();

    public Message handleRequest(String request) {
        try {
            JsonNode actualObj = objectMapper.readTree(request);
            Message message = new Message(actualObj.get("x").asInt(), actualObj.get("y").asInt(), "ok");
            System.out.println(message);

            field[message.getY()][message.getX()] = true;

            int[] coordinates = generateCoordinates();
            Message response;

            if (coordinates[0] == -1) {
                response = new Message(coordinates[0], coordinates[1], "gameOver");
            } else {
                response = new Message(coordinates[0], coordinates[1], "ok");
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
            return response;
        } catch (JsonProcessingException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
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
