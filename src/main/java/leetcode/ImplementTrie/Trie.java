package leetcode.ImplementTrie;

/**
 * Created by ymyue on 12/31/15.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            if (p.childs.containsKey(word.charAt(i)))
                p = p.childs.get(word.charAt(i));
            else {
                TrieNode q = new TrieNode();
                q.ch = word.charAt(i);
                p.childs.put(q.ch, q);
                p = q;
            }
        }
        p.leaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            if (!p.childs.containsKey(word.charAt(i)))
                return false;
            p = p.childs.get(word.charAt(i));
        }
        return p.leaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!p.childs.containsKey(prefix.charAt(i)))
                return false;
            p = p.childs.get(prefix.charAt(i));
        }
        return true;
    }
}
