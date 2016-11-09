/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh5;

import BaiThucHanh1._2__13_uocChung_boiChung;
import java.util.Scanner;

/**
 *
 * @author TLDs
 */
class Common extends Thread {

    int a, b;

    public Common(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        new _2__13_uocChung_boiChung(a, b);
    }
}

public class Bai1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Moi nhap a: ");
        int a = scanner.nextInt();
        System.out.print("Moi nhap b: ");
        int b = scanner.nextInt();

        Common cm = new Common(a, b);
        cm.start();
    }
}
