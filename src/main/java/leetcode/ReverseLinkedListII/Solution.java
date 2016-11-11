package leetcode.ReverseLinkedListII;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/17/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        int i = 1;
        while (i < m) {
            if (p == null)  throw new IllegalArgumentException();
            p = p.next;
            i++;
        }
        if (p == null)
            return dummy.next;
        ListNode s = p.next;
        ListNode r = null;
        ListNode q = p.next;
        ListNode t = p.next;
        while (i <= n) {
            if (t == null) throw new IllegalArgumentException();
            q = t;
            t = t.next;
            q.next = r;
            r = q;
            i++;
        }
        p.next = q;
        s.next = t;
        return dummy.next;
    }
}
