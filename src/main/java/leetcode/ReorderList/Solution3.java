package leetcode.ReorderList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/17/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution3 {
    public void reorderList(ListNode head) {
        ListNode half = partition(head);
        half = reverse(half);
        merge(head, half);
    }

    private ListNode partition(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head.next;
        ListNode fast = head.next;
        ListNode r = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            r = slow;
            slow = slow.next;
        }
        r.next = null;
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode r = null;
        ListNode q = head;
        ListNode p = head;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = r;
            r = q;
        }
        return q;
    }

    private void merge(ListNode p, ListNode q) {
        ListNode r = null;
        ListNode t = null;
        while (p != null) {
            if (q != null) {
                r = p.next;
                p.next = q;
                t = q.next;
                q.next = r;
                p = r;
                q = t;
            } else {
                p = p.next;
            }
        }
    }
}
