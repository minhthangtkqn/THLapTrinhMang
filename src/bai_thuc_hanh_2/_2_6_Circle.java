/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_2;

/**
 *
 * @author TLDs
 */
public class _2_6_Circle extends Shape_6 {

    double radius;

    public _2_6_Circle(double rad) {
        super();
        radius = rad;
    }

    public _2_6_Circle(int x, int y, double rad) {
        super(x, y);
        radius = rad;
    }

    public _2_6_Circle(Point_6 o, double rad) {
        super(o);
        radius = rad;
    }

    public void draw() {
        System.out.println("Circle@" + getOrigin().toString() + ", rad = " + radius);
    }

    static public void main(String argv[]) {
        _2_6_Circle circle = new _2_6_Circle(1.0);
        circle.draw();
    }
}

class Point_6 {

    int _x;
    int _y;

    public Point_6(int x, int y) {
        _x = x;
        _y = y;
    }

    public String toString() {
        return "(" + _x + "," + _y + ")";
    }
}

abstract class Shape_6 {

    private Point_6 _origin;

    public Point_6 getOrigin() {
        return _origin;
    }

    public Shape_6() {
        _origin = new Point_6(0, 0);
    }

    public Shape_6(int x, int y) {
        _origin = new Point_6(x, y);
    }

    public Shape_6(Point_6 o) {
        _origin = o;
    }

    abstract public void draw();
}
