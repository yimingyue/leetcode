package leetcode.InsertionSortList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/1/16.
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = null;
        ListNode cur = null;
        ListNode p = null;
        while (head != null) {
            p = head;
            head = head.next;
            pre = dummy;
            cur = dummy.next;
            while (cur != null && cur.val <= p.val) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = p;
            p.next = cur;
        }
        return dummy.next;
    }
    /**
     * Time complexity O(n2)
     * Space complexity O(1)
     */
}
