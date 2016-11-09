package client_server_thay_Nguyen;

import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class client implements ActionListener {

    public static Panel pn1, pn2, pn3, pn;
    public static TextField textfield_nhap = new TextField(5);
    public static TextField textfield_ketqua = new TextField();
    public static Label lbnhap = new Label();
    public static Label lbkq = new Label();
    public static Button btn_send, btn_exit;
    public static String s = "";
    Socket socket;
    DataOutputStream outputStream;
    DataInputStream inputStream;

    public client() throws UnknownHostException, IOException {
        GUI();
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
        pn.add(textfield_nhap);
        pn.add(lbkq);
        pn.add(textfield_ketqua);
        pn1.add(btn_send);
        pn1.add(btn_exit);
        pn.add(pn1);
        fr.add(pn);
        btn_send.addActionListener(this);
        btn_exit.addActionListener(this);
        fr.show();
        socket = new Socket("127.0.0.1", 7777);;
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
    }

    public static void main(String[] args) throws Exception {
        client t = new client();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == btn_send) {
            try {
                String s = textfield_nhap.getText();
                outputStream.writeUTF(s);
                String nhan = inputStream.readUTF();
                textfield_ketqua.setText(nhan);

            } catch (UnknownHostException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
        if (e.getSource() == btn_exit) {
            System.exit(0);
        }
    }
}
