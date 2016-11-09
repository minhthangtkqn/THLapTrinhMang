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
public class _1_1_server {

    private static DatagramSocket socketServer;
    private static byte[] sendData, receiveData;
    private static final int port = 7777;

    public static void main(String[] args) {
        try {
            socketServer = new DatagramSocket(port);

            sendData = new byte[1024];
            receiveData = new byte[1024];

            String mission = "", inputLine = "", perform = "", processedLine = "";
            DatagramPacket receivePacket, sendPacket;

            int clientPort = 0;
            InetAddress address;

            while (true) {
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socketServer.receive(receivePacket);

                clientPort = receivePacket.getPort();
                address = receivePacket.getAddress();

                inputLine = new String(receivePacket.getData());
                mission = inputLine.substring(0, 1);
                perform = inputLine.substring(1, inputLine.length());
                switch (mission) {
                    case "1":
                        processedLine = perform.toUpperCase();
                        break;
                    case "2":
                        processedLine = perform.toLowerCase();
                        break;
                    case "3":
                        processedLine = "" + perform.split(" ").length;
                        break;
                }

                sendData = processedLine.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, address, clientPort);
                socketServer.send(sendPacket);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
