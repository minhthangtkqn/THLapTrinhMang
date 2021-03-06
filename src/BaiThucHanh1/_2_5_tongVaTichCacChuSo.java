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
public class _2_5_tongVaTichCacChuSo {

    private int n;

    public _2_5_tongVaTichCacChuSo() {
        nhap();
        ketQua();
    }

    public _2_5_tongVaTichCacChuSo(int n) {
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
        int tong = 0;
        int tich = 1;
        if (n < 10) {
            tong = n;
            tich = n;
        } else {
            while (n / 10 != 0) {
                tong += n % 10;
                tich *= n % 10;
                n /= 10;
            }
            tong += n;
            tich *= n;
        }

        System.out.println("Tong cac chu so la: " + tong);
        System.out.println("Tich cac chu so la: " + tich);
    }
}
