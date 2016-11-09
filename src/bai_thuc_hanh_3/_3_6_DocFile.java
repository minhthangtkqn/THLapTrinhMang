/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_3;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author TLDs
 */
public class _3_6_DocFile {

    public static void main(String[] args) {
        BufferedReader infile = null;
        String filename = "";
        String inLine;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print(" Hay nhap vao ten FILE can doc noi dung: ");
            filename = scanner.nextLine();
            infile = new BufferedReader(new FileReader(filename));
            inLine = infile.readLine();
            boolean firstLine = true;
            while (inLine != null) {
                if (firstLine) {
                    firstLine = false;
                    System.out.print(inLine);
                } else {
                    System.out.print("\n" + inLine);
                }
                inLine = infile.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex + "\n" + " File " + filename + " not found ");
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (infile != null) {
                    infile.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
