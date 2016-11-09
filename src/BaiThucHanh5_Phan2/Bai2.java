/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh5_Phan2;

import java.util.Scanner;

/**
 *
 * @author TLDs
 */
class ExcuteString extends Thread {

    String inp;

    public ExcuteString(String inp) {
        this.inp = inp;
    }

    public void run() {
        System.out.println("Chuoi dao nguoc: " + new StringBuilder(inp).reverse());
        System.out.println("Chuyen sang chu hoa: " + inp.toUpperCase());
        System.out.println("Chuyen sang chu thuong: " + inp.toLowerCase());
        System.out.print("Chuyen hoa -> thuong, thuong -> hoa: ");
        char c;
        for (int i = 0; i < inp.length(); i++) {
            c = inp.charAt(i);
            if (c < 'a') {
                System.out.print((c + "").toLowerCase());
            } else {
                System.out.print((c + "").toUpperCase());
            }
        }
    }
}

public class Bai2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Moi nhap chuoi~: ");
        String inp = scanner.nextLine();

        ExcuteString excuteString = new ExcuteString(inp);
        excuteString.start();
    }
}
