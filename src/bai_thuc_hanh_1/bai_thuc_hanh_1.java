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
                    System.out.print("Nhap gia tri a: ");
                    double a = scanner.nextDouble();
                    System.out.print("Nhap gia tri b: ");
                    double b = scanner.nextDouble();
                    new _1_1_phuongTrinhBacNhat(a, b);
                    break;

                case "2":
//                    System.out.print("Nhap gia tri a: ");
//                    a = scanner.nextDouble();
//                    System.out.print("Nhap gia tri b: ");
//                    double b = scanner.nextDouble();
                    new _1_2_phuongTrinhBacHai(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                    break;

                case "3":
                    new _1_3_soTrungGian();
                    break;

                case "4":
                    _1_4_tinhTienKaraoke tienKara = new _1_4_tinhTienKaraoke();
                    tienKara.nhap();
                    tienKara.thanhToan();
                    break;

                case "5":
                    _1_5_tinhSoNgayCuaThang soNgay = new _1_5_tinhSoNgayCuaThang();
                    soNgay.nhap();
                    soNgay.ketQua();
                    break;

//                case "6":
//                    _2_1_tongThuong tong = new _2_1_tongThuong();
//                    tong.nhap();
//                    tong.ketQua();
//                    break;
//                case "7":
//                    _2_2_tongThuongGiaiThua sum_factorial = new _2_2_tongThuongGiaiThua();
//                    break;
//                case "8":
//                    _2_3_tongThuongGiaiThuaLe tongThuongGiaiThuaLe = new _2_3_tongThuongGiaiThuaLe();
//                    break;
//
//                case "9":
//                    _2_4_giaiThuaChanLe giaiThuaChanLe = new _2_4_giaiThuaChanLe();
//                    giaiThuaChanLe.nhap();
//                    giaiThuaChanLe.ketQua();
//                    break;
//
//                case "10":
//                    _2_5_tongVaTichCacChuSo letter_sum = new _2_5_tongVaTichCacChuSo();
//                    letter_sum.nhap();
//                    letter_sum.ketQua();
//                    break;
//                case "11":
//                    System.out.print("Nhap gia tri N: ");
//                    new _2_6_soNguyenTo(BigInteger.valueOf(BigInteger.scanner.nextBigInteger());
//                    break;
                case "12":
                    System.out.println("Nhap gia tri N: ");
                    new _2_7_soChinhPhuong(scanner.nextDouble());
                    break;

                case "13":
                    _2_8_soDoiXung doiXung = new _2_8_soDoiXung();
                    doiXung.nhap();
                    doiXung.ketQua();
                    break;

//                case "14":
//                    System.out.println("Nhap gia tri N: ");
//                    new _2_9_inSoNguyenTo(scanner.nextInt());
//                    break;
//                case "15":
//                    _2__10_soHoanHaoNhoHon1000 hoanHao = new _2__10_soHoanHaoNhoHon1000();
//                    hoanHao.ketQua();
//                    break;
//
                case "16":
                    System.out.println("Nhap gia tri N: ");
                    new _2__11_nSoFibonacci(scanner.nextInt());
                    break;
//
                case "17":
                    System.out.println("Nhap gia tri N: ");
                    new _2__12_kiemTraFibonacci(scanner.nextInt());
                    break;
//                
//                case "18":
//                    _2__13_uocChung_boiChung UCLNBCNN = new _2__13_uocChung_boiChung();
//                    UCLNBCNN.nhap();
//                    UCLNBCNN.ketQua();
//                    break;
                case "0":
                    cont = false;
                    System.out.println("GAME OVER");
                    return;

                default:
                    System.out.println("Khong co truong hop nay. \nVui long nhap lai");
                    break;
            }

            System.out.println("\nNhan phim bat ky va ENTER de tiep tuc ...");
            scanner.next();
        }

    }

}
