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

class _4_2_Frame2 extends Frame {

    public _4_2_Frame2() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        _4_2_Frame2 f = new _4_2_Frame2();
        f.setTitle("Hello");
        f.setSize(400, 300);
        
        f.setLocationRelativeTo(null);
        f.setLayout(new FlowLayout());
        f.add(new Label("Enter your name"));
        f.add(new TextField("Your name here"));
        f.add(new TextArea(5, 30));
        f.setVisible(true);
    }
}
