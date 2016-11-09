/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh4;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;

/**
 * Tạo frame chứa Choice va List
 *
 * @author TLDs
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

public class _4_4_Choice {

    public static void main(String[] args) {
        new Frame4();
    }
}
