package leetcode.NQueenII;

/**
 * Created by ymyue on 4/20/14.
 */
public class Solution {
    public int totalNQueens(int n) {
        String [] str = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++)
                sb.append(".");
            str[i] = sb.toString();
        }
        return search(str, n, n);
    }

    private int search (String [] str, int n, int m) {
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
        int count = 0;
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder(str[n-m]);
            if (!matrix[n-m][j]) {
                sb.setCharAt(j, 'Q');
                str[n-m] = sb.toString();
                if (m == 1) {
                    return 1;
                } else {
                    count += search(str, n, m-1);
                }
                sb.setCharAt(j, '.');
                str[n-m] = sb.toString();
            }
        }
        return count;
    }
}
