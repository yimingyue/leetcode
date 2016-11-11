package leetcode.RemoveDuplicatesfromSortedListII;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/18/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.next == null || p.next.val != p.next.next.val) {
                p = p.next;
            } else {
                ListNode q = p.next.next;
                while (q != null && q.val == p.next.val)
                    q = q.next;
                p.next = q;
            }
        }
        return dummy.next;
    }
}
