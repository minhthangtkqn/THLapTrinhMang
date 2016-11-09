package TCP_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _1_1_server extends Thread {

    private static ServerSocket serverSocket;
    private static Socket socket;

    public static void main(String[] args) {
        int port = 7777;

        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        System.out.print("Server is running............");

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
                String inputLine, processedLine = "", mission, perform;
                while (true) {
                    inputLine = inputStream.readUTF();
                    System.out.println(inputLine);
                    mission = inputLine.substring(0, 1);
                    perform = inputLine.substring(1, inputLine.length());
                    switch (mission) {
                        case "1":
                            processedLine = xuLyThanhChuHOA(perform);
                            break;
                        case "2":
                            processedLine = xuLyThanhChuThuong(perform);
                            break;
                        case "3":
                            processedLine = "" + demSoTu(perform);
                            break;
                    }
                    outputStream.writeUTF(processedLine);
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        private String xuLyThanhChuHOA(String inputLine) {
            return inputLine.toUpperCase();
        }

        private String xuLyThanhChuThuong(String inputLine) {
            return inputLine.toLowerCase();
        }

        private int demSoTu(String inputLine) {
            return inputLine.split(" ").length;
        }

    }

}
