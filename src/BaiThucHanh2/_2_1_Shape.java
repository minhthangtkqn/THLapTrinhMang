package BaiThucHanh2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TLDs
 */
class Point_1 {

    private double x, y;

    public Point_1(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}

class Square {

    private double width;

    public Square(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

}

class Rectangle extends Square {

    private double length;

    public Rectangle(double length, double width) {
        super(width);
        this.length = length;
    }

    public double getLength() {
        return this.length;
    }
}

class _2_1_Shape {

    public static void main(String[] args) {
        Square s = new Square(100);
        System.out.println("s.width = " + s.getWidth());
        Rectangle r = new Rectangle(50, 25);
        System.out.println("r.width = " + r.getWidth());
        System.out.println("r.length = " + r.getLength());
    }
}
