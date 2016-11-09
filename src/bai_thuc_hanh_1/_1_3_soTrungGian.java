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
public class _1_3_soTrungGian {

    private int a, b, c;

    public _1_3_soTrungGian(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        ketQua();
    }

    public void ketQua() {
        int trungGian;
        
        trungGian = Integer.max(a, b);
        if(c > trungGian){
            System.out.println("So trung gian la: " + trungGian);
        }else if(c < trungGian){
            System.out.println("So trung gian la: " + Integer.max(c, Integer.min(a, b)));
        }
    }
}
