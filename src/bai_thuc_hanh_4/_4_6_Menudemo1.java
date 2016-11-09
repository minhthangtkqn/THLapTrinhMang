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
import java.awt.event.*;
import javax.swing.JToolBar;

class _4_6_Menudemo1 extends Frame implements MouseListener {

    _4_6_Menudemo1 p;

    _4_6_Menudemo1(String title) {
//        super(title);
        setBounds(300, 200, 200, 200);
        p = new _4_6_Menudemo1("Option");
        p = new _4_6_Menudemo1("Copy");
        p = new _4_6_Menudemo1("Cut");
        p.add(new JToolBar.Separator());
        p.add((PopupMenu) new MenuItem("Paste"));
        add(p);
        addMouseListener(this);
    }

    public void show(_4_6_Menudemo1 menuDemo1, int x, int y) {
        System.out.println("X Location: " + x);
        System.out.println("Y Location: " + y);
    }

    public void mouseEntered(MouseEvent m) {
    }

    public void mouseExited(MouseEvent m) {
    }

    public void mouseClicked(MouseEvent m) {
        p.show(this, m.getX(), m.getY());
    }

    public void mouseReleased(MouseEvent m) {
    }

    public void mousePressed(MouseEvent m) {
    }

    public static void main(String args[]) {
        _4_6_Menudemo1 f = new _4_6_Menudemo1("List Demo");
        f.setVisible(true);
    }
}
