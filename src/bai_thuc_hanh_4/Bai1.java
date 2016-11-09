/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_4;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

/**
 * Tạo Frame chứa nút Button và Cancel
 *
 * @author zquangu112z
 */
class Frame1 extends Frame {

    public Frame1() {
        setTitle("Hello");
        setBounds(300, 200, 200, 200);
        //cac component se tu sap xep lai khi resize Window
        setLayout(new FlowLayout());
        //Dua frame vao giua man hinh
        setLocationRelativeTo(null);
        //Them cac components
        add(new Button("OK"));
        add(new Button("Cancel"));
        add(new Button("Cancel2"));
        add(new Button("Cancel3"));
        add(new Button("Cancel4"));
        add(new Button("Cancel4"));
        add(new Button("Cancel4"));
        add(new Button("Cancel4"));
        add(new Button("Cancel4"));
        add(new Button("Cancel4"));
        add(new Button("Cancel4"));
        add(new Button("Cancel4"));
        add(new Button("Cancel4"));
        add(new Button("Cancel4"));
        add(new Button("Cancel4"));
        add(new Button("Cancel4"));
        add(new Button("Cancel4"));
        //khi them vuot qua bound thi no se bị an di
        setVisible(true);
    }
}

public class Bai1 {

    public static void main(String[] args) {
        Frame1 f1 = new Frame1();
    }
}
