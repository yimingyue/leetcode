package leetcode.RemoveInvalidParentheses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 11/28/15.
 */
public class TestSolution {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.removeInvalidParentheses("(a)())()").size());
    }
    @Test
    public void test1() {
        Solution s = new Solution();
        assertEquals(1, s.removeInvalidParentheses(")").size());
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        assertEquals(1, s.removeInvalidParentheses("(").size());
    }

    @Test
    public void test3() {
        Solution s = new Solution();
        assertEquals(2, s.removeInvalidParentheses("()())()").size());
    }

    @Test
    public void test4() {
        Solution s = new Solution();
        assertEquals(1, s.removeInvalidParentheses("((").size());
    }

    @Test
    public void test5() {
        Solution s = new Solution();
        assertEquals(1, s.removeInvalidParentheses(")()(").size());
    }


    @Test
    public void test6() {
        Solution s = new Solution();
        assertEquals(1, s.removeInvalidParentheses("(()(").size());
    }

    @Test
    public void test7() {
        Solution s = new Solution();
        assertEquals(2, s.removeInvalidParentheses(")(()c))(").size());
    }

    @Test
    public void test8() {
        Solution s = new Solution();
        assertEquals(2, s.removeInvalidParentheses(")((()((").size());
    }


    @Test
    public void test9() {
        Solution s = new Solution();
        assertEquals(1, s.removeInvalidParentheses("))").size());
    }

    @Test
    public void test10() {
        Solution s = new Solution();
        assertEquals(1, s.removeInvalidParentheses(")(f").size());
    }
}
