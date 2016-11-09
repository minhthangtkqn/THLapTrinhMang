package TCP_1;


import java.awt.GridLayout;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class _1_1_client implements ActionListener {

    public static Panel panel_2, pn2, pn3, panel_1;
    public static TextField tf_nhap = new TextField(5);
    public static TextField tf_ketqua = new TextField();
    public static Label lbnhap = new Label();
    public static Label lbkq = new Label();
    public static Button btn_UP_CASE, btn_exit, btn_low_case, btn_length;
    public static String s = "";
    private Socket socket;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;

    public _1_1_client() throws UnknownHostException, IOException {
        GUI();
    }

    void GUI() throws UnknownHostException, IOException {
        JFrame frame = new JFrame("Client");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout());

        lbnhap.setText("Nhap vao chuoi can xu ly");
        lbkq.setText("Ket qua");

        panel_1 = new Panel(new GridLayout(5, 1));
        panel_2 = new Panel(new GridBagLayout());

        btn_UP_CASE = new Button("VIET HOA");
        btn_low_case = new Button("viet thuong");
        btn_length = new Button("Dem so ky tu");
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

        socket = new Socket("127.0.0.1", 7777);
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
    }

    public static void main(String[] args) throws Exception {
        _1_1_client t = new _1_1_client();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == btn_UP_CASE) {
            try {
                String s = "1" + tf_nhap.getText();
                outputStream.writeUTF(s);
                String nhan = inputStream.readUTF();
                tf_ketqua.setText(nhan);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        if (e.getSource() == btn_low_case) {
            try {
                String s = "2" + tf_nhap.getText();
                outputStream.writeUTF(s);
                String nhan = inputStream.readUTF();
                tf_ketqua.setText(nhan);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        if (e.getSource() == btn_length) {
            try {
                String s = "3" + tf_nhap.getText();
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
