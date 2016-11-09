/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh5_Phan2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author TLDs
 */
class ExcuteArray extends Thread {

    int[] arr;
    int k;
    int p;

    public ExcuteArray(int[] arr, int k, int p) {
        this.arr = arr;
        this.k = k;
        this.p = p;
    }

    public void run() {
        //sum of odd possitive numbers in array
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1 && arr[i] > 0) {//odd
                sum += arr[i];
            }
        }
        System.out.println("Tong cac so duong le trong mang la: " + sum);

        //print inex of k if k is in arr
        boolean exist = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                exist = true;
                System.out.println("k = " + k + " nam o vi tri " + (i + 1) + " trong mang.");
                break;
            }
        }
        if (exist == false) {
            System.out.println("k = " + k + " khong xuat hien trong mang");
        }

        //sort descentant
        Arrays.sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        //insert p
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > p) {

                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }

                arr[i] = p;
                break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}

public class Bai4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mang co bao nhieu phan tu : ");
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];// + 1 : slot for inserting p 
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Kiem tra k co thuoc mang hay khong, k = ");
        int k = scanner.nextInt();

        System.out.print("Chen p = ");
        int p = scanner.nextInt();

        ExcuteArray ea = new ExcuteArray(arr, k, p);
        ea.start();
    }

}
