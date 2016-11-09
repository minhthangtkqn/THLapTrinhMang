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

class _4_1_Frame1 extends Frame {

    public _4_1_Frame1() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        _4_1_Frame1 f = new _4_1_Frame1();
        f.setTitle("Hello");
        f.setBounds(300, 200, 200, 200);
        f.setLayout(new FlowLayout());
        f.add(new Button("OK"));
        f.add(new Button("Cancel"));
        f.setVisible(true);
    }
}
