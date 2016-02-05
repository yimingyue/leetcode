package leetcode.MergeKSortedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 11/28/15.
 */
public class TestSolution {
    @Test
    public void test0() {
        ListNode node = new ListNode(1);
        ListNode[] arr = new ListNode[1];
        arr[0] = node;
        assertEquals(node, new Solution().mergeKLists(arr));
    }

    @Test
    public void test1() {
        ListNode node = new ListNode(1);
        ListNode[] arr = new ListNode[2];
        arr[0] = null;
        arr[1] = node;
        assertEquals(node, new Solution().mergeKLists(arr));
    }

    @Test
    public void test2() {
        ListNode[] arr = new ListNode[2];
        arr[0] = new ListNode(1);
        arr[1] = new ListNode(0);
        assertEquals(arr[0], new Solution().mergeKLists(arr));
    }
}
