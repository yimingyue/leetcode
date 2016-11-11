package leetcode.WordSquares;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 10/18/16.
 */
public class SolutionTrie {
    public static class TrieNode {
        char ch;
        List<Integer> indexes;
        TrieNode[] children;

        public TrieNode(char c) {
            this.ch = c;
            this.children = new TrieNode[26];
            this.indexes = new ArrayList<>();
        }
    }

    private void addToTrie(TrieNode root, String word, int i) {
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            if (root.children[ch-'a'] == null)
                root.children[ch-'a'] = new TrieNode(ch);
            root.indexes.add(i);
            root = root.children[ch-'a'];
        }
    }

    private TrieNode root = new TrieNode(' ');

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words.length == 0)
            return result;
        int n = words[0].length();
        for (int i = 0; i < words.length; i++)
            addToTrie(root, words[i], i);
        helper(result, new ArrayList<>(), n, words);
        return result;
    }

    private void helper(List<List<String>> result, List<String> list, int n, String[] words) {
        String prefix = "";
        for (String str : list) {
            prefix += str.charAt(list.size());
        }
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null)
                return;
            node = node.children[ch - 'a'];
        }
        for (int idx : node.indexes) {
            list.add(words[idx]);
            if (list.size() == n)
                result.add(new ArrayList<>(list));
            else
                helper(result, list, n, words);
            list.remove(list.size()-1);
        }
    }
}
