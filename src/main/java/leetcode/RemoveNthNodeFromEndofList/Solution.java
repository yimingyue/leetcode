package leetcode.RemoveNthNodeFromEndofList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/16/16.
 * Time complexity: O(n)
 * Space compleixty: O(1)
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        while (p != null && n-- > 0) {
            p = p.next;
        }
        if (n > 0)
            throw new IllegalArgumentException();

        ListNode q = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode r = dummy;

        while (p != null) {
            p = p.next;
            r = q;
            q = q.next;
        }
        r.next = q.next;
        return dummy.next;
    }
}
