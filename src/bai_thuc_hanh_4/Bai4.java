/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_4;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;

/**
 * Tạo frame chứa Choice va List
 *
 * @author zquangu112z
 */
class Frame4 extends Frame {

    public Frame4() {
        setTitle("Hello");
        setBounds(300, 200, 200, 200);
        //cac component se tu sap xep lai khi resize Window
        setLayout(new FlowLayout());
        //Dua frame vao giua man hinh
        setLocationRelativeTo(null);
        //Them cac components
        Choice ch = new Choice();
        ch.addItem("Sport");
        ch.addItem("Music");
        ch.addItem("Travel");
        add(ch);

        List list = new List(3, false);
        list.add("Sport");
        list.add("Music");
        list.add("Travel");
        list.add("Game");
        list.add("Telen");
        add(list);
        //khi them vuot qua bound thi no se bị an di
        setVisible(true);
    }
}

public class Bai4 {

    public static void main(String[] args) {
        new Frame4();
    }
}

/*
package BaiThucHanhSo4;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;


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

public class Bai2 {

    public static void main(String[] args) {
        new Frame2();
    }
}


 */
