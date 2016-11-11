package leetcode.GameofLife;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution2 {
    private static final int[][] neighbors =
            new int[][] {{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = numOfNeighbors(board, i, j);
                int next = board[i][j];
                if (count < 2)
                    next = 0;
                else if (count > 3)
                    next = 0;
                else if (count == 3)
                    next = 1;
                board[i][j] |= next << 1;
            }
        }
        nextGen(board);
    }

    private int numOfNeighbors(int[][] board, int i, int j) {
        int count = 0;
        for (int[] neighbor : neighbors) {
            int x = i + neighbor[0];
            int y = j + neighbor[1];
            if (x < 0 || x == board.length || y < 0 || y == board[x].length)
                continue;
            count += board[x][y] & 1;
        }
        return count;
    }

    private void nextGen(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
