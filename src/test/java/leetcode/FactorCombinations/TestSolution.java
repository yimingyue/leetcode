package leetcode.FactorCombinations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/29/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        List<List<Integer>> rList = new ArrayList<>();
        rList.add(Arrays.asList(2, 6));
        rList.add(Arrays.asList(2, 2, 3));
        rList.add(Arrays.asList(3, 4));
        assertEquals(rList, new Solution().getFactors(12));
    }
}
