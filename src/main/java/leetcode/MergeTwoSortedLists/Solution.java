package leetcode.MergeTwoSortedLists;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/16/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if (l1 != null)
            p.next = l1;
        else if (l2 != null)
            p.next = l2;
        return dummy.next;
    }
}
