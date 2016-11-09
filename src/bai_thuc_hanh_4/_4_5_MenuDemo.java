/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_4;

/**
 *
 * @author TLDs
 */
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class _4_5_MenuDemo extends Frame {

    public _4_5_MenuDemo(String title) {
        super(title);
        setBackground(Color.gray);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setSize(400, 300);
        setLocationRelativeTo(null);

        MenuBar mb = new MenuBar();
        setMenuBar(mb);
        Menu file = new Menu("File");
        file.add(new MenuItem("New"));
        file.add(new MenuItem("Open"));
        file.add(new MenuItem("Save"));
        file.add(new MenuItem("New"));
        file.add(new MenuItem(" "));

        file.add(new MenuItem("Exit"));
        mb.add(file);

        Menu edit = new Menu("Edit");
        edit.add(new MenuItem("Copy"));
        edit.add(new MenuItem("Cut"));
        edit.add(new MenuItem("Paste"));
        edit.add(new MenuItem(" "));

        Menu sub = new Menu("Option");
        sub.add(new MenuItem("First"));
        sub.add(new MenuItem("Second"));
        sub.add(new MenuItem("Third"));
        edit.add(sub);

        edit.add(new CheckboxMenuItem("Protected"));
        mb.add(edit);
        show();
    }

    public static void main(String args[]) {
        _4_5_MenuDemo f1 = new _4_5_MenuDemo("Menu Demo");
    }
}
