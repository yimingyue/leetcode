package leetcode.ReverseNodesinkGroup;

import leetcode.common.utils.Utils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 6/18/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class TestSolution {
    Solution solution = new Solution();
    @Test
    public void test0() {
        Assert.assertArrayEquals(new int[] {2, 1}, Utils.getArrayFromList(solution.reverseKGroup(Utils.getListFromArray(new int[]{1, 2}), 2)));
    }
}
