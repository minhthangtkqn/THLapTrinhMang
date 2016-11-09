/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh5;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author TLDs
 */
class ExcuteString2 extends Thread {

    String inp;

    public ExcuteString2(String inp) {
        this.inp = inp;
    }

    public void run() {
        //standardlize 
        inp = inp.trim();
        inp = inp.replaceAll("  ", " ");
        //split
        String[] temp = inp.split(" ");

        //print 1 word per line
        System.out.println("In moi tu tren mot hang: ");
        for (int i = 0; i < temp.length; i++) {
            System.out.println("" + temp[i]);
        }
        //count 
        System.out.println("So tu co trong chuoi vua nhap: " + temp.length);

        //sort
        Arrays.sort(temp);
        System.out.println("Tan so xuat hien cac tu: ");
        int count = 1;
        for (int i = 0; i < temp.length; i++) {
            try {
                while (temp[i].equals(temp[i + 1])) {
                    count++;
                    i++;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                //do nothing
            }
            System.out.println("" + temp[i] + " xuat hien " + count + " lan.");
            count = 1;
        }

    }
}

public class Bai3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Moi nhap chuoi~: ");
        String inp = scanner.nextLine();

        ExcuteString2 excuteString2 = new ExcuteString2(inp);
        excuteString2.start();
    }
}
