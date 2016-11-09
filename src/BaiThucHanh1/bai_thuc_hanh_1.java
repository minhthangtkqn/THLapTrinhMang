/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author TLDs
 */
public class bai_thuc_hanh_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean cont = true;
        while (cont) {
            System.out.println("Menu bai tap");

            System.out.println("\nPHAN I:CAU TRUC LUA CHON");
            System.out.println("1. Phương trinh bac 1");
            System.out.println("2. Phương trinh bac 2");
            System.out.println("3. Tim so trung gian");
            System.out.println("4. Tinh tien Karaoke");
            System.out.println("5. So ngay cua thang");

            System.out.println("\nPHAN II: CAU TRUC LAP");
            System.out.println("6. Tong cac thuong so");
            System.out.println("7. Tong cac thuong so (n!)");
            System.out.println("8. Tong cac thuong so (n!) le ");
            System.out.println("9. Giai thua chan le");
            System.out.println("10. Tong va tich cac chu so cua n");
            System.out.println("11. Kiem tra so nguyen to");
            System.out.println("12. Kiem tra so chinh phuong");
            System.out.println("13. Kiem tra so doi xung");
            System.out.println("14. In ra cac so nguyen to nho hon hoac bang N");
            System.out.println("15. In ra cac so hoan hao nho hon 1000");
            System.out.println("16. In ra N so Fibonacci dau tien");
            System.out.println("17. Kiem tra N co thuoc day so Fibonacci hay khong?");
            System.out.println("18. UCLN va BCNN cua 2 so A va B");

            System.out.println(" 0  Thoat chuong trinh");

            Scanner scanner = new Scanner(System.in);

            String select = scanner.next();

            switch (select) {
                case "1":
                    new _1_1_phuongTrinhBacNhat();
                    break;

                case "2":
                    new _1_2_phuongTrinhBacHai();
                    break;

                case "3":
                    new _1_3_soTrungGian();
                    break;

                case "4":
                    new _1_4_tinhTienKaraoke();
                    break;

                case "5":
                    new _1_5_tinhSoNgayCuaThang();
                    break;

                case "6":
                    new _2_1_tongThuong();
                    break;

                case "7":
                    new _2_2_tongThuongGiaiThua();
                    break;

                case "8":
                    new _2_3_tongThuongGiaiThuaLe();
                    break;

                case "9":
                    new _2_4_giaiThuaChanLe();
                    break;

                case "10":
                    new _2_5_tongVaTichCacChuSo();
                    break;

                case "11":
                    new _2_6_soNguyenTo();
                    break;

                case "12":
                    new _2_7_soChinhPhuong();
                    break;

                case "13":
                    new _2_8_soDoiXung();
                    break;

                case "14":
                    new _2_9_inSoNguyenTo();
                    break;
                    
                case "15":
                    new _2__10_soHoanHaoNhoHon1000();
                    break;

                case "16":
                    System.out.println("Nhap gia tri N: ");
                    new _2__11_nSoFibonacci(scanner.nextInt());
                    break;

                case "17":
                    System.out.println("Nhap gia tri N: ");
                    new _2__12_kiemTraFibonacci(scanner.nextInt());
                    break;

                case "18":
                    new _2__13_uocChung_boiChung();
                    break;
                    
                case "0":
                    cont = false;
                    System.out.println("GAME OVER");
                    return;

                default:
                    System.out.println("Khong co truong hop nay. \nVui long nhap lai");
                    break;
            }

            System.out.println("\nGÕ KÝ TỰ BẤT KỲ sau đó NHẤN ENTER để tiếp tục ...");
            scanner.next();
        }

    }

}
