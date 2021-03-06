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
public class _2_4_giaiThuaChanLe {

    private int n;

    public _2_4_giaiThuaChanLe() {
        nhap();
        ketQua();
    }

    public _2_4_giaiThuaChanLe(int n) {
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
        System.out.println( this.n + "!! = " + ket_qua);
    }
}
