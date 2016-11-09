/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh2;

import java.awt.Point;

/**
 *
 * @author TLDs
 */
class Rectangle_2 {

    public int width = 0;
    public int length = 0;

    public Point origin;

    public Rectangle_2() {
        origin = new Point(0, 0);
    }

    public Rectangle_2(Point origin) {
        this.origin = origin;
    }

    public Rectangle_2(int width, int length) {
        this(new Point(0, 0), width, length);
    }

    public Rectangle_2(Point point, int w, int len) {
        this.origin = point;
        this.width = w;
        this.length = len;
    }

    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    public int area() {
        return width * length;
    }

}

public class _2_2_CreateObjectDemo {

    public static void main(String[] args) {
        Point ori = new Point(12, 9);

        Rectangle_2 rectangle1 = new Rectangle_2(ori, 10, 20);

        Rectangle_2 rectangle2 = new Rectangle_2(12, 17);

        System.out.println("width  1: " + rectangle1.width);
        System.out.println("length 1: " + rectangle1.length);
        System.out.println("dien tich 1: " + rectangle1.area());

        rectangle2.origin = ori;

        System.out.println("rec 2 - X" + rectangle2.origin.x);
        System.out.println("rec 2 - Y" + rectangle2.origin.y);

        System.out.println("chuyen vi tri");
        rectangle2.move(10, 10);

        System.out.println("rec 2 - X" + rectangle2.origin.x);
        System.out.println("rec 2 - Y" + rectangle2.origin.y);
    }
}
