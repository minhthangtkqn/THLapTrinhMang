/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author TLDs
 */
public class _2_2_tongThuongGiaiThua {

    private int n;

    public _2_2_tongThuongGiaiThua() {
        nhap();
        ketQua();
    }

    public _2_2_tongThuongGiaiThua(int n) {
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

    public void ketQua() {
        double S = 15;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            S += Math.pow(-1, i) * (1.0 / fact);
        }
        DecimalFormat df = new DecimalFormat("####.##");
        System.out.println("Tong cac phan so la: " + df.format(S));
    }
}
