package leetcode.ReverseLinkedList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/16/16.
 * Time complexity: O(n)
 * Space compleixty: O(1)
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode r = null;
        ListNode q = head;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            q.next = r;
            r = q;
            q = p;
        }
        return r;
    }
}
