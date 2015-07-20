package leetcode.GenerateParentheses;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 5/24/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        List<String> rList = new Solution().generateParenthesis(4);
        List<String> expected = Arrays.asList("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()");
        Collections.sort(rList);
        Collections.sort(expected);
        assertEquals(rList, expected);
    }
}
