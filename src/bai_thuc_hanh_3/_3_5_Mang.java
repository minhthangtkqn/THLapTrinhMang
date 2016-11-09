/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_3;

import java.util.Scanner;

/**
 *
 * @author TLDs
 */
public class _3_5_Mang {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            int i, k;
            double[] myarray;
            System.out.println("Nhap vao so phan tu cua mang");
            i = scanner.nextInt();
            myarray = new double[i];
            for (int j = 0; j < myarray.length; j++) {
                System.out.println(" Nhap vao gia tri phan tu thu " + j);
                myarray[j] = scanner.nextDouble();
            }
            System.out.println(" Hay nhap vao so thu tu phan tu can truy cap");
            k = scanner.nextInt();
            System.out.println(" Gia tri cua phan tu can truy cap la:" + myarray[k]);
        } catch (RuntimeException ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Dòng này thể nào cũng được in ra");
        }
    }
}
