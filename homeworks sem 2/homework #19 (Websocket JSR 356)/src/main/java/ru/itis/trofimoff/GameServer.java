package ru.itis.trofimoff;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.tyrus.server.Server;
import ru.itis.trofimoff.exceptions.CantStartServerException;
import ru.itis.trofimoff.exceptions.IncorrectResponseException;
import ru.itis.trofimoff.model.Message;
import ru.itis.trofimoff.services.GameService;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Scanner;

@ServerEndpoint(value = "/game")
public class GameServer {

    public ObjectMapper objectMapper;
    public GameService gameService;
    public final int PORT = 8099;
    public final String HOST = "localhost";

    public static void main(String[] args) {
        GameServer server = new GameServer();
    }

    public GameServer() {
        Server server = new Server(HOST, PORT, "", null, this.getClass());
        objectMapper = new ObjectMapper();
        gameService = new GameService();

        try {
            server.start();
            new Scanner(System.in).nextLine();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            server.stop();
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("A Client " + session.getId() + " disconnected with reason " + closeReason.getReasonPhrase() + ", code " + closeReason.getCloseCode().getCode() + ".");
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println("Got new connection: " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("An error occured: " + session.getId() + " - " + throwable.getMessage());
    }

    @OnMessage
    public String onMessage(String request, Session session) {
        System.out.println("Got message from " + session.getId() + ": " + request);

        Message message = gameService.handleRequest(request);

        String response = "";

        try {
            response = objectMapper.writeValueAsString(message);
            System.out.println(response);
        } catch (JsonProcessingException ex) {
            throw new IncorrectResponseException("Can't correctly convert response");
        }

        return response;
    }
}