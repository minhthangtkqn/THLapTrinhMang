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
class Rectangle2 {

    public int width = 0;
    public int height = 0;
    public Point origin;

    // four constructors
    public Rectangle2() {
        origin = new Point(0, 0);
    }

    public Rectangle2(Point p) {
        origin = p;
    }

    public Rectangle2(int w, int h) {
        this(new Point(0, 0), w, h);
    }

    public Rectangle2(Point p, int w, int h) {
        origin = p;
        width = w;
        height = h;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    // a method for computing the area of the rectangle
    public int area() {
        return width * height;
    }
}

public class _2_2_CreateObjectDemo {

    public static void main(String[] args) {
        // create a point object and two rectangle objects
        Point origin_one = new Point(23, 94);
        Rectangle2 rect_one = new Rectangle2(origin_one, 100, 200);
        Rectangle2 rect_two = new Rectangle2(50, 100);
        // display rect_one's width, height, and area System.out.println("Width of rect_one: " + rect_one.width); System.out.println("Height of rect_one: " + rect_one.height); System.out.println("Area of rect_one: " + rect_one.area());
        // set rect_two's position
        rect_two.origin = origin_one;
        // display rect_two's position
        System.out.println("X Position of rect_two: " + rect_two.origin.x);
        System.out.println("Y Position of rect_two: " + rect_two.origin.y); // move rect_two and display its new position
        rect_two.move(40, 72);
        System.out.println("X Position of rect_two: " + rect_two.origin.x);
        System.out.println("Y Position of rect_two: " + rect_two.origin.y);
    }
}

