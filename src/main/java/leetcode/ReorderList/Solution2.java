package leetcode.ReorderList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 10/20/15.
 */
public class Solution2 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode p = head;
        ListNode q = head;
        ListNode r = null;
        int i = 0;
        while (p != null) {
            p = p.next;
            if (i % 2 == 0) {
                r = q;
                q = q.next;
            }
            i++;
        }
        r.next = null;
        r = null;
        while (q != null) {
            p = q.next;
            q.next = r;
            r = q;
            q = p;
        }
        p = head;
        while (p != null && r != null) {
            q = p.next;
            p.next = r;
            p = r.next;
            r.next = q;
            r = p;
            p = q;
        }
    }
}
