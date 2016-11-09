/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_3;

/**
 *
 * @author TLDs
 */
public class _3_2_NumberFormatException {

    static String thisYear = "2.015";

    public static void main(String[] args) {
        try {
            System.out.println("Next year :" + (Integer.parseInt(thisYear) + 1));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Hello");
    }
}
