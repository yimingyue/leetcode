package leetcode.SortList;

import leetcode.common.ds.ListNode;
import org.junit.Test;

/**
 * Created by ymyue on 11/29/15.
 */
public class TestSolution4 {
    @Test
    public void test() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        head = new Solution4().sortList(head);
    }
}
