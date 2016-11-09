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

    private double height;

    public Rectangle(double height, double width) {
        super(width);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }
}

public class _2_1_Shape {

    public static void main(String[] args) {
        Square s = new Square(100);
        System.out.println("s.width = " + s.getWidth());
        Rectangle r = new Rectangle(50, 25);
        System.out.println("r.width = " + r.getWidth());
        System.out.println("r.height = " + r.getHeight());
    }
}
