/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_4;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author TLDs
 */
public class _4_8_minhHoaTinhToan extends JFrame implements ActionListener {

    private JLabel label_nhap_a, label_nhap_b, label_ketqua, LICENSE;
    private JTextField textfield_a, textfield_b, textfield_ketqua;
    private JButton btn_thoat, btn_reset, btn_cong, btn_tru, btn_nhan, btn_chia;
    
    private double a, b, ketQua;
    private DecimalFormat df = new DecimalFormat("#.#####");

    public _4_8_minhHoaTinhToan() {
        super("MINH HỌA CÁC PHÉP TÍNH TOÁN");
        getContentPane().setPreferredSize(new Dimension(500, 450));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
        setLayout(null);

        initWindow();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_thoat) {
            System.exit(0);
        } else if (e.getSource() == btn_reset) {
            textfield_a.setText("");
            textfield_b.setText("");
            textfield_ketqua.setText("");
        } else {
            try {
                this.a = Double.parseDouble(textfield_a.getText());
                this.b = Double.parseDouble(textfield_b.getText());

                if (e.getSource() == btn_cong) {
                    this.ketQua = a + b;
                    textfield_ketqua.setText(df.format(ketQua));
                }
                if (e.getSource() == btn_tru) {
                    this.ketQua = a - b;
                    textfield_ketqua.setText(df.format(ketQua));
                }
                if (e.getSource() == btn_nhan) {
                    this.ketQua = a * b;
                    textfield_ketqua.setText(df.format(ketQua));
                }
                if (e.getSource() == btn_chia) {
                    this.ketQua = a / b;
                    textfield_ketqua.setText(df.format(ketQua));
                }
            } catch (NumberFormatException numEx) {
                textfield_ketqua.setText("BẠN PHẢI NHẬP SỐ ĐỂ TÍNH TOÁN");
            } catch (Exception ex) {
                textfield_ketqua.setText("ĐÃ CÓ LỖI XẢY RA: " + ex);
            }
        }
    }

    private void initWindow() {
        //LABELS
        label_nhap_a = new JLabel("Nhập a: ");
        label_nhap_a.setBounds(10, 0, 100, 40);
        getContentPane().add(label_nhap_a);

        label_nhap_b = new JLabel("Nhập b: ");
        label_nhap_b.setBounds(10, 50, 100, 40);
        getContentPane().add(label_nhap_b);

        label_ketqua = new JLabel("KẾT QUẢ");
        label_ketqua.setBounds(10, 100, 100, 40);
        getContentPane().add(label_ketqua);

        //TEXT FIELDS
        textfield_a = new JTextField();
        textfield_a.setBounds(150, 10, 300, 30);
        getContentPane().add(textfield_a);

        textfield_b = new JTextField();
        textfield_b.setBounds(150, 60, 300, 30);
        getContentPane().add(textfield_b);

        textfield_ketqua = new JTextField();
        textfield_ketqua.setBounds(150, 110, 300, 30);
        textfield_ketqua.setEditable(false);
        getContentPane().add(textfield_ketqua);

        //BUTTONS
        btn_cong = new JButton("CỘNG");
        btn_cong.setBounds(50, 200, 80, 40);
        getContentPane().add(btn_cong);
        btn_cong.addActionListener(this);

        btn_tru = new JButton("TRỪ");
        btn_tru.setBounds(150, 200, 80, 40);
        getContentPane().add(btn_tru);
        btn_tru.addActionListener(this);

        btn_nhan = new JButton("NHÂN");
        btn_nhan.setBounds(250, 200, 80, 40);
        getContentPane().add(btn_nhan);
        btn_nhan.addActionListener(this);

        btn_chia = new JButton("CHIA");
        btn_chia.setBounds(350, 200, 80, 40);
        getContentPane().add(btn_chia);
        btn_chia.addActionListener(this);

        btn_reset = new JButton("RESET");
        btn_reset.setBounds(120, 300, 80, 40);
        getContentPane().add(btn_reset);
        btn_reset.addActionListener(this);

        btn_thoat = new JButton("THOÁT");
        btn_thoat.setBounds(270, 300, 80, 40);
        getContentPane().add(btn_thoat);
        btn_thoat.addActionListener(this);

        //bản quyền
        LICENSE = new JLabel("HOÀNG MINH THẮNG - 13TCLC");
        LICENSE.setBounds(100, 400, 200, 40);
        getContentPane().add(LICENSE);
    }

    public static void main(String[] args) {
        new _4_8_minhHoaTinhToan();
    }
}
