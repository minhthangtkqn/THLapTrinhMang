/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author TLDs
 */
public class _2_1_client implements ActionListener {

    private static Panel panel_2, pn2, pn3, panel_1;
    private static TextField tf_nhap = new TextField(5);
    private static TextField tf_ketqua = new TextField();
    private static Label lbnhap = new Label();
    private static Label lbkq = new Label();
    private static Button btn_UP_CASE, btn_exit, btn_low_case, btn_length;
    private static String s = "";

    private DatagramSocket socket;
    private DatagramPacket sendPacket, receivePacket;
    private InetAddress ip;
    private byte[] sendData, receiveData;
    private final int port = 7777;

    public _2_1_client() {
        initGUI();
        initClient();
    }

    private void initClient() {
        try {
            socket = new DatagramSocket();
            ip = InetAddress.getByName("localhost");

            sendData = new byte[1024];
            receiveData = new byte[1024];
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void initGUI() {
        JFrame frame = new JFrame("Client");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout());

        lbnhap.setText("Nhap vao chuoi can xu ly");
        lbkq.setText("Ket qua");

        panel_1 = new Panel(new GridLayout(5, 1));
        panel_2 = new Panel(new GridBagLayout());

        btn_UP_CASE = new Button("VIET HOA");
        btn_low_case = new Button("viet thuong");
        btn_length = new Button("Dem so tu");
        btn_exit = new Button("Exit");

        //add buttons into 1 row
        panel_2.add(btn_UP_CASE);
        panel_2.add(btn_low_case);
        panel_2.add(btn_length);
        panel_2.add(btn_exit);

        panel_1.add(lbnhap);
        panel_1.add(tf_nhap);
        panel_1.add(lbkq);
        panel_1.add(tf_ketqua);
        panel_1.add(panel_2);

        frame.add(panel_1);

        //add listener of button to frame
        btn_UP_CASE.addActionListener(this);
        btn_low_case.addActionListener(this);
        btn_length.addActionListener(this);
        btn_exit.addActionListener(this);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new _2_1_client();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_UP_CASE) {
            sendData("1");
        }

        if (e.getSource() == btn_low_case) {
            sendData("2");
        }

        if (e.getSource() == btn_length) {
            sendData("3");
        }

        if (e.getSource() == btn_exit) {
            try {
                socket.close();
                System.exit(0);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    private void sendData(String mission) {
        try {
            String s = mission + tf_nhap.getText().trim();
            sendData = s.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, ip, port);
            socket.send(sendPacket);

            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            tf_ketqua.setText(new String(receivePacket.getData()));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
