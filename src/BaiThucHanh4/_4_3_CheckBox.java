/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh4;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;

/**
 * Tạo frame chứa Checkbox, Radio Button
 *
 * @author TLDs
 */
class Frame3 extends Frame {

    public Frame3() {
        setTitle("Hello");
        setBounds(300, 200, 200, 200);
        //cac component se tu sap xep lai khi resize Window
        setLayout(new FlowLayout());
        //Dua frame vao giua man hinh
        setLocationRelativeTo(null);
        //Them cac components
        add(new Checkbox("Sport"));
        add(new Checkbox("Music"));
        add(new Checkbox("Travel"));
        //Trong checkboxgroup chi co 1 checkbox co gia tri true (la chackbox gan gia tri sau cung
        CheckboxGroup cg = new CheckboxGroup();
        add(new Checkbox("Male", cg, true));
        add(new Checkbox("Female", cg, true));
        //khi them vuot qua bound thi no se bị an di
        setVisible(true);
    }
}

public class _4_3_CheckBox {

    public static void main(String[] args) {
        new Frame3();

    }
}