package leetcode.SudokuSolver;

import leetcode.common.utils.Utils;

/**
 * Created by ymyue on 6/11/16.
 */
public class Solution3 {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        Utils.print(board);
        for (int i = row; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == row && j < col)
                    continue;
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        board[i][j] = c;
                        if (isValid(board, i, j) && solve(board, i, j+1)) {
                            return true;
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char[][]board, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j])
                return false;
            if (k != j && board[i][k] == board[i][j])
                return false;
            if ((i/3*3+ k/3 != i || (j/3*3)+ k%3 != j) && board[i][j] == board[i/3*3+k/3][j/3*3+k%3])
                return false;
        }
        return true;
    }
}
