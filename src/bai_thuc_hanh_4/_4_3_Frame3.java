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

class _4_3_Frame3 extends Frame {
    
    public _4_3_Frame3() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        _4_3_Frame3 f = new _4_3_Frame3();
        f.setTitle("Hello");
        
        f.setSize(400, 300);
        f.setLocationRelativeTo(null);
        
        f.setLayout(new FlowLayout());

        f.add(new Checkbox("Sport"));
        f.add(new Checkbox("Music"));
        f.add(new Checkbox("Travel"));
        
        CheckboxGroup cg = new CheckboxGroup();
        f.add(new Checkbox("Male", cg, false));
        f.add(new Checkbox("Female", cg, true));
        f.setVisible(true);
    }
}
