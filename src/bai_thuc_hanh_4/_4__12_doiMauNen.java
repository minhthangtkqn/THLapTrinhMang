/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_4;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author TLDs
 */
public class _4__12_doiMauNen extends JFrame implements ActionListener {

    private Button btnRed, btnGreen, btnBlue, btnYellow, btnExit;

    public _4__12_doiMauNen(String title) {
        super(title);

        getContentPane().setPreferredSize(new Dimension(500, 500));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        //default background color
        getContentPane().setBackground(new Color(255, 200, 50));

        //create interface of window
        initWindow();

        //setup location and visibility of window, etc
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new _4__12_doiMauNen("BUTTON ĐỔI MÀU NỀN");
    }

    private void initWindow() {
        btnGreen = new Button("GREEN");
        this.getContentPane().add(btnGreen);
        btnGreen.addActionListener(this);

        btnRed = new Button("RED");
        this.getContentPane().add(btnRed);
        btnRed.addActionListener(this);

        btnYellow = new Button("YELLOW");
        this.getContentPane().add(btnYellow);
        btnYellow.addActionListener(this);

        btnBlue = new Button("BLUE");
        this.getContentPane().add(btnBlue);
        btnBlue.addActionListener(this);

        btnExit = new Button("EXIT");
        this.getContentPane().add(btnExit);
        btnExit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBlue) {
            getContentPane().setBackground(Color.BLUE);
        }

        if (e.getSource() == btnGreen) {
            getContentPane().setBackground(Color.GREEN);
        }

        if (e.getSource() == btnRed) {
            getContentPane().setBackground(Color.RED);
        }

        if (e.getSource() == btnYellow) {
            getContentPane().setBackground(Color.YELLOW);
        }

        if (e.getSource() == btnExit) {
            System.exit(0);
        }

    }

}
