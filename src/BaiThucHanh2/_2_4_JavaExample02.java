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
public class _2_4_JavaExample02 {

    public static void main(String args[]) {
        Box obj1 = new Box();
        Box obj2 = new Box(3, 4, 5);
        Box obj3 = new Box(3);
        Box obj4 = new Box(obj2);
        System.out.println(">> The tich 1 = " + obj1.volumeBox());
        System.out.println(">> The tich 2 = " + obj2.volumeBox());
        System.out.println(">> The tich 3 = " + obj3.volumeBox());
        System.out.println(">> The tich 4 = " + obj4.volumeBox());
    }

}

class Box {

    int width, height, depth;

    Box() {
        width = 0;
        height = 0;
        depth = 0;
    }

    Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    Box(int a) {
        width = height = depth = a;
    }

    Box(Box obj) {
        width = obj.width;
        height = obj.height;
        depth = obj.depth;
    }

    public int volumeBox() {
        return width * height * depth;
    }
}
