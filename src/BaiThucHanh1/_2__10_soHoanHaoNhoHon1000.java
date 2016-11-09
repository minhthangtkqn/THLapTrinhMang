/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh1;

/**
 *
 * @author TLDs
 */
public class _2__10_soHoanHaoNhoHon1000 {

    public _2__10_soHoanHaoNhoHon1000() {
        ketQua();
    }

    public void ketQua() {
        System.out.println("---------------------------");
        System.out.println("CHUONG TRINH IN RA CAC SO HOAN HAO < 1000");
        System.out.print("Danh sach cac so hoan hao < 1000 la: ");
        int S, tmp;
        for (int i = 2; i < 1000; i++) {
            S = 0;
            tmp = i / 2;
            while (tmp > 0) {
                if (i % tmp == 0) {
                    S += tmp;
                }
                tmp--;
            }
            if (S == i) {
                System.out.print(i + "  ");
            }
        }
    }
}
