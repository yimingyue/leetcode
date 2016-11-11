package leetcode.SortList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 11/29/15.
 */
public class Solution4 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy.next;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        ListNode q = null;
        ListNode tail = null;
        for (int step = 1; step < n; step <<= 1) {
            tail = dummy;
            while (tail.next != null) {
                p = split(tail.next, step);
                q = split(p, step);
                tail = merge (tail, tail.next, p);
                tail.next = q;
            }
        }
        return dummy.next;
    }

    private ListNode split(ListNode head, int step) {
        if (step == 0 || head == null)
            return null;
        int i = 0;
        ListNode p = null;
        while (i < step && head != null) {
            i++;
            p = head;
            head = head.next;
        }
        p.next = null;
        return head;
    }

    private ListNode merge(ListNode pre, ListNode p, ListNode q) {
        while (p != null || q != null) {
            if (p == null) {
                pre.next = q;
                pre = pre.next;
                q = q.next;
            } else if (q == null) {
                pre.next = p;
                pre = pre.next;
                p = p.next;
            }
            else if (p.val < q.val) {
                pre.next = p;
                pre = pre.next;
                p = p.next;
            } else {
                pre.next = q;
                pre = pre.next;
                q = q.next;
            }
        }
        return pre;
    }
}
