package leetcode.SwapNodesinPairs;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/17/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode r = null;
        while (p.next != null && p.next.next != null) {
            r = p.next.next;
            p.next.next = p.next.next.next;
            r.next = p.next;
            p.next = r;
            p = r.next;
        }
        return dummy.next;
    }
}
