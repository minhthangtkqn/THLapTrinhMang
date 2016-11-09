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
interface Figure {

    public void move(Point p) throws Exception;

    public void draw() throws Exception;

    public double area() throws Exception;
    public double PI = 3.14159;
}

abstract class Shape2 implements Figure {

    private Point origin;

    public Point getOrigin() {
        return origin;
    }

    public Shape2() {
        origin = new Point(0, 0);
    }

    public Shape2(int x, int y) {
        origin = new Point(x, y);
    }

    public Shape2(Point o) {
        origin = o;
    }

    public void move(Point p) {
        origin = p;
    }
}
//Lớp Circe kế thừa từ lớp Shape. 
class Circle2 extends Shape2 {

    double radius;

    public Circle2(double rad) {
        super();
        radius = rad;
    }

    public Circle2(int x, int y, double rad) {
        super(x, y);
        radius = rad;
    }

    public Circle2(Point o, double rad) {
        super(o);
        radius = rad;
    }

    public double area() {
        return PI * radius * radius;
    }

    public void draw() {
        System.out.println("Circle@" + getOrigin().toString() + ", rad = " + radius);
    }

}

public class _2_7_Circle {

    static public void main(String argv[]) {
        Circle2 circle = new Circle2(2.0);
        circle.draw();
        circle.move(new Point(1, 1));
        circle.draw();
        System.out.println("circle area = " + circle.area());
    }
}
