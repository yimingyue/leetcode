package leetcode.SudokuSolver;

import org.junit.Test;

/**
 * Created by ymyue on 5/25/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        String [] strings = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        char [][] board = new char[9][9];
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j< 9; j++) {
                board[i][j] = strings[i].charAt(j);
            }
        }

        Solution2 solution2 = new Solution2();
        solution2.solveSudoku(board);
    }
}
