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
public class _2_7_soChinhPhuong {

    private int n;

    public _2_7_soChinhPhuong() {
        nhap();
        ketQua();
    }

    public _2_7_soChinhPhuong(int n) {
        this.n = n;
        ketQua();
    }

    private void nhap() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhap N: ");
            n = scanner.nextInt();
        } while (n <= 0);
    }

    public void ketQua() {
        double A = (int) Math.sqrt(n);
        double B = Math.sqrt(n);
        if (A == B) {
            System.out.println(n + " la so chinh phuong!");
            return;
        }
        System.out.println(n + " khong phai so chinh phuong!");
    }
}
