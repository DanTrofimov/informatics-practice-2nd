package ru.itis.trofimoff.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.trofimoff.exceptions.IncorrectResponseException;
import ru.itis.trofimoff.model.Message;

public class GameService {
    // replace by 0 & 1 & 2
    // 1 - client
    // 2 - server
    private static final int[][] field = {
            { 0, 0, 0 },
            { 0, 0, 0 },
            { 0, 0, 0 },
    };

    private ObjectMapper objectMapper = new ObjectMapper();

    public Message handleRequest(String request) {
        try {
            JsonNode actualObj = objectMapper.readTree(request);
            Message message = new Message(actualObj.get("x").asInt(), actualObj.get("y").asInt(), "ok");
            System.out.println(message);

            field[message.getY()][message.getX()] = 1; // client

            int[] coordinates = generateCoordinates();
            Message response;

            response = new Message(coordinates[0], coordinates[1], gameStatusChecker());

            // field logs
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }

            return response;
        } catch (JsonProcessingException ex) {
            throw new IncorrectResponseException("Can't convert correctly response");
        }
    }

    public int[] generateCoordinates() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 0) {
                    field[i][j] = -1; // server
                    return new int[]{ i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    public String gameStatusChecker() {
        // rows check
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum+=field[i][j];
            }
            switch (sum) {
                case 3:
                    return "clientWin";
                case -3:
                    return "serverWin";
            }
        }
        // columns check
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum+=field[j][i];
            }
            switch (sum) {
                case 3:
                    return "clientWin";
                case -3:
                    return "serverWin";
            }
        }
        // diagonals check
        int sum = field[0][0] + field[1][1] + field[2][2];
        switch (sum) {
            case 3:
                return "clientWin";
            case -3:
                return "serverWin";
        };

        sum = field[0][2] + field[1][1] + field[2][0];
        switch (sum) {
            case 3:
                return "clientWin";
            case -3:
                return "serverWin";
        }
        return "ok";
    }
}
