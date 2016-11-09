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
public class _2__12_kiemTraFibonacci {

    private int n;

    public _2__12_kiemTraFibonacci(int n) {
        this.n = n;
        ketQua();
    }

    public void ketQua() {

        int f1 = 0;
        int f2 = 1;

        if (n == f1 || n == f2) {
            System.out.print(n + " thuoc day so Fibonacci");
            return;
        }

        int tmp;

        do {
            tmp = f1 + f2;
            if (tmp == n) {
                System.out.println(n + " thuoc day so Fibonacci");
                return;
            }

            f1 = f2;
            f2 = tmp;

        } while (tmp < n);

        System.out.println(n + " khong thuoc day so Fibonacci");
    }
}
