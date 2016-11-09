/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh5;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author TLDs
 */
class Matrix extends Thread {

    int arr[][];
    int m;
    int n;

    public Matrix(int[][] arr) {
        this.arr = arr;
        m = arr.length;
        n = arr[0].length;
    }

    public void run() {
        //Cau b: tich cac so boi 3 cua dong dau tien 
        int mul = 1;
        for (int i = 0; i < n; i++) {
            if (arr[0][i] % 3 == 0) {
                mul *= arr[0][i];
            }
        }
        if (mul == 1) {
            System.out.println("Dong dau tien khong co so boi 3.");
        } else {
            System.out.println("Tich cac so boi 3 cua dong dau tien la: " + mul);
        }

        //Cau c: Mang 1 chieu arr2[i] cac phan tu lon nhat cua tung hang
        System.out.println("Mang X[i] cac phan tu lon nhat cua tung hang: ");
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < m; i++) {
            int max = arr[i][0];
            for (int j = 0; j < n; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
            arr2[i] = max;
            System.out.print(" " + arr2[i]);
        }
        //Cau d: Xoa phan tu dau tien cua mang arr2[i]
        System.out.println(" ");
        System.out.println("Mang X[i] sao khi xoa phan tu dau tien: ");
        for (int i = 0; i < arr2.length - 1; i++) {
            arr2[i] = arr2[i + 1];
            System.out.print(" " + arr2[i]);
        }

    }
}

public class Bai5 {

    public static void main(String[] args) {
        //cau a: initialize arr[][]
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int m = 6;
        int n = 9;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = rand.nextInt(20);
            }
        }
        Matrix matrix = new Matrix(arr);
        matrix.start();
    }

}
