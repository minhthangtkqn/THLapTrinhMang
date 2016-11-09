/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh4;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author TLDs
 */
public class _4__10_kiemTraFibonacci extends JFrame implements ActionListener {

    private JLabel label_nhap_n, label_ketqua, LICENSE;
    private JTextField textfield_N, textfield_ketqua;
    private JButton btn_kiemtra, btn_reset, btn_thoat;
    private long n, f1, f2, tmp;
    private boolean isFibonacci;

    public _4__10_kiemTraFibonacci() {
        super("KIỂM TRA SỐ THUỘC DÃY FIBONACCI");
        getContentPane().setPreferredSize(new Dimension(500, 300));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        initWindow();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new _4__10_kiemTraFibonacci();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_kiemtra) {
            textfield_ketqua.setText("");

            try {
                this.n = Long.parseLong(textfield_N.getText());

                f1 = 0;
                f2 = 1;

                isFibonacci = false;

                if (n == f1 || n == f2) {
                    textfield_ketqua.setText(n + " thuộc dãy số Fibonacci");
                    return;
                }

                do {
                    tmp = f1 + f2;
                    if (tmp == n) {
                        isFibonacci = true;
                        break;
                    }

                    f1 = f2;
                    f2 = tmp;

                } while (tmp < n);

                if (isFibonacci) {
                    textfield_ketqua.setText(n + " thuộc dãy số Fibonacci");
                } else {
                    textfield_ketqua.setText(n + " không thuộc dãy số Fibonacci");
                }
            } catch (NumberFormatException numEx) {
                textfield_ketqua.setText("KHÔNG ĐÚNG ĐỊNH DẠNG SỐ, VUI LÒNG NHẬP LẠI");
            } catch (Exception ex) {
                textfield_ketqua.setText("ĐÃ CÓ LỖI XẢY RA: " + ex);
            }
        }

        if (e.getSource() == btn_thoat) {
            System.exit(0);
        }

        if (e.getSource() == btn_reset) {
            textfield_N.setText("");
            textfield_ketqua.setText("");
        }
    }

    private void initWindow() {
        //LABELS
        label_nhap_n = new JLabel("Nhập N: ");
        label_nhap_n.setBounds(10, 0, 100, 40);
        getContentPane().add(label_nhap_n);

        label_ketqua = new JLabel("Kết quả: ");
        label_ketqua.setBounds(10, 50, 100, 40);
        getContentPane().add(label_ketqua);

        //TEXT FIELDS
        textfield_N = new JTextField();
        textfield_N.setBounds(150, 10, 320, 30);
        getContentPane().add(textfield_N);

        textfield_ketqua = new JTextField();
        textfield_ketqua.setBounds(150, 60, 320, 30);
        textfield_ketqua.setEditable(false);
        getContentPane().add(textfield_ketqua);

        //BUTTONS
        btn_kiemtra = new JButton("KIỂM TRA");
        btn_kiemtra.setBounds(50, 150, 130, 40);
        getContentPane().add(btn_kiemtra);
        btn_kiemtra.addActionListener(this);

        btn_reset = new JButton("RESET");
        btn_reset.setBounds(200, 150, 80, 40);
        getContentPane().add(btn_reset);
        btn_reset.addActionListener(this);

        btn_thoat = new JButton("THOÁT");
        btn_thoat.setBounds(300, 150, 80, 40);
        getContentPane().add(btn_thoat);
        btn_thoat.addActionListener(this);

        //bản quyền
        LICENSE = new JLabel("HOÀNG MINH THẮNG - 13TCLC");
        LICENSE.setBounds(100, 220, 200, 40);
        getContentPane().add(LICENSE);
    }

}
