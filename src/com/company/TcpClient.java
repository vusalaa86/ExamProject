package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import static com.company.Util.*;

public class TcpClient {
    public static void main(String[] args) throws Exception {

        String nameandsurname = requireString("Please enter your name and surname:");

        String path = requireString("Please indicate the file path of the picture you would like to send:");

        String ipandport = requireString("Please indicate the ip and port ofthe client you would like to add picture:");

        String[] arr = ipandport.split(":");
        String ip = arr[0];
        Integer port = Integer.parseInt(arr[1]);
            Socket socket = new Socket(ip, port);
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);//127.0.0.1:55598

            byte[] bytes = Files.readAllBytes(Paths.get(path));
            dataOutputStream.writeInt(bytes.length);
            dataOutputStream.write(bytes);
            System.out.println("has been send succesfully");

        }
    }

