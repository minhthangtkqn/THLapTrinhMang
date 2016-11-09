/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

/**
 *
 * @author TLDs
 */
public class _2_3_Server {

    DatagramSocket serverSocket;

    DatagramPacket receivePacket;

    public _2_3_Server() throws Exception {

        serverSocket = new DatagramSocket(7777);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        ArrayList<DatagramPacket> packets = new ArrayList<>();
        while (true) {
            //receive
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            boolean exist = false;
            for (DatagramPacket dp : packets) {
                if (dp.getAddress().equals(receivePacket.getAddress()) && dp.getPort() == receivePacket.getPort()) {
                    exist = true;
                    break;
                }
            }

            if (exist == false) {
                packets.add(receivePacket);
            }

            //receive data
            String receive = new String(receivePacket.getData()).substring(0, receivePacket.getLength());
            System.out.println("rev" + receive);
            for (DatagramPacket dp : packets) {
                //address of client
                InetAddress iPAddress = dp.getAddress();
                int port = dp.getPort();
                System.out.println("portttt: " + port);
                //excute data
                String send = excuteString(receive);
                //send msg to client 
                DatagramPacket sendPacket = new DatagramPacket(send.getBytes(), send.length(), iPAddress, port);
                serverSocket.send(sendPacket);
            }
        }
    }

    private String excuteString(String inp) {
        return inp;
    }

    public static void main(String[] args) throws Exception {
        new _2_3_Server();
    }
}
