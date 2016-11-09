/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP_2;

import calculate.Calculate;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLDs
 */
public class _1_2_server extends Thread {

    private static ServerSocket serverSocket;
    private static Socket socket;

    public static void main(String[] args) {

        int port = 7777;

        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        System.out.println("Server is running............");
        while (true) {
            try {
                socket = serverSocket.accept();
                new ClientThread(socket).start();

            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
    }

    static class ClientThread extends Thread {

        private Socket socket = null;
        private DataInputStream inputStream = null;
        private DataOutputStream outputStream = null;

        public ClientThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                inputStream = new DataInputStream(this.socket.getInputStream());
                outputStream = new DataOutputStream(this.socket.getOutputStream());
                String inputLine, processedLine = "";

                Calculate calculate = new Calculate();

                while (true) {
                    inputLine = inputStream.readUTF();
                    System.out.println(inputLine);
                    processedLine = calculate.calculate(inputLine);
                    outputStream.writeUTF(processedLine);
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
    }
}
