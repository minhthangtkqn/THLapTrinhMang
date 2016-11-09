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
public class _2_3_tongThuongGiaiThuaLe {

    private int n;

    public _2_3_tongThuongGiaiThuaLe(int n) {
        this.n = n;
        ketQua();
    }

    public void ketQua() {
        double S = 0;
        int giaiThua = 1;

        for (int i = 1; i <= n; i++) {
            giaiThua = giaiThua * (2 * i - 2) * (2 * i - 1);
            if (giaiThua == 0) {
                giaiThua = 1;
            }

            S += 1.0 / giaiThua;
        }

        DecimalFormat df = new DecimalFormat("####.##");
        System.out.println("Tong cac phan so la: " + df.format(S));
    }
}
