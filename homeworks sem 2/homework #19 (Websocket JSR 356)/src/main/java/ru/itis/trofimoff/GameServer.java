package ru.itis.trofimoff;

import java.io.IOException;
import java.util.Scanner;
import javax.websocket.EndpointConfig;
import javax.websocket.*;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.glassfish.tyrus.server.Server;

@ServerEndpoint(value = "/chat")
public class GameServer {

    public static void main(String[] args) {
        GameServer server = new GameServer();
    }

    public GameServer() {
        Server server = new Server("localhost", 8080, "", null, this.getClass());

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
        try {
            session.getBasicRemote().sendText("Hi! You session id is " + session.getId() + ", protocol version is " + session.getProtocolVersion() + ".");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("An error occured: " + session.getId() + " - " + throwable.getMessage());
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        System.out.println("Got message from " + session.getId() + ": " + message);
        return "Did tou say \""+message + "\" ?";
    }
}