package leetcode.RemoveLinkedListElements;

import leetcode.MergeKSortedList.ListNode;

/**
 * Created by ymyue on 11/1/15.
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        if (head == null)
            return head;
        ListNode p = head.next;
        ListNode q = head;
        while (p != null) {
            if (p.val == val) {
                q.next = p.next;
                p = q.next;
            } else {
                q = p;
                p = q.next;
            }
        }
        return head;
    }
}
