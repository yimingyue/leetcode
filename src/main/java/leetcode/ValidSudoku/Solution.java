package leetcode.ValidSudoku;

import java.util.Arrays;

/**
 * Created by ymyue on 6/9/16.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] rValid = new boolean[9];
        boolean[] cValid = new boolean[9];
        boolean[] sValid = new boolean[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(rValid, false);
            Arrays.fill(cValid, false);
            Arrays.fill(sValid, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rValid[board[i][j] - '1'])  return false;
                    rValid[board[i][j] - '1'] = true;
                }
                if (board[j][i] != '.') {
                    if (cValid[board[j][i] - '1'])  return false;
                    cValid[board[j][i] - '1'] = true;
                }
                int k = i/3*3 + j/3;
                int l = (i%3)*3 + j%3;
                if (board[k][l] != '.') {
                    if (sValid[board[k][l] - '1'])  return false;
                    sValid[board[k][l] - '1'] = true;
                }
            }
        }
        return true;
    }
}
