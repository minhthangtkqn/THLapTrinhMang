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
public class _2_4_giaiThuaChanLe {

    private int n;

    public _2_4_giaiThuaChanLe(int n) {
        this.n = n;
        ketQua();
    }

    public void ketQua() {
        int ket_qua = 1;
        if (n % 2 == 0) {
            for (int i = 2; i <= n; i += 2) {
                ket_qua *= i;
            }
        } else {
            for (int i = 1; i <= n; i += 2) {
                ket_qua *= i;
            }
        }
        System.out.println("Giai thua cua " + this.n + " la: " + ket_qua);
    }
}
