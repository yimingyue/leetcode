package leetcode.OddEvenLinkedList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/17/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode q = head.next;
        ListNode r = head.next;
        while (q != null && q.next != null) {
            p.next = q.next;
            p = p.next;
            q.next = p.next;
            q = q.next;
        }
        p.next = r;
        return head;
    }
}
