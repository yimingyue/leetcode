package leetcode.GameofLife;

/**
 * Created by ymyue on 7/9/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = countOfLiveNeighbors(board, i, j);
                if (isLiveCell(board, i, j)) {
                    if (count < 2)                  // under-populatioin
                        board[i][j] |= 0 << 1;
                    else if (count < 4)             // live on
                        board[i][j] |= 1 << 1;
                    else                            // over-population
                        board[i][j] |= 0 << 1;
                } else {
                    if (count == 3)                 // reproduction
                        board[i][j] |= 1 << 1;
                    else
                        board[i][j] |= 0 << 1;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int countOfLiveNeighbors(int[][] board, int i, int j) {
        int count = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0)
                    continue;
                count += isLiveCell(board, i+x, j+y) ? 1 : 0;
            }
        }
        return count;
    }

    private boolean isLiveCell(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length)
            return false;
        if (j < 0 || j >= board[i].length)
            return false;
        return (board[i][j] & 1) == 1;
    }
}
