package leetcode.ReorderList;

import org.junit.Test;

/**
 * Created by ymyue on 10/20/15.
 */
public class TestSolution2 {
    @Test
    public void test0() {
        Solution2 solution2 = new Solution2();
        int n = 2;
        ListNode[] arr = new ListNode[n];
        for (int i = 0; i < n; i++)
            arr[i] = new ListNode(i);
        for (int i = 0; i < n-1; i++)
            arr[i].next = arr[i+1];
        solution2.reorderList(arr[0]);
    }
}
