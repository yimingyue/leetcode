package leetcode.SortList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 5/22/16.
 */
public class Solution5 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode q = partition(head);
        p = sortList(p);
        q = sortList(q);
        return merge(p, q);
    }

    private ListNode merge(ListNode p, ListNode q) {
        ListNode head = new ListNode(0);
        ListNode r = head;
        while (p != null || q != null) {
            if (p == null) {
                r.next = q;
                break;
            } else if (q == null) {
                r.next = p;
                break;
            } else if (p.val <= q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        return head.next;
    }

    // head is not null is guaranteed by the sortList function
    private ListNode partition(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
        }
        p = q.next;
        q.next = null;
        return p;
    }
}

/*
Time complexity:
    O(nlgn)
    recursive function T(n) = O(n) + 2 * T(n/2) + O(n) = 2 * T(n/2) + O(n)
    master theorem: T(n) = aT(n/b) + f(n)
        if f(n) = O(n^logb(a-e)) for some constant e > 0, Then T(n) = O(nlogb(a))
        if f(n) = O(n^logb(a)), then T(n) = O(nlogb(a)lgn)
        if f(n) = O(n^logb(a+e)) for some constant e> 0, and if af(n/b) <= cf(n) for c < 1 and sufficiently large n,
            then T(n) = O(f(n))
    In each of the three cases compare f(n) with nlogb(a), if nlogb(a) is larger, then it's O(nlogba). If f(n) is larger, then it's O(f(n)).
    If equals, it's O(nlgn)
    a = 2
    b = 2
    f(n) = c*n = O(nlog2(2))= O(nlogb(a)). Then T(n) = O(nlog2(2)lgn) = O(nlgn)

Space complexity:
    O(n) - not including the programming stack
    a = 2, b = 2, f(n) = 1, n^log2(2-1) = n. T(n) = O(nlogb(a)) = O(n)
 */
