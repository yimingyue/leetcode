package SortList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/27/13
 * Time: 11:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same threesum.Solution2 instance will be reused for each test case.
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode half = split(head);
        head = mergeSort(head);
        half = mergeSort(half);
        return merge(head, half);
    }

    private ListNode split(ListNode head) {
        int i = 0;
        ListNode p = head;
        ListNode r = head;
        ListNode q = head;
        while (p != null) {
            p = p.next;
            if (i % 2 == 0) {
                q = r;
                r = r.next;
            }
            i = i + 1;
        }
        q.next = null;
        return r;
    }

    private ListNode merge(ListNode p, ListNode q) {
        if (p == null)
            return q;
        else if (q == null)
            return p;
        ListNode r;
        if (p.val > q.val) {
            r = p;
            p = q;
            q = r;
        }
        r = p;
        ListNode head = r;
        p = p.next;
        while (p!= null && q != null) {
            if (p.val < q.val) {
                r = p;
                p = p.next;
            } else {
                ListNode t = q.next;
                r.next = q;
                q.next = p;
                r = q;
                q = t;
            }
        }
        if (q != null) {
            r.next = q;
        }
        return head;
    }
}
