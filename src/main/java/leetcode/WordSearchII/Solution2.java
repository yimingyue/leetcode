package leetcode.WordSearchII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution2 {
    private static class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            word = null;
            this.children = new TrieNode[26];
        }
    }

    private void buildTree(TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode p = root;
            for (char ch : word.toCharArray()) {
                if (p.children[ch - 'a'] == null)
                    p.children[ch - 'a'] = new TrieNode();
                p = p.children[ch - 'a'];
            }
            p.word = word;
        }
    }

    private static final int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        if (board.length == 0 || board[0].length == 0)
            return new ArrayList<>(result);
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        TrieNode root = new TrieNode();
        buildTree(root, words);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dfs(result, board, visited, i, j, root);
        return new ArrayList<>(result);
    }

    private void dfs(Set<String> result, char[][] board, boolean[][] visited, int i, int j, TrieNode node) {
        char ch = board[i][j];
        node = node.children[ch-'a'];
        if (node == null)
            return;
        if (node.word != null)
            result.add(node.word);
        visited[i][j] = true;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x < 0 || x == board.length || y < 0 || y == board[x].length || visited[x][y])
                continue;
            else
                dfs(result, board, visited, x, y, node);
        }
        visited[i][j] = false;
    }
}
