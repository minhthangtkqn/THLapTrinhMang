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
public class _2__13_uocChung_boiChung {

    private int a, b;

    public _2__13_uocChung_boiChung() {
        nhap();
        ketQua();
    }

    public _2__13_uocChung_boiChung(int a, int b) {
        this.a = a;
        this.b = b;
        ketQua();
    }

    private void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------------------");
        System.out.println("CHUONG TRINH TIM UCLN VA BCNN CUA 2 SO A VA B");

        System.out.println("Nhap gia tri a: ");
        a = scanner.nextInt();

        System.out.println("Nhap gia tri b: ");
        b = scanner.nextInt();
    }

    public void ketQua() {

        int BCNN = a * b;

        int tmpA = a, tmpB = b;

        int tmp = tmpB % tmpA;

        while (tmp != 0) {
            tmp = tmpA % tmpB;
            tmpA = tmpB;
            tmpB = tmp;
        }

        int UCLN = tmpA;

        BCNN = BCNN / UCLN;

        System.out.println("\nUoc chung lon nhat cua " + a + " va " + b + " la: " + UCLN);
        System.out.println("Boi chung nho nhat cua " + a + " va " + b + " la: " + BCNN);
    }
}
