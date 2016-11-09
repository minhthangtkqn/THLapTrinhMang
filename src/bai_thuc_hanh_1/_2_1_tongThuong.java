/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author TLDs
 */
public class _2_1_tongThuong {

    private int n;

    public _2_1_tongThuong() {
        nhap();
        ketQua();
    }

    public _2_1_tongThuong(int n) {
        this.n = n;
        ketQua();
    }

    private void nhap() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhap N: ");
            n = scanner.nextInt();
        } while (n < 0);
    }

    private void ketQua() {

        //Tinh Tong
        double S = 0;
        for (int i = 1; i <= n; i++) {
            S += (1.0 / i);
        }

        //Xuat gia tri Tong
        DecimalFormat df = new DecimalFormat("####.##");
        System.out.println("Tong cac phan so la: " + df.format(S));
    }

}
