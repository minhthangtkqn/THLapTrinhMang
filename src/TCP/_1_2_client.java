/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

/**
 *
 * @author TLDs
 */
public class _1_2_client implements ActionListener {

    public static Panel sub_panel, pn2, pn3, main_panel;
    public static TextField tf_nhap = new TextField(5);
    public static TextField tf_ketqua = new TextField();
    public static Label lbnhap = new Label();
    public static Label lbkq = new Label();
    public static Button btn_send, btn_exit;
    
    private Socket socket;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;

    public _1_2_client() throws UnknownHostException, IOException {
        GUI();
    }

    void GUI() throws UnknownHostException, IOException {

        JFrame frame = new JFrame("Client");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout());

        lbnhap.setText("Nhap vao chuoi can xu ly");
        lbkq.setText("Ket qua");

        main_panel = new Panel(new GridLayout(5, 1));
        sub_panel = new Panel(new GridBagLayout());

        btn_send = new Button("SEND");
        btn_exit = new Button("Exit");

        //add buttons into 1 row
        sub_panel.add(btn_send);
        sub_panel.add(btn_exit);

        //add components into main panel
        main_panel.add(lbnhap);
        main_panel.add(tf_nhap);
        main_panel.add(lbkq);
        main_panel.add(tf_ketqua);
        main_panel.add(sub_panel);

        frame.add(main_panel);

        //add listener of button to frame
        btn_send.addActionListener(this);
        btn_exit.addActionListener(this);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //init connection
        socket = new Socket("127.0.0.1", 7777);
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
    }

    public static void main(String[] args) throws Exception {
        new _1_2_client();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == btn_send) {
            try {
                String s = tf_nhap.getText().replaceAll(" ", "");
                outputStream.writeUTF(s);
                String nhan = inputStream.readUTF();
                tf_ketqua.setText(nhan);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        if (e.getSource() == btn_exit) {
            try {
                outputStream.close();
                inputStream.close();
                socket.close();
                System.exit(0);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
