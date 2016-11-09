/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_3;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author TLDs
 */
public class _2_3_Client implements ActionListener {

    DatagramSocket clientSocket;
    InetAddress iPAddress;
    DatagramPacket sendPacket;
    DatagramPacket receivePacket;
    int port;

    public static Panel pn1, pn2, pn3, pn;
    public static String clientName;

    Label lbHost, lbPort, lbName, lbChatRoom, lbInputMessage;
    TextField tfHost, tfPort, tfName, tfMessage;
    TextArea tfChatRoom;
    Button btnStart, btnSend;

    public _2_3_Client() throws Exception {
        init();
    }

    void init() throws Exception {
        GUI();
    }

    
    
    void GUI() throws UnknownHostException, IOException {

        JFrame fr = new JFrame("Client");
        fr.setSize(400, 1200);
        fr.setLayout(new GridLayout());
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pn = new Panel(new GridLayout(6, 1));

        pn1 = new Panel(new GridLayout(1, 4));
        pn1.setSize(fr.getWidth(), 50);
        lbHost = new Label("Hostname: ");
        tfHost = new TextField("localhost");
        lbPort = new Label("Port: ");
        tfPort = new TextField("7777");
        pn1.add(lbHost, 0);
        pn1.add(tfHost, 1);
        pn1.add(lbPort, 2);
        pn1.add(tfPort, 3);

        pn2 = new Panel(new GridLayout(1, 3));
        pn2.setFocusable(true);
        lbName = new Label("ClientName: ");
        tfName = new TextField();
        tfName.setFocusable(true);
        btnStart = new Button("Start");
        btnStart.setEnabled(true);
        pn2.add(lbName, 0);
        pn2.add(tfName, 1);
        pn2.add(btnStart, 2);

        lbChatRoom = new Label("Chat room: ");

        tfChatRoom = new TextArea();
        tfChatRoom.setSize(fr.getWidth(), 500);
        tfChatRoom.setEditable(false);

        lbInputMessage = new Label("Input: ");

        pn3 = new Panel(new GridLayout(1, 2));
        tfMessage = new TextField();
        btnSend = new Button("Send");
        btnSend.setEnabled(false);
        pn3.add(tfMessage, 0);
        pn3.add(btnSend, 1);

        pn.add(pn1);
        pn.add(pn2);
        pn.add(lbChatRoom);
        pn.add(tfChatRoom);
        pn.add(lbInputMessage);
        pn.add(pn3);

        fr.add(pn);

        btnStart.addActionListener(this);
        btnSend.addActionListener(this);
        fr.show();

    }

    public static void main(String[] args) throws Exception {
        new _2_3_Client();
    }

    void excute(String func) throws IOException {
        String send = clientName + " : " + tfMessage.getText();
        sendPacket = new DatagramPacket(send.getBytes(), send.length(), iPAddress, 7777);
        clientSocket.send(sendPacket);
        //clear input box
        tfMessage.setText("");
    }

    String msg;

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnStart) {
                //get client name
                clientName = tfName.getText();
                port = Integer.parseInt(tfPort.getText());

                tfHost.setEditable(false);
                tfPort.setEditable(false);
                btnSend.setEnabled(true);
                btnStart.setEnabled(false);

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            clientSocket = new DatagramSocket();
                            iPAddress = InetAddress.getByName(tfHost.getText());
                        } catch (Exception ex) {
                            System.out.println("" + ex);
                        }

                        //listen to message from server
                        while (true) {
                            byte[] receiveData = new byte[1024];
                            receivePacket = new DatagramPacket(receiveData, receiveData.length);
                            try {
                                clientSocket.receive(receivePacket);
                            } catch (IOException ex) {
                                Logger.getLogger(_2_3_Client.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            String result = new String(receivePacket.getData()).toString().substring(0, receivePacket.getLength());
                            System.out.println("ket qua: " + result);
                            tfChatRoom.setText(tfChatRoom.getText() + "\n" + result);
                        }
                    }
                });

                t.start();
            }
            if (e.getSource() == btnSend) {
                msg = tfMessage.getText();
                excute("msg");
            }
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }
}
