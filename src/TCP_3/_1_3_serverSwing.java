/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP_3;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author TLDs
 */
public class _1_3_serverSwing {

    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;

    private static final int MAXCLIENTS = 5;
    public static ArrayList<Socket> threads = new ArrayList<Socket>();

    public static void main(String[] args) {
        int port = 7777;

        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("SERVER IS RUNNING ..........");

        while (true) {
            try {
                clientSocket = serverSocket.accept();

                int i = threads.size();

                if (threads.size() < MAXCLIENTS) {
                    threads.add(clientSocket);
                    new ClientThread(clientSocket).start();
                }

                //kiểm tra nếu vượt quá số kết nối tối đa
                if (i == MAXCLIENTS) {
                    System.out.println("Server too busy. Try later ...");
                    clientSocket.close();
                }

            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    static class ClientThread extends Thread {

        private Socket clientSocket = null;
        private DataInputStream inputStream = null;
        private DataOutputStream outputStream = null;

        public ClientThread(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                inputStream = new DataInputStream(clientSocket.getInputStream());
                outputStream = new DataOutputStream(clientSocket.getOutputStream());

                outputStream.writeUTF("Nhap ten cua ban: ");
                String clientName = inputStream.readUTF().trim();
                outputStream.writeUTF("Hello " + clientName);

                while (true) {
                    String chat = inputStream.readUTF();
                    if (chat.contains("/quit")) {
                        _1_3_serverSwing.threads.remove(clientSocket);
                        break;
                    }
                    
                    for (int i = 0; i < _1_3_serverSwing.threads.size(); i++) {
                        new DataOutputStream(_1_3_serverSwing.threads.get(i).getOutputStream()).writeUTF(clientName + ": " + chat);
                    }
                }

                //thông báo tới các client khác rằng client này đã thoát
                for (int i = 0; i < _1_3_serverSwing.threads.size(); i++) {
                    if (threads.get(i) != this.clientSocket) {
                        new DataOutputStream(_1_3_serverSwing.threads.get(i).getOutputStream()).writeUTF(clientName + " has left room!");
                    }
                }

                outputStream.writeUTF("---Bye " + clientName);

                outputStream.close();
                inputStream.close();
                clientSocket.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
