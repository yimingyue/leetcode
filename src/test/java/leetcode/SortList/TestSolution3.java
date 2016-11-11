package leetcode.SortList;

import leetcode.common.ds.ListNode;
import org.junit.Test;

/**
 * Created by ymyue on 10/22/15.
 */
public class TestSolution3 {
    @Test
    public void test() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        head = new Solution3().sortList(head);
    }
}
