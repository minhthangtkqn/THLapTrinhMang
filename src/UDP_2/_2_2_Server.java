/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_2;

import calculate.Calculate;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author TLDs
 */
public class _2_2_Server {

    DatagramSocket serverSocket;
    Calculate calculate;

    public _2_2_Server() throws Exception {
        calculate = new Calculate();

        serverSocket = new DatagramSocket(7777);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while (true) {
            //receive
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            String receive = new String(receivePacket.getData()).substring(0, receivePacket.getLength());
            System.out.println("rev" + receive);

            InetAddress iPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            //excute
            String send = excuteString(receive);
            //send
            DatagramPacket sendPacket = new DatagramPacket(send.getBytes(), send.length(), iPAddress, port);
            serverSocket.send(sendPacket);
        }
    }

    private String excuteString(String inp) {
        return calculate.calculate(inp);
    }

    public static void main(String[] args) throws Exception {
        new _2_2_Server();
    }
}
