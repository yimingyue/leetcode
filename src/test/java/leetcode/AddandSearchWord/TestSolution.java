package leetcode.AddandSearchWord;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by ymyue on 1/24/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        Solution s = new Solution();
        s.addWord("a");
        s.addWord("ab");
        assertTrue(s.search("a"));
        assertTrue(s.search("a."));
    }
}
