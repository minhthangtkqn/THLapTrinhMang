/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_1;

import java.net.*;

/**
 *
 * @author TLDs
 */
public class _2_1_server {

    private static DatagramSocket socketServer;
    private static byte[] sendData, receiveData;
    private static final int port = 7777;

    public static void main(String[] args) {
        try {
            socketServer = new DatagramSocket(port);

            String mission = "", inputLine = "", perform = "", resultString = "";

            int clientPort = 0;
            InetAddress address;

            while (true) {
                sendData = new byte[1024];
                receiveData = new byte[1024];

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socketServer.receive(receivePacket);

                clientPort = receivePacket.getPort();
                address = receivePacket.getAddress();

                inputLine = new String(receivePacket.getData());
                mission = inputLine.substring(0, 1);
                perform = inputLine.substring(1, inputLine.length());
                switch (mission) {
                    case "1":
                        resultString = perform.toUpperCase();
                        break;
                    case "2":
                        resultString = perform.toLowerCase();
                        break;
                    case "3":
                        resultString = "" + perform.split(" ").length;
                        break;
                }
                System.out.println("Ket qua: " + resultString);
                sendData = resultString.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, clientPort);
                socketServer.send(sendPacket);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
