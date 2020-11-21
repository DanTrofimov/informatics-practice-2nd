package ru.itis.trofimoff.sockets.resourse;

import ru.itis.trofimoff.sockets.Protocol;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) throws Throwable {
        short port = Protocol.PORT;
        String resourse = "http://www.youtube.com/";
        URL url = new URL(resourse);

        try (Socket socket = new Socket(url.getHost(), port);
            OutputStream output = socket.getOutputStream();

            InputStream input = socket.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader buffer = new BufferedReader(inputReader)) {

            PrintWriter pw = new PrintWriter(output, false);
            pw.print("GET " + url.getPath() + " HTTP/1.0\n");
            pw.print("Accept: text/plain, text/html, text/*\n");
            pw.print("\n");
            pw.flush();

            String response = buffer.lines().collect(Collectors.joining("\n"));
            if (response.startsWith("HTTP/1.0 200 OK")) {
                System.out.println(response);
            } else {
                System.out.println("Not OK");
            }
        }
         catch (IOException ex) {
            System.err.println(ex);
        }
    }
}