package leetcode.AddTwoNumbers;

import leetcode.common.ds.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static leetcode.common.utils.Utils.getArrayFromList;
import static leetcode.common.utils.Utils.getListFromArray;

/**
 * Created by ymyue on 6/16/16.
 */
public class TestSolution {
    Solution solution = new Solution();
    @Test
    public void test0() {
        ListNode l1 = getListFromArray(new int[] {7,0,3,6,7,3,2,1,5});
        ListNode l2 = getListFromArray(new int[] {9,2,5,5,6,1,2,2,4});
        Assert.assertArrayEquals(new int[] {6, 3, 8, 1, 4, 5, 4, 3, 9}, getArrayFromList(solution.addTwoNumbers(l1, l2)));
    }


}
