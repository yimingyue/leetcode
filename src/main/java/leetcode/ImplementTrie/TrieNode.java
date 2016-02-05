package leetcode.ImplementTrie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 12/31/15.
 */
public class TrieNode {
    Map<Character, TrieNode> childs;
    Character ch;
    boolean leaf;
    public TrieNode() {
        childs = new HashMap<>();
        leaf = false;
        ch = ' ';
    }
}
