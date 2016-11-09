/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh4;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

/**
 * Tạo Menu giao diện chương trình
 *
 * @author TLDs
 */
class Menudemo extends Frame {

    public Menudemo(String title) {
        super(title);
        setBounds(300, 200, 200, 200);
        //menubar
        MenuBar mb = new MenuBar();
        setMenuBar(mb);
        //menu File
        Menu file = new Menu("File");
        file.add(new MenuItem("New"));
        file.add(new MenuItem("Open"));
        file.add(new MenuItem("Save"));
        file.add(new MenuItem("New"));
        file.add(new MenuItem(" "));
        file.add(new MenuItem("Exit"));
        mb.add(file);
        //menu Edit
        Menu edit = new Menu("Edit");
        edit.add(new MenuItem("Copy"));
        edit.add(new MenuItem("Cut"));
        edit.add(new MenuItem("Paste"));
        edit.add(new MenuItem(" "));
        edit.add(new CheckboxMenuItem("Protected"));
        mb.add(edit);
        //menu Option
        Menu sub = new Menu("Option");
        sub.add(new MenuItem("First"));
        sub.add(new MenuItem("Second"));
        sub.add(new MenuItem("Third"));
        edit.add(sub);

        setVisible(true);
    }
}

public class _4_5_Menu {
    public static void main(String[] args) {
        new Menudemo("MENU");
    }
}
