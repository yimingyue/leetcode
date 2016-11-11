package leetcode.PalindromeLinkedList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/17/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode second = partition(head);
        second = reverse(second);
        ListNode p = head;
        ListNode q = second;
        while (p != null && q != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }

    private ListNode partition(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode r = head;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            r = slow;
            slow = slow.next;
        }
        r.next = null;
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode r = null;
        ListNode p = head;
        ListNode q = head;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = r;
            r = q;
        }
        return q;
    }
}
