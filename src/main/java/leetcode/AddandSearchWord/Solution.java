package leetcode.AddandSearchWord;

/**
 * Created by ymyue on 1/24/16.
 */
public class Solution {
    private class TrieNode {
        char ch;
        boolean isLeaf;
        TrieNode[] childs;
        public TrieNode(char c) {
            this.ch = c;
            this.isLeaf = false;
            this.childs = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode(' ');

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.childs[c-'a'] == null) {
                p.childs[c-'a'] = new TrieNode(c);
            }
            p = p.childs[c-'a'];
        }
        p.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode root) {
        if (word.isEmpty())
            return root.isLeaf;
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                String subWord = word.substring(i+1);
                for (TrieNode node : p.childs) {
                    if (node != null) {
                        if (search(subWord, node))
                            return true;
                    }
                }
                return false;
            } else {
                if (p.childs[c-'a'] == null)
                    return false;
                p = p.childs[c-'a'];
            }
        }
        return p.isLeaf;
    }
}
