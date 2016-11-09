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
class Box2 {

    int width, height, depth;

    public Box2() {
        width = 0;
        height = 0;
        depth = 0;
    }

    public Box2(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int volumeBox() {
        return width * height * depth;
    }
}

class SubBox extends Box2 {

    int weight;

    SubBox(int width, int height, int depth, int weight) {
        super(width, height, depth);
        this.weight = weight;
    }

    public int volumeBox() {
        return width * height * depth;
    }
}

public class _2_5_JavaExample03 {

    public static void main(String args[]) {
        SubBox obj1 = new SubBox(2, 3, 4, 5);
        System.out.println(">> The tich 1 = " + obj1.volumeBox());
        System.out.println(">> Trong luong = " + obj1.weight);
    }
}
