package leetcode.WordBreakII;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/29/14
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestWordBreakII {
    Solution3 solution = new Solution3();
    @Test
    public void Test1() {
        String str = "a";
        Set<String> dict = new HashSet<String>();
        dict.add(str);
        assertEquals(solution.wordBreak(str, dict).size(), 1);
    }

    @Test
    public void Test2() {
        String str = "catsanddog";
        Set<String> dict = new HashSet<String>();
        String [] strings = {"cat","cats","and","sand","dog"};
        for (String string : strings) {
            dict.add(string);
        }
        assertEquals(solution.wordBreak(str, dict).size(), 2);
    }
}
