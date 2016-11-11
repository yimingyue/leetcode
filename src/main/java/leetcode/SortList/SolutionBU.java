package leetcode.SortList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 5/22/16.
 * Bottom up merge sort
 * https://leetcode.com/discuss/28594/bottom-recurring-with-space-complextity-time-complextity
 * http://algs4.cs.princeton.edu/22mergesort/
 */
public class SolutionBU {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = null;
        ListNode right = null;
        ListNode tail = null;
        for (int step = 1; step < length; step <<= 1) {
            tail = dummy;
            cur = dummy.next;
            while (cur != null) {
                left = cur;
                right = split(left, step);
                cur = split(right, step);
                tail = merge(left, right, tail);
            }
        }
        return dummy.next;
    }

    private ListNode split(ListNode head, int step) {
        if (head == null)
            return null;
        ListNode pre = null;
        while (head != null && step != 0) {
            pre = head;
            head = head.next;
            step--;
        }
        pre.next = null;
        return head;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode tail) {
        while (left != null || right != null) {
            if (left == null) {
                tail.next = right;
                right = right.next;
            } else if (right == null) {
                tail.next = left;
                left = left.next;
            } else if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        return tail;
    }
}
