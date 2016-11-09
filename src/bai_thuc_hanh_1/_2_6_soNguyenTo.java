/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_1;

import java.math.*;
import java.util.*;

/**
 *
 * @author TLDs
 */
public class _2_6_soNguyenTo {

    private BigInteger N;

    public _2_6_soNguyenTo() {
        nhap();
        if (ketQua()) {
            System.out.println(N + " la so nguyen to!");
        } else {
            System.out.println(N + " khong phai so nguyen to!");
        }
    }

    private void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap gia tri N: ");
        N = new BigInteger(scanner.nextLine());
    }

    public boolean ketQua() {
        BigInteger n2 = BigInteger.valueOf(2);

        if (N.compareTo(n2) == 0) {
            return true;
        }

        BigInteger[] arr = N.divideAndRemainder(n2);

        if (arr[1].equals(BigInteger.valueOf(0))) {
            return false;
        }

        long i = 3;
        while (N.compareTo(BigInteger.valueOf(i * i)) == 1) {
            BigInteger[] arr2 = N.divideAndRemainder(BigInteger.valueOf(i));
            if (arr2[1].equals(BigInteger.ZERO)) {
                return false;
            }
            i += 2;
        };
        return true;
    }
}
