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
public class _2_5_JavaExample03 {

    public static void main(String args[]) {
        SubBox obj1 = new SubBox(2, 3, 4, 5);
        System.out.println(">> The tich 1 = " + obj1.volumeBox());
        System.out.println(">> Trong luong = " + obj1.weight);
    }
}

class Box_2 {

    int width, height, depth;

    Box_2() {
        width = 0;
        height = 0;
        depth = 0;
    }

    Box_2(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int volumeBox() {
        return width * height * depth;
    }
}

class SubBox extends Box {

    int weight;

    SubBox(int width, int height, int depth, int weight) {
        /* Cach 1
            this.width = width;
            this.height = height;
            this.depth = depth;
            this.weight = weight;
         */
        
        /* Cach 2 */
        super(width, height, depth);
        this.weight = weight;
    }

    public int volumeBox() {
        return width * height * depth;
    }
}
