/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh4;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author TLDs
 */
public class _4_9_soNguyenTo extends JFrame implements ActionListener {

    private JLabel label_nhap_n, label_ketqua, LICENSE;
    private JTextField textfield_N, textfield_ketqua;
    private JButton btn_tim, btn_reset, btn_thoat;
    private BigInteger n;

    public _4_9_soNguyenTo() {
        super("IN RA CÁC SỐ NGUYÊN TỐ NHỎ HƠN HOẶC BẰNG N");
        getContentPane().setPreferredSize(new Dimension(500, 500));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        initWindow();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn_tim) {
            textfield_ketqua.setText("");

            try {
                n = new BigInteger(textfield_N.getText());

                for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) != 1; i = i.add(BigInteger.ONE)) {
                    if (kiemTraNguyenTo(i)) {
                        textfield_ketqua.setText(textfield_ketqua.getText() + " " + i + ",");
                    }
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
    
    private boolean kiemTraNguyenTo(BigInteger X) {
        BigInteger n2 = BigInteger.valueOf(2);

        if (X.compareTo(n2) == 0) {
            return true;
        }

        BigInteger[] arr = X.divideAndRemainder(n2);

        if (arr[1].equals(BigInteger.valueOf(0))) {
            return false;
        }

        long i = 3;
        while (X.compareTo(BigInteger.valueOf(i * i)) == 1) {
            BigInteger[] arr2 = X.divideAndRemainder(BigInteger.valueOf(i));
            if (arr2[1].equals(BigInteger.ZERO)) {
                return false;
            }
            i += 2;
        };
        return true;
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
        textfield_N.setBounds(150, 10, 300, 30);
        getContentPane().add(textfield_N);

        textfield_ketqua = new JTextField();
        textfield_ketqua.setBounds(150, 60, 300, 30);
        getContentPane().add(textfield_ketqua);

        //BUTTONS
        btn_tim = new JButton("TÌM");
        btn_tim.setBounds(100, 150, 80, 40);
        getContentPane().add(btn_tim);
        btn_tim.addActionListener(this);

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
        LICENSE.setBounds(100, 400, 200, 40);
        getContentPane().add(LICENSE);
    }

    public static void main(String[] args) {
        new _4_9_soNguyenTo();
    }
}
