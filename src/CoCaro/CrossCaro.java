/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoCaro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author TLDs
 */
public class CrossCaro extends JFrame implements MouseListener {

    public static void main(String[] args) {
        new CrossCaro();
    }

    int n, size, idx, idy;

    ArrayList<Point> daDanh;

    public CrossCaro() {
        this.n = 10;    //so luong hang/cot
        this.size = 30; //kich thuoc 1 o
        this.idx = 50;  //vien` ngoai
        this.idy = 50;  //vien` ngoai

        this.setSize(n * size + idx * 2, n * size + idy * 2);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addMouseListener(this);

        this.repaint();

        daDanh = new ArrayList<Point>();

    }

    public void paint(Graphics g) {
        for (int i = 0; i <= n; i++) {
            g.drawLine(idx, idy + i * size, idx + n * size, idy + i * size);
            g.drawLine(idx + i * size, idy, idx + i * size, idy + n * size);
        }

        for (int i = 0; i < daDanh.size(); i++) {

            String chu = "x";
            g.setFont(new Font("Arial", Font.BOLD, size));
            g.setColor(Color.blue);
            int x = daDanh.get(i).x * size + idx + size / 4;
            int y = daDanh.get(i).y * size + idy + size * 3 / 4;
            if (i % 2 != 0) {
                chu = "o";
                g.setColor(Color.red);
            }
            g.drawString(chu, x, y);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int x = (e.getX() - idx) / size;
        int y = (e.getY() - idy) / size;

        if (x < 0 || x >= n || y < 0 || y >= n) {
            return;
        }
        for(int i=0; i<daDanh.size(); i++){
            if(daDanh.get(i).x == x && daDanh.get(i).y == y){
                return;
            }
        }
        daDanh.add(new Point(x, y));

        this.repaint();

        System.out.println("CLicked");
        System.out.println("x = " + x + "y = " + y);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
