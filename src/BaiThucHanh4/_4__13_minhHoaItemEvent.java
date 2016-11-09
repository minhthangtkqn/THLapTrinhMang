/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author TLDs
 */
public class _4__13_minhHoaItemEvent extends JFrame implements ItemListener, ActionListener {

    private JLabel label_result, LICENSE;
    private CheckboxGroup checkboxGroup;
    private Checkbox male, female;
    private Choice choice;
    private List list;
    private JButton btn_thoat;

    public _4__13_minhHoaItemEvent() {
        super("MINH HỌA SỰ KIỆN ITEM EVENT");
        getContentPane().setPreferredSize(new Dimension(500, 500));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        initWindow();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == choice) {
            label_result.setText(e.getItem().toString());
        }
        if (e.getSource() == male || e.getSource() == female) {
            label_result.setText(e.getItem().toString());
        }
        if (e.getSource() == list) {
            label_result.setText(list.getSelectedItem());
        }
    }

    private void initWindow() {
        checkboxGroup = new CheckboxGroup();
        male = new Checkbox("Male", checkboxGroup, false);
        male.setBounds(80, 50, 80, 30);
        female = new Checkbox("Female", checkboxGroup, true);
        female.setBounds(180, 50, 80, 30);
        getContentPane().add(male);
        getContentPane().add(female);
        male.addItemListener(this);
        female.addItemListener(this);

        list = new List(4, false);
        list.add("Sport");
        list.add("Music");
        list.add("Travel");
        list.add("Game");
        list.add("Telen");
        list.add("Badminton");
        list.add("Soccer");
        list.add("Cup");
        list.setBounds(80, 120, 100, 50);
        getContentPane().add(list);
        list.addItemListener(this);

        choice = new Choice();
        choice.addItem("Sport");
        choice.addItem("Music");
        choice.addItem("Travel");
        choice.setBounds(80, 200, 100, 30);
        getContentPane().add(choice);
        choice.addItemListener(this);

        label_result = new JLabel("THE ITEM IS DISPLAYED HERE!");
        label_result.setBounds(80, 300, 300, 40);
        getContentPane().add(label_result);

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
        new _4__13_minhHoaItemEvent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_thoat) {
            System.exit(0);
        }
    }

}
