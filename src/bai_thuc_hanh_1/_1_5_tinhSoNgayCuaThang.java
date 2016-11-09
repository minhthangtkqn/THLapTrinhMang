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
public class _1_5_tinhSoNgayCuaThang {

    private int nam, thang, soNgay;
    private boolean nhuan;

    public _1_5_tinhSoNgayCuaThang() {
    }

    public _1_5_tinhSoNgayCuaThang(int nam, int thang) {
        this.nam = nam;
        this.thang = thang;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhap nam: ");
            nam = scanner.nextInt();
        } while (nam < 0);
        do {
            System.out.println("Nhap thang: ");
            thang = scanner.nextInt();
        } while (thang < 1 || thang > 12);

    }

    public void ketQua() {
        //kiem tra nam nhuan
        if (nam % 4 == 0 && (nam % 100 != 0 || nam % 400 == 0)) {
            nhuan = true;
        } else {
            nhuan = false;
        }

        switch (thang) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Thang " + thang + " nam " + nam + " co " + 31 + " ngay");
                break;
            case 2:
                if (nhuan) {
                    System.out.println("Thang " + thang + " nam " + nam + " co " + 29 + " ngay");
                } else {
                    System.out.println("Thang " + thang + " nam " + nam + " co " + 28 + " ngay");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Thang " + thang + " nam " + nam + " co " + 30 + " ngay");
                break;
        }
    }
}
