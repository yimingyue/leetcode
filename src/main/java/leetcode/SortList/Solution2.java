package leetcode.SortList;

import leetcode.common.ds.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 5/21/14
 * Time: 9:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = partition(head);
        ListNode a = sortList(head);
        ListNode b = sortList(p);
        return merge(a, b);
    }

    private ListNode partition(ListNode head) {
        int i = 0;
        ListNode p = head;
        ListNode q = head;
        ListNode r = null;
        while (p != null) {
            p = p.next;
            i++;
            if (i % 2 == 0) {
                r = q;
                q = q.next;
            }
        }
        r.next = null;
        return q;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode head = null;
        ListNode p = null;
        while (a != null || b != null) {
            if (head == null) {
                if (a == null)
                    return b;
                if (b == null)
                    return a;
                if (a.val < b.val) {
                    p = a;
                    a = a.next;
                } else {
                    p = b;
                    b = b.next;
                }
                head = p;
            } else {
                if (a == null) {
                    p.next = b;
                    return head;
                }
                if (b == null) {
                    p.next = a;
                    return head;
                }
                if (a.val < b.val) {
                    p.next = a;
                    a = a.next;
                    p = p.next;
                } else {
                    p.next = b;
                    b = b.next;
                    p = p.next;
                }
            }
        }
        return head;
    }
}
