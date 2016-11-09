/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_2;

import java.awt.Point;

/**
 *
 * @author TLDs
 */
interface Figure_7 {

    public void move(Point p) throws Exception;

    public void draw() throws Exception;

    public double area() throws Exception;
    public double PI = 3.14159;
}

abstract class Shape_7 implements Figure_7 {

    private Point origin;

    public Point getOrigin() {
        return origin;
    }

    public Shape_7() {
        origin = new Point(0, 0);
    }

    public Shape_7(int x, int y) {
        origin = new Point(x, y);
    }

    public Shape_7(Point o) {
        origin = o;
    }

    public void move(Point p) {
        origin = p;
    }
}

public class _2_7_Circle extends Shape_7 {

    double radius;

    public _2_7_Circle(double rad) {
        super();
        radius = rad;
    }

    public _2_7_Circle(int x, int y, double rad) {
        super(x, y);
        radius = rad;
    }

    public _2_7_Circle(Point o, double rad) {
        super(o);
        radius = rad;
    }

    public double area() {
        return PI * radius * radius;
    }

    public void draw() {
        System.out.println("Circle@" + getOrigin().toString() + ", rad = " + radius);
    }

    static public void main(String argv[]) {
        _2_7_Circle circle = new _2_7_Circle(2.0);
        circle.draw();
        circle.move(new Point(1, 1));
        circle.draw();
        System.out.println("circle area = " + circle.area());
    }
}
