package leetcode.PartitionList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/18/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode p = head;
        ListNode q = dummy1;
        ListNode r = dummy2;
        while (p != null) {
            if (p.val < x) {
                q.next = p;
                q = q.next;
            } else {
                r.next = p;
                r = r.next;
            }
            p = p.next;
        }
        r.next = null;
        q.next = dummy2.next;
        return dummy1.next;
    }
}
