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

    public _2_9_inSoNguyenTo(BigInteger N) {
        this.N = N;
        ketQua();
    }

    public void ketQua() {
        System.out.println("Danh sach cac so nguyen to <= " + N + " la: ");

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(N) == -1; i = i.add(BigInteger.ONE)) {
            if (new _2_6_soNguyenTo(N).ketQua()) {
                System.out.print(i + "  ");
            }
        }
        System.out.println("----------------------");
    }
}
