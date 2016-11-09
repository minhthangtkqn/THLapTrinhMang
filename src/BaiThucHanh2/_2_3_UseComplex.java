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
public class _2_3_UseComplex {

    public static void main(String[] args) {
        Complex c1 = new Complex(2.0, 5.0); 
        Complex c2 = new Complex(-3.1, -6.3);
        c1.add(c2);
        c1.print();
    }
}

class Complex {

    private double re, im;

    Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public void add(Complex c) {
        re += c.getRe();
        im += c.getIm();
    }

    public void subtract(Complex c) {
        re -= c.getRe();
        im -= c.getIm();
    }

    public void print() {
        System.out.println("(" + re + "," + im + ")");
    }
}
