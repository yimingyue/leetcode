package leetcode.RemoveLinkedListElements;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/17/16.
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val == val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return dummy.next;
    }
}
