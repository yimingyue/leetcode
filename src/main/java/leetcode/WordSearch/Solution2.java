package leetcode.WordSearch;

/**
 * Created by ymyue on 2/10/16.
 */
public class Solution2 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null)
            return false;
        int m = board.length;
        int n = board[0].length;
        int k = word.length();
        if (k > m * n)
            return false;
        boolean[][] visited = new boolean[m][n];
        boolean[][][] history = new boolean[m][n][k];
        char[] c = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, c, 0, visited, history))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] word, int k, boolean[][] visited, boolean[][][] history) {
        if (board[i][j] != word[k] || history[i][j][k])
            return false;
        visited[i][j] = true;
        if (k+1 == word.length)
            return true;
        if (i > 0 && !visited[i-1][j] && dfs(board, i-1, j, word, k+1, visited, history))
            return true;
        if (i < board.length-1 && !visited[i+1][j] && dfs(board, i+1, j, word, k+1, visited, history))
            return true;
        if (j > 0 && !visited[i][j-1] && dfs(board, i, j-1, word, k+1, visited, history))
            return true;
        if (j < board[i].length-1 && !visited[i][j+1] && dfs(board, i, j+1, word, k+1, visited, history))
            return true;
        visited[i][j] = false;
        history[i][j][k] = true;
        return false;
    }
}
