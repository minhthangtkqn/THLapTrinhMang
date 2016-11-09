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
public class _2_8_soDoiXung {

    private int n;

    public _2_8_soDoiXung() {
        nhap();
        ketQua();
    }

    public _2_8_soDoiXung(int n) {
        this.n = n;
        ketQua();
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("CHUONG TRINH KIEM TRA SO DOI XUNG");

        do {
            System.out.print("Nhap so nguyen duong N: ");
            n = scanner.nextInt();
        } while (n <= 0);

    }

    public void ketQua() {
        int tmp = n;
        int reserve = 0;
        boolean doiXung = false;

        while (tmp > 0) {
            reserve = reserve * 10 + tmp % 10;
            tmp /= 10;
        }

        if (reserve == n) {
            doiXung = true;
        }
        if (doiXung) {
            System.out.println(n + " la so doi xung");
        } else {
            System.out.println(n + " khong phai so doi xung");
        }
    }
}
