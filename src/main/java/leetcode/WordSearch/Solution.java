package leetcode.WordSearch;

/**
 * Created by ymyue on 6/21/15.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        if (word.isEmpty())
            return true;
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, used, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][]board, int i, int j, boolean[][] used, String word, int index) {
        if (i < 0 || i >= board.length)
            return false;
        if (j < 0 || j >= board[0].length)
            return false;
        if (used[i][j])
            return false;
        if (word.charAt(index) != board[i][j])
            return false;
        if (index == word.length()-1)
            return true;
        used[i][j] = true;
        if (dfs(board, i+1, j, used, word, index+1) || dfs(board, i-1, j, used, word, index+1)
                || dfs(board, i, j+1, used, word, index+1) || dfs(board, i, j-1, used, word, index+1)) {
            return true;
        }
        used[i][j] = false;
        return false;
    }
}
