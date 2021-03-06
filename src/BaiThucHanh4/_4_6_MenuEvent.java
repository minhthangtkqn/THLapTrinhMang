/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 *
 * @author TLDs
 */
class Menudemo2 extends Frame implements ActionListener {

    MenuItem exit, copy, cut, paste;
    Label choose;

    Menudemo2(String title) {
        super(title);
        setLocationRelativeTo(null);
        setSize(300, 300);

        //initialize menu
        MenuBar menubar = new MenuBar();
        setMenuBar(menubar);
        //menu Edit
        Menu edit = new Menu("Edit");
        copy = new MenuItem("Copy");
        edit.add(copy);
        cut = new MenuItem("Cut");
        edit.add(cut);
        paste = new MenuItem("Paste");
        edit.add(paste);
        menubar.add(edit);
        //menu File
        Menu file = new Menu("File");
        exit = new MenuItem("Exit");
        file.add(exit);
        menubar.add(file);
        for (int i = 0; i < menubar.getMenuCount(); i++) {
            for (int j = 0; j < menubar.getMenu(i).getItemCount(); j++) {
                menubar.getMenu(i).getItem(j).addActionListener(this);
            }
        }

        //initialize components
        choose = new Label("LUA CHON HIEN THI TAI DAY");
        add(choose);

        //window events
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.out.println("exit");
            System.exit(0);
        }
        if (e.getSource() == copy) {
            System.out.println("copy");
            choose.setText("copy");
        }
        if (e.getSource() == cut) {
            System.out.println("cut");
            choose.setText("cut");
        }
        if (e.getSource() == paste) {
            System.out.println("paste");
            choose.setText("paste");
        }

    }

}

public class _4_6_MenuEvent {
    public static void main(String args[]) {
        Menudemo2 f = new Menudemo2("MENU EVENT");
    }
}
