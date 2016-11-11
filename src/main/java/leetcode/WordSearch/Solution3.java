package leetcode.WordSearch;

/**
 * Created by ymyue on 6/22/16.
 * DFS
 * Time complexity: O(mn4^k)
 * Space complexity: O(mn)
 */
public class Solution3 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty())
            return false;
        char[] w = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, w, 0, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] w, int k, boolean[][] visited) {
        if (k == w.length)
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j] || board[i][j] != w[k])
            return false;
        visited[i][j] = true;
        if (dfs(board, i-1, j, w, k+1, visited) || dfs(board, i+1, j, w, k+1, visited) ||
                dfs(board, i, j-1, w, k+1, visited) || dfs(board, i, j+1, w, k+1, visited))
            return true;
        visited[i][j] = false;
        return false;
    }
}
