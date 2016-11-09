/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiGiuaKy;

/**
 *
 * @author TLDs
 */
public class MatrixNumbers {

    private boolean[][] check;
    private int[][] value;

    public MatrixNumbers(int n) {
        check = new boolean[n][n];
        value = new int[n][n];
    }

    public int getValue(int hang, int cot) {
        return value[hang][cot];
    }

    public boolean getCheck(int hang, int cot) {
        return check[hang][cot];
    }

    public void setValue(int hang, int cot, int value) {
        this.value[hang][cot] = value;
    }

    public void setCheck(int hang, int cot, boolean check) {
        this.check[hang][cot] = check;
    }

    public void toggleCheck(int hang, int cot) {
        if (this.check[hang][cot] == true) {
            this.check[hang][cot] = false;
        } else {
            this.check[hang][cot] = true;
        }
    }

}
