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

class _4_4_Frame4 extends Frame {

    public _4_4_Frame4() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        _4_4_Frame4 f = new _4_4_Frame4();
        f.setTitle("Hello");
        
        f.setSize(400, 300);
        f.setLocationRelativeTo(null);
        
        f.setLayout(new FlowLayout());

        Choice ch = new Choice();
        ch.addItem("Sport");
        ch.addItem("Music");
        ch.addItem("Travel");
        ch.addItem("1");
        ch.addItem("2");
        ch.addItem("3");
        f.add(ch);
        List list = new List(3, false);
        list.add("Sport");
        list.add("Music");
        list.add("Travel");
        list.add("Game");
        list.add("Telen");
        f.add(list);
        f.setVisible(true);
    }
}
