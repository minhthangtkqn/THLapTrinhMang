/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh4;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

/**
 *
 * Tạo frame chứa Label, Text field, Textarea
 *
 * @author TLDs
 */
class Frame2 extends Frame {

    public Frame2() {
        setTitle("Hello");
        setBounds(300, 200, 200, 200);
        //cac component se tu sap xep lai khi resize Window
        setLayout(new FlowLayout());
        //Dua frame vao giua man hinh
        setLocationRelativeTo(null);
        //Them cac components
        add(new Label("Enter your name"));
        add(new TextField("Your name here"));
        // param: row, col
        add(new TextArea(5, 30));
        //khi them vuot qua bound thi no se bị an di
        setVisible(true);
    }
}

public class _4_2_Label {

    public static void main(String[] args) {
        new Frame2();
    }
}
