/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_4;

/**
 *
 * @author TLDs
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class _4_7_GiaiPhuongTrinhBacNhat extends JFrame implements ActionListener {

    private JButton btnGiaiPhuongTrinh, btnReset, btnThoat;
    private JTextField aVar, bVar, ketQuaTF;
    private JLabel labelA, labelB, labelKetQua;

    private double a, b;
    private JLabel LICENSE;

    public _4_7_GiaiPhuongTrinhBacNhat() {
        super("GIẢI PHƯƠNG TRÌNH BẬC NHẤT");
        getContentPane().setPreferredSize(new Dimension(500, 500));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
        setLayout(null);

        initWindow();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initWindow() {
        //labels
        labelA = new JLabel("Nhập a: ");
        labelA.setBounds(10, 0, 100, 40);
        getContentPane().add(labelA);

        labelB = new JLabel("Nhập b: ");
        labelB.setBounds(10, 50, 100, 40);
        getContentPane().add(labelB);
        
        labelKetQua = new JLabel("KẾT QUẢ ");
        labelKetQua.setBounds(10, 100, 100, 40);
        getContentPane().add(labelKetQua);
        
//        text fields
        aVar = new JTextField();
        aVar.setBounds(150, 5, 300, 30);
        getContentPane().add(aVar);

        bVar = new JTextField();
        bVar.setBounds(150, 50, 300, 30);
        getContentPane().add(bVar);

        ketQuaTF = new JTextField();
        ketQuaTF.setEditable(false);
        ketQuaTF.setBounds(150, 100, 300, 30);
        getContentPane().add(ketQuaTF);

        //buttons
        btnGiaiPhuongTrinh = new JButton("GIẢI PHƯƠNG TRÌNH");
        btnGiaiPhuongTrinh.setBounds(50, 200, 150, 40);
        getContentPane().add(btnGiaiPhuongTrinh);
        btnGiaiPhuongTrinh.addActionListener(this);

        btnReset = new JButton("RESET");
        btnReset.setBounds(230, 200, 100, 40);
        getContentPane().add(btnReset);
        btnReset.addActionListener(this);

        btnThoat = new JButton("THOÁT");
        btnThoat.setBounds(370, 200, 100, 40);
        getContentPane().add(btnThoat);
        btnThoat.addActionListener(this);
        
        //bản quyền
        LICENSE = new JLabel("HOÀNG MINH THẮNG - 13TCLC");
        LICENSE.setBounds(100, 400, 200, 40);
        getContentPane().add(LICENSE);

    }

    public static void main(String[] args) {
        new _4_7_GiaiPhuongTrinhBacNhat();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThoat) {
            System.exit(0);
        }

        if (e.getSource() == btnReset) {
            aVar.setText("");
            bVar.setText("");
            ketQuaTF.setText("");
        }

        if (e.getSource() == btnGiaiPhuongTrinh) {
            try {
                this.a = Double.parseDouble(aVar.getText());
                this.b = Double.parseDouble(bVar.getText());

                ketQuaTF.setText(giaiPTBacNhat(this.a, this.b));
            } catch (NumberFormatException numEx) {
                ketQuaTF.setText("BẠN PHẢI NHẬP SỐ ĐỂ GIẢI PHƯƠNG TRÌNH");
            } catch (Exception ex) {
                ketQuaTF.setText("Da co loi xay ra");
                System.out.println(ex);
            }

        }
    }

    public String giaiPTBacNhat(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                return "Phuong trinh co vo so nghiem";
            } else {
                return "Phuong trinh vo nghiem";
            }
        } else {
            return "Phuong trinh co nghiem duy nhat la: " + (-b / a);
        }
    }

}
