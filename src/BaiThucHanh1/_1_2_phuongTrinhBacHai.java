/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh1;

import java.util.Scanner;

/**
 *
 * @author TLDs
 */
public class _1_2_phuongTrinhBacHai {

    private double a, b, c;

    public _1_2_phuongTrinhBacHai() {
        nhap();
        giaiPT();
    }

    public _1_2_phuongTrinhBacHai(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        giaiPT();
    }
    
    private void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap gia tri a: ");
        a = scanner.nextDouble();

        System.out.println("Nhap gia tri b: ");
        b = scanner.nextDouble();

        System.out.println("Nhap gia tri c: ");
        c = scanner.nextDouble();
    }

    public void giaiPT() {
        if (a == 0) {
            //giai phuong trinh bac nhat bx + c = 0
            new _1_1_phuongTrinhBacNhat(b, c);
        } else {
            double delta = (b * b) - (4 * a * c);
            if (delta < 0) {
                System.out.println("Phuong trinh vo nghiem");
            } else if (delta == 0) {
                System.out.println("Phuong trinh co nghiem kep: " + (-b / (2 * a)));
            } else if (delta > 0) {
                System.out.println("Phuong trinh co 2 nghiem");
                System.out.println("Nghiem thu nhat la: " + (-b + Math.sqrt(delta)) / (2 * a));
                System.out.println("Nghiem thu nhat la: " + (-b - Math.sqrt(delta)) / (2 * a));
            }
        }
    }

}
