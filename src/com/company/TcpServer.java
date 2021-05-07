package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ourFirstServerSocket = new ServerSocket(58118);
        while (true) {
            Socket connection = ourFirstServerSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(connection.getInputStream());
            int msgln = dataInputStream.readInt();
            byte[] arr = new byte[msgln];
            dataInputStream.readFully(arr);
            Files.write(Paths.get("C:\\Users\\User\\Pictures\\examproject\\picture.PNG"), arr);
        }
    }
}
