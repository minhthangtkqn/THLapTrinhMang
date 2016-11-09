/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoCaro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author TLDs
 */
public class CrossCaroTest extends JFrame implements MouseListener {

    public static void main(String[] args) {
        new CrossCaroTest();
    }

    int n, boxSize, dx, dy;

    ArrayList<Point> Checked;

    public CrossCaroTest() throws HeadlessException {
        this.n = 10;
        this.boxSize = 40;
        this.dx = 50;
        this.dy = 50;

        this.setSize(n * boxSize + dx * 2, n * boxSize + dy * 2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);

        this.addMouseListener(this);

        this.repaint();

        Checked = new ArrayList<>();
    }

    public void paint(Graphics g) {
        for (int i = 0; i <= n; i++) {
            g.drawLine(dx, dy + boxSize * i, dx + n * boxSize, dy + boxSize * i);
            g.drawLine(dx + boxSize * i, dy, dx + i * boxSize, dy + boxSize * n);
        }

        for (int i = 0; i < Checked.size(); i++) {
            String chu = "x";
            g.setFont(new Font("Arial", Font.BOLD, boxSize));
            g.setColor(Color.RED);
            int xChu = dx + Checked.get(i).x * boxSize + boxSize / 4;
            int yChu = dy + Checked.get(i).y * boxSize + 3 * boxSize / 4;

            if (i % 2 == 0) {
                chu = "o";
                g.setColor(Color.BLUE);
            }

            g.drawString(chu, xChu, yChu);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int xClick = (e.getX() - dx) / boxSize;
        int yClick = (e.getY() - dy) / boxSize;

        //kiểm tra có click ngoài khu vực đánh cờ hay không
        if (e.getX() < dx || e.getY() < dy || e.getX() >= dx + n * boxSize || e.getY() >= dy + n * boxSize) {
            System.out.println("Đánh trật rồi cha, mấy ô trống ở kia kìa! -_-\"");
            return;
        }

        //kiểm tra có đánh trùng hay không
        for (int i = 0; i < Checked.size(); i++) {
            if (Checked.get(i).x == xClick && Checked.get(i).y == yClick) {
                System.out.println("Ô này đã đánh rồi, chọn ô khác đi -_-\"");
                return;
            }
        }

        Checked.add(new Point(xClick, yClick));

        repaint();

        System.out.print("Bạn đã click vào ô: ");
        System.out.print("x = " + xClick + " - ");
        System.out.println("y = " + yClick);
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
