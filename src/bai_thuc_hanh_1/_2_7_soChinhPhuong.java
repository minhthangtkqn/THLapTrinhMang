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
public class _2_7_soChinhPhuong {

    private double n;

    public _2_7_soChinhPhuong(double n) {
        this.n = n;
        ketQua();
    }

    public void ketQua() {
        double A = (int) Math.sqrt(n);
        double B = Math.sqrt(n);
        if (A == B) {
            System.out.println(n + " la so chinh phuong!");
            return;
        }
        System.out.println(n + " khong phai so chinh phuong!");
    }
}
