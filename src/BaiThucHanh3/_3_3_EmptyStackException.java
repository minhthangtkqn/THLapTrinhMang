/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh3;

import java.util.*;

/**
 *
 * @author TLDs
 */
public class _3_3_EmptyStackException {

    public static void main(String[] args) {
        try {
            Stack st = new Stack();// tao mot doi tuong
            st.push("Hello");
            // st.push("Chao ban");
            System.out.println(st.pop());
            System.out.println(st.pop());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
