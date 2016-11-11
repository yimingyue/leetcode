package leetcode.DesignTicTacToe;

/**
 * Created by ymyue on 7/16/16.
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class TicTacToeImprove {
    int[][] rowCount;
    int[][] colCount;
    int[] diagCount;
    int[] rdiagCount;
    int winner;
    int n;

    /** Initialize your data structure here. */
    public TicTacToeImprove(int n) {
        rowCount = new int[n][3];
        colCount = new int[n][3];
        diagCount = new int[3];
        rdiagCount = new int[3];
        winner = 0;
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (winner == 0) {
            if (++rowCount[row][player] == n || ++colCount[col][player] == n || (row == col && ++diagCount[player] == n) || (row == n-1-col && ++rdiagCount[player] == n)) {
                winner = player;
            }
        }
        return winner;
    }
}
