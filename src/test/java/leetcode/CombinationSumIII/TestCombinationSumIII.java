package leetcode.CombinationSumIII;

import org.junit.Test;

import java.util.List;

/**
 * Created by ymyue on 11/2/15.
 */
public class TestCombinationSumIII {
    @Test
    public void test () {
        Solution s = new Solution();
        List<List<Integer>> rList = s.combinationSum3(2, 18);
    }

    @Test
    public void test1 () {
        Solution s = new Solution();
        List<List<Integer>> rList = s.combinationSum3(2, 6);
    }
}
