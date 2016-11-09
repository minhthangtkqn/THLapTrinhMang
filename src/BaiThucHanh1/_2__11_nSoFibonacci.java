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
public class _2__11_nSoFibonacci {

    private int n;

    public _2__11_nSoFibonacci(int n) {
        this.n = n;
        ketQua();
    }

    public void ketQua() {
        System.out.print("Danh sach " + n + " so Fibonacci dau tien la: ");

        for (int i = 0; i < n; i++) {
            System.out.print("  " + Fibonacci(i));
        }
    }

    private int Fibonacci(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return Fibonacci(i - 1) + Fibonacci(i - 2);
    }
}
