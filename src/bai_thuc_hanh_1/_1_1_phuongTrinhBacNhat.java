/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_1;

import java.util.Scanner;

/**
 *
 * @author TLDs
 */
public class _1_1_phuongTrinhBacNhat {

    private double a, b;

    public _1_1_phuongTrinhBacNhat(double a, double b) {
        this.a = a;
        this.b = b;
        giaiPT();
    }

    public void giaiPT() {
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phuong trinh co vo so nghiem");
            } else {
                System.out.println("Phuong trinh vo nghiem");
            }
        } else {
            System.out.println("Phuong trinh co nghiem duy nhat la: " + (-b / a));
        }
    }
}
