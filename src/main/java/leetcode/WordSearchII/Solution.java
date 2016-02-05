package leetcode.WordSearchII;

import java.util.*;

/**
 * Created by ymyue on 12/31/15.
 */
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> rList = new ArrayList<> ();
        if (board.length == 0 || board[0].length == 0)
            return rList;
        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);
        Set<String> set = new HashSet<> ();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(set, board, i, j, trie, "");
            }
        }
        rList.addAll(set);
        return rList;
    }

    private void dfs(Set<String> set, char[][] board, int i, int j, Trie trie, String cur) {
        String next = cur + board[i][j];
        if (trie.startsWith(next)) {
            if (trie.search(next))
                set.add(next);
            board[i][j] = '0';
            if (i > 0 && board[i-1][j] != '0')
                dfs(set, board, i-1, j, trie, next);
            if (i < board.length-1 && board[i+1][j] != '0')
                dfs(set, board, i+1, j, trie, next);
            if (j > 0 && board[i][j-1] != '0')
                dfs(set, board, i, j-1, trie, next);
            if (j < board[i].length-1 && board[i][j+1] != '0')
                dfs(set, board, i, j+1, trie, next);
            board[i][j] = next.charAt(next.length()-1);
        }
    }

    class TrieNode {
        char ch;
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
        public TrieNode() {
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (p.children[ch-'a'] == null) {
                    TrieNode node = new TrieNode();
                    node.ch = ch;
                    node.isWord = (i == word.length()-1);
                    p.children[ch-'a'] = node;
                }
                p = p.children[ch-'a'];
            }
            p.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (p.children[ch-'a'] == null)
                    return false;
                p = p.children[ch-'a'];
            }
            return p.isWord;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (p.children[ch-'a'] == null)
                    return false;
                p = p.children[ch-'a'];
            }
            return true;
        }
    }
}
