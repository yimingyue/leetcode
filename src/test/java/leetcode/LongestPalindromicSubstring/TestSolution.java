package leetcode.LongestPalindromicSubstring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 5/17/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        String s = "ccc";
        assertEquals(s, new Solution().longestPalindrome(s));
    }
}
