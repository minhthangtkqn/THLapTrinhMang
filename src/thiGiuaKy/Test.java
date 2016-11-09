/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiGiuaKy;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author TLDs
 */
public class Test {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Hoang Minh Thang");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension size_panel_1 = new Dimension(900, 600);
        fr.getContentPane().setPreferredSize(size_panel_1);
        fr.getContentPane().add(new JButton("abc"));
        
        fr.pack();
        //đưa cửa sổ ra chính giữa màn hình ngay khi khởi động
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
}
