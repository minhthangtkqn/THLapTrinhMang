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
public class _1_3_soTrungGian {

    private int a, b, c;

    public _1_3_soTrungGian() {
        nhap();
        ketQua();
    }

    public _1_3_soTrungGian(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        ketQua();
    }

    private void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap gia tri a: ");
        a = scanner.nextInt();

        System.out.println("Nhap gia tri b: ");
        b = scanner.nextInt();

        System.out.println("Nhap gia tri c: ");
        c = scanner.nextInt();
    }

    public void ketQua() {
        int trungGian;

        trungGian = Integer.max(a, b);
        if (c > trungGian) {
            System.out.println("So trung gian la: " + trungGian);
        } else if (c < trungGian) {
            System.out.println("So trung gian la: " + Integer.max(c, Integer.min(a, b)));
        }
    }
}
