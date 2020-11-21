package ru.itis.trofimoff.sockets.simple;

import ru.itis.trofimoff.sockets.Protocol;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Throwable {

        System.out.println("Starting server...");
        ServerSocket server = new ServerSocket(Protocol.PORT);
        System.out.println("Starting to listen port " + Protocol.PORT);
        Socket s = server.accept();
        System.out.println("Got one connection.");
        InputStream in = s.getInputStream();
        int b;
        while((b = in.read()) != -1){
            System.out.println("<< " + b);
        }
    }
}