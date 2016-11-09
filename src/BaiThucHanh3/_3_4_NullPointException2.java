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
public class _3_4_NullPointException2 {

    static String s;

    public static void main(String[] args) {
        try {
            System.out.println(" The length of string s is :" + s.length());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Hello!");
        }
    }
}
