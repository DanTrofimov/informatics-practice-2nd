package ru.itis.trofimoff.sockets.colors;

import ru.itis.trofimoff.sockets.Protocol;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Starting client...");
        try (Socket s = new Socket(InetAddress.getLocalHost(), Protocol.PORT);
            OutputStream out = s.getOutputStream()) {

            System.out.println("Enter the color:");
            Scanner scanner = new Scanner(System.in);

            while (true){
                System.out.println("Enter the color parts");
                int red = scanner.nextInt();
                int green = scanner.nextInt();
                int blue = scanner.nextInt();
                Color color = new Color(red, green, blue);
                ByteBuffer buf = ByteBuffer.allocate(12);
                buf.putInt(red).putInt(green).putInt(blue);
                System.out.println(">> " + color);
                out.write(buf.array());
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("Connection problems");
        }
    }
}