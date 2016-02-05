package leetcode.ImplementTrie;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by ymyue on 12/31/15.
 */
public class TestTrie {
    @Test
    public void test0() {
        Trie trie = new Trie();
        trie.insert("library");
        assertTrue(trie.search("library"));
        assertFalse(trie.search("libra"));
        assertTrue(trie.startsWith("libra"));
    }
}
