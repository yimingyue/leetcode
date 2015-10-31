package leetcode.SortList;

/**
 * Created by ymyue on 10/22/15.
 */
public class Solution3 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode q = partition(head);
        head = sortList(head);
        q = sortList(q);
        return merge(head, q);
    }

    private ListNode partition(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return null;
        ListNode p = head;
        ListNode r = null;
        int i = 0;
        while (head != null) {
            head = head.next;
            if (i % 2 == 0) {
                r = p;
                p = p.next;
            }
            i++;
        }
        r.next = null;
        return p;
    }

    private ListNode merge(ListNode p, ListNode q) {
        ListNode head = null;
        ListNode r = null;
        while (p != null || q != null) {
            ListNode next = null;
            if (p == null) {
                if (head == null)
                    return q;
                else {
                    r.next = q;
                    return head;
                }
            } else if (q == null) {
                if (head == null)
                    return p;
                else {
                    r.next = p;
                    return head;
                }
            } else if (p.val < q.val) {
                next = p;
                p = p.next;
            } else {
                next = q;
                q = q.next;
            }
            if (head == null) {
                head = next;
                r = head;
            }
            else {
                r.next = next;
                r = r.next;
            }
        }
        return head;
    }
}
