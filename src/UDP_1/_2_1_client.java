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

    private static Panel panel_2, panel_1;
    private static TextField tf_input = new TextField(5);
    private static TextField tf_result = new TextField();
    private static Label lb_input = new Label();
    private static Label lb_result = new Label();
    private static Button btn_UP_CASE, btn_exit, btn_low_case, btn_length;
    private static String s = "";

    private DatagramSocket socket;
    private DatagramPacket sendPacket, receivePacket;
    private InetAddress ip;
    private final int port = 7777;

    public _2_1_client() {
        initGUI();
        initClient();
    }

    private void initClient() {
        try {
            socket = new DatagramSocket();
            ip = InetAddress.getByName("localhost");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void initGUI() {
        JFrame frame = new JFrame("Client");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout());

        lb_input.setText("Nhap vao chuoi can xu ly");
        lb_result.setText("Ket qua");

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

        panel_1.add(lb_input);
        panel_1.add(tf_input);
        panel_1.add(lb_result);
        panel_1.add(tf_result);
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
            String s = mission + tf_input.getText().trim();
            sendPacket = new DatagramPacket(s.getBytes(), s.length(), ip, port);
            socket.send(sendPacket);

            tf_result.setText("");

            byte[] receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            tf_result.setText(new String(receivePacket.getData()));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
