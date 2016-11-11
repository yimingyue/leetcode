package leetcode.RotateList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/17/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int length = getLength(head);
        if (length == 0)
            return head;
        k %= length;
        if (k == 0)
            return head;
        ListNode p = head;
        while (k-- > 0)
            p = p.next;
        ListNode r = null;
        ListNode t = p;
        ListNode q = head;
        while (p != null) {
            t = p;
            p = p.next;
            r = q;
            q = q.next;
        }
        r.next = null;
        t.next = head;
        return q;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
