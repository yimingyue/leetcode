package leetcode.SortList;

import leetcode.common.ds.ListNode;
import leetcode.common.utils.Utils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ymyue on 5/22/16.
 */
public class TestSolution {
    SolutionBU solution = new SolutionBU();
    @Test
    public void test() {
        ListNode head = Utils.arrayToListNode(new int[]{3, 2, 4});
        assertTrue(Utils.assertLinkedListEquals(solution.sortList(head), Utils.arrayToListNode(new int[] {2, 3, 4})));
    }
}
