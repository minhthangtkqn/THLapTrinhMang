/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh2;

/**
 *
 * @author TLDs
 */
class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

abstract class Shape {

    private Point origin;

    public Point getOrigin() {
        return origin;
    }

    public Shape() {
        origin = new Point(0, 0);
    }

    public Shape(int x, int y) {
        origin = new Point(x, y);
    }

    public Shape(Point o) {
        origin = o;
    }

    abstract public void draw();
}

class Circle extends Shape {

    double radius;

    public Circle(double rad) {
        super();
        radius = rad;
    }

    public Circle(int x, int y, double rad) {
        super(x, y);
        radius = rad;
    }

    public Circle(Point o, double rad) {
        super(o);
        radius = rad;
    }

    public void draw() {
        System.out.println("Circle@" + getOrigin().toString() + ", rad = " + radius);
    }

}

public class _2_6_Circle {

    static public void main(String argv[]) {
        Circle circle = new Circle(1.0);
        circle.draw();
    }
}
