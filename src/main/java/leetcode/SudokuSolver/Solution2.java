package leetcode.SudokuSolver;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 5/25/15.
 */
public class Solution2 {
    public void solveSudoku(char[][] board) {
        if (!isValidSudoku(board))
            return;
        if (board == null || board.length != 9)
            return;
        solve(board);
        print(board);
    }

    private boolean solve(char[][] board) {
        if (!isValidSudoku(board))
            return false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch ++) {
                        board[i][j] = ch;
                        if (solve(board))
                            return true;
                    }
                    board[i][j] =  '.';
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (board[i][j] < '0' || board[i][j] > '9')
                    return false;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        for (int j = 0; j < 9; j++) {
            set.clear();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.')
                    continue;
                if (board[i][j] < '0' || board[i][j] > '9')
                    return false;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.clear();
                for (int k = 3 * i; k < 3 * i + 3; k++) {
                    for (int l = 3 * j; l < 3 * j + 3; l++) {
                        if (board[k][l] == '.')
                            continue;
                        if (board[k][l] < '0' || board[k][l] > '9')
                            return false;
                        if (set.contains(board[k][l]))
                            return false;
                        set.add(board[k][l]);
                    }
                }
            }
        }
        return true;
    }

    private void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
}
