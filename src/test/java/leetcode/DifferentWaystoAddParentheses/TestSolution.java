package leetcode.DifferentWaystoAddParentheses;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ymyue on 8/3/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        String input = "2-1-1";
        List<Integer> rList = new Solution().diffWaysToCompute(input);
        assertEquals(2, rList.size());
    }


}
