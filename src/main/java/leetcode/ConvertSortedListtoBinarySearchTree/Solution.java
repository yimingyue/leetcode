package leetcode.ConvertSortedListtoBinarySearchTree;

import ds.TreeNode;
import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/18/16.
 * Time complexity:
 *  T(n) = 2 * T(n/2) + O(n)
 *  master theorem: T(n) = a * T(n/b) + f(n)
 *  comparing n^logb(a) with f(n)
 *  equals: O(nlgn)
 * Space complexity: O(1) without stack, O(logn) with stack
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        ListNode p = partition(head);
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }

    private ListNode partition(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode r = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            r = slow;
            slow = slow.next;
        }
        r.next = null;
        return slow;
    }
}
