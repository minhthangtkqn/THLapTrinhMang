/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author TLDs
 */
public class _2_9_inSoNguyenTo {

    private BigInteger N;

    public _2_9_inSoNguyenTo() {
        nhap();
        ketQua();
    }

    private void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap gia tri N: ");
        N = new BigInteger(scanner.nextLine());
    }

    public void ketQua() {
        System.out.println("Danh sach cac so nguyen to <= " + N + " la: ");

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(N) == -1; i = i.add(BigInteger.ONE)) {
            if (kiemTraNguyenTo(i)) {
                System.out.println(i + "  ");
            }
        }
        System.out.println("\n----------------------");
    }

    private boolean kiemTraNguyenTo(BigInteger X) {
        BigInteger n2 = BigInteger.valueOf(2);

        if (X.compareTo(n2) == 0) {
            return true;
        }

        BigInteger[] arr = X.divideAndRemainder(n2);

        if (arr[1].equals(BigInteger.valueOf(0))) {
            return false;
        }

        long i = 3;
        while (X.compareTo(BigInteger.valueOf(i * i)) == 1) {
            BigInteger[] arr2 = X.divideAndRemainder(BigInteger.valueOf(i));
            if (arr2[1].equals(BigInteger.ZERO)) {
                return false;
            }
            i += 2;
        };
        return true;
    }
}
