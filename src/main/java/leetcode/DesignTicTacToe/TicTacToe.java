package leetcode.DesignTicTacToe;

/**
 * Created by ymyue on 7/16/16.
 * Time complexity: O(n)
 * Space complexity: O(n^2)
 */
public class TicTacToe {
    private final int[][] grid;
    private final int n;
    private int winner = 0;
    private boolean win = false;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        this.grid = new int[n][n];
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
        if (win)
            return winner;
        grid[row][col] = player;
        boolean rowWin = true;
        boolean colWin = true;
        boolean diaWin = true;
        boolean rdiaWin = true;

        for (int i = 0; i < n; i++) {
            if (grid[row][i] != player)
                rowWin = false;
            if (grid[i][col] != player)
                colWin = false;
            if (row != col || grid[i][i] != player)
                diaWin = false;
            if (row != n-1-col || grid[i][n-1-i] != player)
                rdiaWin = false;
        }
        if (rowWin || colWin || diaWin || rdiaWin)
            winner = player;
        return winner;
    }
}
