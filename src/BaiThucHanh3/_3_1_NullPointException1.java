/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh3;

/**
 *
 * @author TLDs
 */
class _3_1_NullPointException1 {

    static String s;

    public static void main(String[] args) {
        try {
            System.out.println("The length of string is :" + s.length());
            System.out.println("Hello");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
