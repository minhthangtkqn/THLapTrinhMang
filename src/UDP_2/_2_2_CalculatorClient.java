/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_2;

import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author TLDs
 */
public class _2_2_CalculatorClient implements ActionListener {

    DatagramSocket clientSocket;
    InetAddress iPAddress;
    DatagramPacket sendPacket;
    DatagramPacket receivePacket;

    public static Panel pn1, pn2, pn3, pn;
    public static TextField tfnhap = new TextField(5);
    public static TextField tfkq = new TextField();
    public static Label lbnhap = new Label();
    public static Label lbkq = new Label();
    public static Button btn_send, btn_exit;
    public static String s = "";

    public _2_2_CalculatorClient() throws Exception {
        init();
        GUI();
    }

    void init() throws Exception {
        clientSocket = new DatagramSocket();
        iPAddress = InetAddress.getByName("localhost");
    }

    void GUI() throws UnknownHostException, IOException {

        JFrame fr = new JFrame("Client");
        fr.setSize(400, 200);
        fr.setLayout(new GridLayout());
        lbnhap.setText("Nhap vao chuoi can tinh toan");
        lbkq.setText("Ket qua");
        pn = new Panel(new GridLayout(5, 1));
        pn1 = new Panel(new GridBagLayout());
        btn_send = new Button("send");
        btn_exit = new Button("Exit");
        pn.add(lbnhap);
        pn.add(tfnhap);
        pn.add(lbkq);
        pn.add(tfkq);
        pn1.add(btn_send);
        pn1.add(btn_exit);
        pn.add(pn1);
        fr.add(pn);

        btn_send.addActionListener(this);
        btn_exit.addActionListener(this);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        new _2_2_CalculatorClient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btn_send) {
                String send = tfnhap.getText();

                sendPacket = new DatagramPacket(send.getBytes(), send.length(), iPAddress, 7777);
                clientSocket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                String result = new String(receivePacket.getData()).toString().substring(0, receivePacket.getLength());
                System.out.println("ket qua: " + result);
                tfkq.setText(result);
            }

            if (e.getSource() == btn_exit) {
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }
}
