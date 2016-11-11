package leetcode.ReverseNodesinkGroup;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/18/16.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode r = dummy;
        ListNode p = head;
        ListNode q = dummy;
        if (k < 2)
            return head;
        while (true) {
            int count = k;
            while (count > 0 && p != null) {
                q = p;
                p = p.next;
                count--;
            }
            if (count > 0)
                return dummy.next;
            q.next = null;
            ListNode t = r.next;
            reverse(t);
            t.next = p;
            r.next = q;
            r = t;
            q = r;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode r = null;
        ListNode p = head;
        ListNode q = null;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = r;
            r = q;
        }
        return q;
    }
}
