/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh1;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import java.util.Scanner;

/**
 *
 * @author TLDs
 */
public class _1_4_tinhTienKaraoke {

    private int truoc;
    private int sau;

    final int giaRe = 45000;
    final int giaDat = 60000;

    public _1_4_tinhTienKaraoke() {
        nhap();
        thanhToan();
    }

    private void nhap() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhap gio vao hat: ");
            truoc = scanner.nextInt();
        } while (truoc < 7 || truoc > 23);

        do {
            System.out.println("Nhap gio hat xong: ");
            sau = scanner.nextInt();
        } while (sau <= truoc || sau < 8 || sau > 24);
    }

    private void thanhToan() {
        if (sau <= 18) {
            System.out.println("Quy khach phai thanh toan " + giaRe * (sau - truoc) + "  VND");
        } else {
            System.out.println("Quy khach phai thanh toan " + (giaRe * (18 - truoc) + giaDat * (sau - 18)) + "VND");
        }
    }
}
