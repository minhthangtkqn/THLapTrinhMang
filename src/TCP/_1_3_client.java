/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author TLDs
 */
public class _1_3_client {

    private static Socket socket = null;
    private static DataInputStream inputStream = null;
    private static DataOutputStream outputStream = null;

    private static boolean isClosed = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int port = 7777;
        String host = "localhost";

        //tao ket noi den server
        try {
            socket = new Socket(host, port);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            System.out.println(e);
        }

        if (socket != null && inputStream != null && outputStream != null) {
            try {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String receiveString;
                            //kiem tra string nhan duoc có tồn tại hay không
                            while ((receiveString = inputStream.readUTF()) != null) {
                                System.out.println(receiveString);
                                //kiểm tra lệnh thoát
                                if (receiveString.startsWith("---Bye")) {
                                    break;
                                }
                            }
                            isClosed = true;

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }).start();

                while (!isClosed) {
                    outputStream.writeUTF(scanner.nextLine().trim());
                }

                outputStream.close();
                inputStream.close();
                socket.close();

                //thoát chương trình client
                System.exit(0);
            } catch (Exception e) {
            }
        }

    }
}