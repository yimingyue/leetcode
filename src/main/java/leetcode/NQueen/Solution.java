package leetcode.NQueen;

import java.util.ArrayList;

/**
 * Created by ymyue on 4/20/14.
 */
public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> rList = new ArrayList<String[]> ();
        String [] str = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++)
                sb.append(".");
            str[i] = sb.toString();
        }
        search(str, n, rList, n);
        return rList;
    }
    private void search (String [] str, int n, ArrayList<String[]> rList, int m) {
        boolean [][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (str[i].charAt(j) == 'Q') {
                    for (int k = 0; k < n; k++) {
                        matrix[k][j] = true;
                        matrix[i][k] = true;
                        if (i+k < n && j+k < n)
                            matrix[i+k][j+k] = true;
                        if (i-k >= 0 && j-k >= 0)
                            matrix[i-k][j-k] = true;
                        if (i+k < n && j-k >= 0)
                            matrix[i+k][j-k] = true;
                        if (i-k >= 0 && j+k < n)
                            matrix[i-k][j+k] = true;
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder(str[n-m]);
            if (!matrix[n-m][j]) {
                sb.setCharAt(j, 'Q');
                str[n-m] = sb.toString();
                if (m == 1) {
                    String [] r = new String[n];
                    for (int k = 0; k < n; k++) {
                        r[k] = new String(str[k]);
                    }
                    rList.add(r);
                } else {
                    search(str, n, rList, m-1);
                }
                sb.setCharAt(j, '.');
                str[n-m] = sb.toString();
            }
        }
    }
}
