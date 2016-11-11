package leetcode.WordSearchII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 7/9/16.
 * Time complexity:
 *  - O(m*n) - build Trie tree. m is number of words, n is average length of the word
 *  - O(x*y*n)
 */
public class SolutionTrieNode {
    class TrieNode {
        char ch;
        boolean isEndOfWord;
        TrieNode[] childs;
        public TrieNode(char ch) {
            this.ch = ch;
            isEndOfWord = false;
            childs = new TrieNode[26];
        }
    }

    private void addToTrie(TrieNode root, String word) {
        for (char ch : word.toCharArray()) {
            if (root.childs[ch-'a'] == null) {
                root.childs[ch-'a'] = new TrieNode(ch);
            }
            root = root.childs[ch-'a'];
        }
        root.isEndOfWord = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode('r');
        for (String word : words)
            addToTrie(root, word);
        List<String> wordsFound = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                searchWordInBoard(board, i, j, root, wordsFound, "");
            }
        }
        return wordsFound;
    }

    private void searchWordInBoard(char[][] board, int i, int j, TrieNode root, List<String> wordsFound, String s) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '1')
            return;
        char ch = board[i][j];
        if (root.childs[ch-'a'] == null)
            return;
        root = root.childs[ch-'a'];
        s += ch;
        if (root.isEndOfWord) {
            root.isEndOfWord = false;
            wordsFound.add(s);
        }
        board[i][j] = '1';      // mark as visited
        searchWordInBoard(board, i-1, j, root, wordsFound, s);
        searchWordInBoard(board, i+1, j, root, wordsFound, s);
        searchWordInBoard(board, i, j-1, root, wordsFound, s);
        searchWordInBoard(board, i, j+1, root, wordsFound, s);
        board[i][j] = ch;       // reset the char after backtracing
    }
}
