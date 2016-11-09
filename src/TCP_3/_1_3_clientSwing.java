/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP_3;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author TLDs
 */
public class _1_3_clientSwing extends JFrame {
    
    private JButton btnSend, btnExit;
    private JLabel lbMessagesArea, lbChatField;
    private TextField tfChat;
    private JTextArea taMessages;
    
    private static Socket socket = null;
    private static DataInputStream inputStream = null;
    private static DataOutputStream outputStream = null;
    
    private static boolean isClosed = false;
    
    public _1_3_clientSwing() {
        initGUI();
        initClient();
    }
    
    private void initGUI() {
        setTitle("CHAT CLIENT");
        getContentPane().setPreferredSize(new Dimension(300, 500));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        initWindowComponents();
        
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private void initWindowComponents() {
        
        lbMessagesArea = new JLabel("Chat Messages");
        lbMessagesArea.setBounds(10, 10, 280, 30);
        getContentPane().add(lbMessagesArea);
        
        taMessages = new JTextArea(3,4);
        taMessages.setEditable(false);
        taMessages.setBounds(10, 60, 280, 150);
        getContentPane().add(taMessages);
        
        lbChatField = new JLabel("Chat");
        lbChatField.setBounds(10, 220, 280, 30);
        getContentPane().add(lbChatField);
        
        tfChat = new TextField();
        tfChat.setBounds(10, 260, 280, 40);
        getContentPane().add(tfChat);
        
        btnSend = new JButton("SEND");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    outputStream.writeUTF(tfChat.getText().trim());
                    tfChat.setText("");
                    tfChat.requestFocus();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        });
        btnSend.setBounds(10, 320, 135, 50);
        getContentPane().add(btnSend);
        
        btnExit = new JButton("EXIT");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    socket.close();
                    inputStream.close();
                    outputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(_1_3_clientSwing.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }
        });
        btnExit.setBounds(155, 320, 135, 50);
        getContentPane().add(btnExit);
    }
    
    private void initClient() {
        int port = 7777;
        String host = "localhost";

        //tao ket noi den server
        try {
            socket = new Socket(host, port);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        if (socket != null && inputStream != null && outputStream != null) {
            try {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String receiveString;
                            //kiem tra string nhan duoc có tồn tại hay không
                            while ((receiveString = inputStream.readUTF()) != null) {
                                taMessages.append("\n" + receiveString);
                                //kiểm tra lệnh thoát
                                if (receiveString.startsWith("---Bye")) {
                                    break;
                                }
                            }
                            isClosed = true;
                            
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }).start();
                
                while (!isClosed) {
                }
                
                outputStream.close();
                inputStream.close();
                socket.close();

                //thoát chương trình client
                System.exit(0);
            } catch (Exception e) {
            }
        }
    }
    
    public static void main(String[] args) {
        new _1_3_clientSwing();
    }
    
}
