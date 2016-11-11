package leetcode.LinkedListCycle;

import leetcode.common.ds.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/13/14
 * Time: 6:01 PM
 * Time complexity: O(n)
 * Space compleixty: O(1)
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
