package SudokuSolver;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/7/14
 * Time: 5:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        String [] strings = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        char [][] board = new char[9][9];
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j< 9; j++) {
                board[i][j] = strings[i].charAt(j);
            }
        }
        Solution s = new Solution();
        s.solveSudoku(board);
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j< 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
